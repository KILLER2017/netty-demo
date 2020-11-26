package top.alvinsite.chat.client.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.utils.PacketUtils;

import java.util.UUID;

/**
 * 聊天消息处理器
 * @author Alvin
 */
@Slf4j
@ChannelHandler.Sharable
public class ChatClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("客户端：已连接服务器");
        String username = String.valueOf(UUID.randomUUID());
        String password = String.valueOf(UUID.randomUUID());
        ctx.writeAndFlush(PacketUtils.loginReq(username, password));
        ctx.fireChannelActive();
    }

    /**
     * 对于每个传入的消息都要调用
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("收到消息：{}", msg);
        ctx.fireChannelRead(msg);
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

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
