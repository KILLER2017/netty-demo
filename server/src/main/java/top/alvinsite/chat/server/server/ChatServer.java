package top.alvinsite.chat.server.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.server.config.properties.ChatServerProperties;
import top.alvinsite.chat.server.server.init.ChatServerInitializer;

/**
 * 聊天服务器
 * @author Alvin
 */
@Slf4j
public class ChatServer {

    private ChatServerProperties chatServerProperties;

    private ChatServerInitializer chatServerInitializer;

    public void setChatServerProperties(ChatServerProperties chatServerProperties) {
        this.chatServerProperties = chatServerProperties;
    }

    public void setChatServerInitializer(ChatServerInitializer chatServerInitializer) {
        this.chatServerInitializer = chatServerInitializer;
    }

    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    /**
     * 启动聊天服务器
     */
    public void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(chatServerInitializer);

        ChannelFuture future = bootstrap.bind(
                chatServerProperties.getHost(),
                chatServerProperties.getPort()
        ).sync();

        if (future.isSuccess()) {
            log.info("聊天服务器启动成功，bind at {}:{}", chatServerProperties.getHost(), chatServerProperties.getPort());
        }
    }

    /**
     * 关闭聊天服务器
     */
    public void close() {
        bossGroup.shutdownGracefully().syncUninterruptibly();
        workerGroup.shutdownGracefully().syncUninterruptibly();
        log.info("聊天服务器关闭成功");
    }
}
