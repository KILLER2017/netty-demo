package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.model.entity.User;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.utils.PacketUtils;
import top.alvinsite.chat.server.utils.SessionHolder;

import java.util.UUID;

/**
 * @author Alvin
 */
@Slf4j
public class AuthHandler extends ChannelInboundHandlerAdapter {
    private String userId;
    private boolean isLogin = false;



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ChatMessage message = (ChatMessage) msg;

        if (!isLogin && message.getType() != MessageType.LOGIN_REQ) {
            log.info("未登录，不往下处理报文. 消息: {}", msg);
            ctx.writeAndFlush(PacketUtils.othersResp("please login first"));
        }
        if (message.getType() == MessageType.LOGIN_REQ) {
            if (isLogin) {
                ctx.writeAndFlush(PacketUtils.othersResp("please logout first"));
                return;
            }
            isLogin = true;
            log.info("登录成功");

            String[] result = message.getContent().split("@");
            User user = new User();
            userId = String.valueOf(UUID.randomUUID());
            userId = result[0];
            user.setId(userId);
            user.setUsername(result[0]);
            user.setPassword(result[1]);
            SessionHolder.put(userId, (NioSocketChannel) ctx.channel());
            SessionHolder.saveSession(userId, user);

            ctx.writeAndFlush(PacketUtils.loginResp());
        } else if (message.getType() == MessageType.LOGOUT_REQ) {
            isLogin = false;
            log.info("注销成功");
            ctx.writeAndFlush(PacketUtils.logoutResp());
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionHolder.remove(userId);
        SessionHolder.removeSession(userId);
        super.channelInactive(ctx);
    }
}
