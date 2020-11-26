package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class HeartbeatRespHandler extends ChannelInboundHandlerAdapter {

    private static final ChatMessage HEARTBEAT_PACKET = PacketUtils.heartbeatResp();

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            // 长时间未和客户端通信，断开连接
            log.info("长时间未通信，断开客户端[{}]连接", ctx.channel().remoteAddress());
            ctx.close();
            // 发送心跳消息，并在发送失败时关闭该连接
            // ctx.writeAndFlush(HEARTBEAT_PACKET).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        } else {
            // 不是IdleStateEvent事件，传递给下一个ChannelInboundHandler
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ChatMessage message = (ChatMessage) msg;
        if (message.getType() == MessageType.HEARTBEAT_REQ) {
            // log.info("收到心跳请求：{}", message);
            ctx.writeAndFlush(HEARTBEAT_PACKET);
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}
