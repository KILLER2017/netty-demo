package top.alvinsite.chat.client.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.client.client.init.ChatClientInitializer;
import top.alvinsite.chat.client.config.properties.ChatServerProperties;
import top.alvinsite.chat.client.scanner.command.AbstractCommandHandler;
import top.alvinsite.chat.client.scanner.command.CommandHandler;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.packets.ReceiverType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Alvin
 */
@Slf4j
public class ChatClient {

    private Bootstrap bootstrap;

    private SocketChannel channel;

    private ChannelFuture clientFuture;

    private final List<CommandHandler> commandHandlers = new ArrayList<>();



    @Setter
    private ChatServerProperties chatServerProperties;

    private static EventLoopGroup group = new NioEventLoopGroup();

    public ChatClient addHandler(AbstractCommandHandler handler) {
        commandHandlers.add(handler);
        handler.setClient(this);
        return this;
    }

    public void start() {
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChatClientInitializer(this));

        connect();
    }

    public void close() {
        group.shutdownGracefully();
        log.info("聊天客户端关闭成功");
    }

    public void connect() {
        if (channel != null && channel.isActive()) {
            return;
        }

        clientFuture = bootstrap.connect(chatServerProperties.getHost(), chatServerProperties.getPort());
        clientFuture.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                channel = (SocketChannel) future.channel();
                log.info("connect to server [{}:{}] successfully", chatServerProperties.getHost(), chatServerProperties.getPort());
            } else {
                log.error("Failed to connect to server, try connect again after 10s");
                future.channel().eventLoop().schedule(() -> connect(), 10, TimeUnit.SECONDS);
            }
        });
    }

    public void sendMessage(String content) {
        ChatMessage message = ChatMessage.newBuilder()
                .setType(MessageType.CHAT_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .setContent(content)
                .build();
        channel.writeAndFlush(message);
    }

    public void handlerCommand(String message) {
        for (CommandHandler handler: commandHandlers) {
            if (handler.isSupport(message)) {
                handler.handle(message);
                break;
            }
        }
    }

    public void sendMessage(ChatMessage message) {
        channel.writeAndFlush(message);
    }
}
