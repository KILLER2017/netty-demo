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

    public void sendMessage(Object object) {
        byte[] req = ((String)object).getBytes();
        channel.writeAndFlush(Unpooled.copiedBuffer(req));
    }

    public void sendMessage() {
        ChatMessage message = ChatMessage.newBuilder()
                .setType(2)
                .build();
        channel.writeAndFlush(message);
    }
}
