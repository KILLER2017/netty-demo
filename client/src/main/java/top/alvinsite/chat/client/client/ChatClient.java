package top.alvinsite.chat.client.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.client.client.init.ChatClientInitializer;
import top.alvinsite.chat.client.config.properties.ChatServerProperties;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.packets.ReceiverType;

/**
 * @author Alvin
 */
@Slf4j
public class ChatClient {

    private SocketChannel channel;

    @Setter
    private ChatServerProperties chatServerProperties;

    @Setter
    private ChatClientInitializer chatClientInitializer;

    private EventLoopGroup group = new NioEventLoopGroup();



    public void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(chatClientInitializer);

        ChannelFuture future = bootstrap.connect(
                chatServerProperties.getHost(),
                chatServerProperties.getPort()
        ).sync();

        if (future.isSuccess()) {
            log.info("聊天客户端启动成功, connect to {}:{}", chatServerProperties.getHost(), chatServerProperties.getPort());
            channel = (SocketChannel) future.channel();
        }
    }

    public void close() {
        group.shutdownGracefully();
        log.info("聊天客户端关闭成功");
    }

    public void sendMessage(String content) {
        ChatMessage message = ChatMessage.newBuilder()
                .setType(MessageType.CHAT_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .setContent(content)
                .build();
        channel.writeAndFlush(message);
    }

    public void sendMessage() {
        ChatMessage message = ChatMessage.newBuilder()
                .setType(MessageType.CHAT_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .setReceiver("12345678")
                .setContent("hello")
                .build();
        channel.writeAndFlush(message);
    }
}
