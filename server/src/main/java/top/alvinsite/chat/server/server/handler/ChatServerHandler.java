package top.alvinsite.chat.server.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

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
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("服务器：客户端上线");
        ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("服务器：客户端下线");
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
        byte[] req = ((String) msg).getBytes();
        ctx.writeAndFlush(Unpooled.copiedBuffer(req));
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
    }


}
