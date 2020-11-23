package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class AuthHandler extends ChannelInboundHandlerAdapter {

    private boolean isLogin = false;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (isLogin) {
            ctx.fireChannelActive();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ChatMessage message = (ChatMessage) msg;

        if (isLogin) {
            ctx.fireChannelRead(msg);
        } else if (message.getType() == MessageType.LOGIN_REQ) {
            isLogin = true;
            log.info("登录成功");
            ctx.writeAndFlush(PacketUtils.loginResp());
        } else if (message.getType() == MessageType.LOGOUT_REQ) {
            isLogin = false;
            log.info("注销成功");
            ctx.writeAndFlush(PacketUtils.logoutResp());
        } else {
            log.info("未d登录，不往下处理报文. 消息: {}", msg);
            ctx.writeAndFlush(PacketUtils.othersResp("请先登录"));
        }

    }
}
