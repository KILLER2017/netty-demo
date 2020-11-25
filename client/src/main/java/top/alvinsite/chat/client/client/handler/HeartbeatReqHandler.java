package top.alvinsite.chat.client.client.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.client.client.ChatClient;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class HeartbeatReqHandler extends ChannelInboundHandlerAdapter {

    private ChatClient client;

    private static final ChatMessage HEARTBEAT_PACKET = PacketUtils.heartbeatReq();

    public HeartbeatReqHandler(ChatClient client) {
        this.client = client;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            // 发送心跳消息，并在发送失败时关闭该连接
            ctx.writeAndFlush(HEARTBEAT_PACKET).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        } else {
            // 不是IdleStateEvent事件，传递给下一个ChannelInboundHandler
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ChatMessage message = (ChatMessage) msg;
        if (message.getType() == MessageType.HEARTBEAT_RESP) {
            log.info("收到心跳响应：{}", message);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.error("loss connection. attempts to connect to server again");
        client.connect();
    }
}
