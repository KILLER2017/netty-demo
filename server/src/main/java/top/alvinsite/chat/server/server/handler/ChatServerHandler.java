package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.model.entity.User;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.packets.ReceiverType;
import top.alvinsite.chat.common.utils.PacketUtils;
import top.alvinsite.chat.server.utils.SessionHolder;

import java.nio.channels.SocketChannel;

/**
 * 聊天消息处理器
 * @author Alvin
 */
@Slf4j
@ChannelHandler.Sharable
public class ChatServerHandler extends ChannelInboundHandlerAdapter {

    static final String ECHO_REQ = "Hello, this is server";

    private byte[] req;



    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("服务器：客户端[{}]上线", ctx.channel().remoteAddress());
        // ctx.writeAndFlush(PacketUtils.othersResp(ECHO_REQ));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        log.info("服务器：客户端[{}]下线", ctx.channel().remoteAddress());
    }

    /**
     * 对于每个传入的消息都要调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("收到消息：{}", msg);
        ChatMessage message = (ChatMessage) msg;
        if (message.getType() == MessageType.CHAT_REQ && message.getReceiverType() == ReceiverType.USER) {
            User user = SessionHolder.getUser((NioSocketChannel) ctx.channel());
            NioSocketChannel socketChannel = SessionHolder.get(message.getReceiver());
            assert user != null;
            socketChannel.writeAndFlush(PacketUtils.privateChatResp(user.getUsername(), message.getContent()));
        }
        // ctx.writeAndFlush(PacketUtils.privateChatResp("system", "receive message"));
    }

    /**
     * 通知ChannelInboundHandler最后一次对channelRead()的调用是当前批量读取中的最后一条消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * 在读取操作期间， 有异常抛出时会调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        log.info("未知异常：{}", cause.getMessage());
        ctx.close();
    }
}
