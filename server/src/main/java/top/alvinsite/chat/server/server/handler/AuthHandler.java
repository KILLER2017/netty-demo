package top.alvinsite.chat.server.server.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

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
        if (isLogin) {
            ctx.fireChannelRead(msg);
        } else if ("login".equals(msg)) {
            isLogin = true;
            log.info("登录成功");
            ctx.writeAndFlush(Unpooled.copiedBuffer("登录成功".getBytes()));
        } else if ("logout".equals(msg)) {
            isLogin = false;
            log.info("注销成功");
            ctx.writeAndFlush(Unpooled.copiedBuffer("注销成功".getBytes()));
        } else {
            log.info("未d登录，不往下处理报文. 消息: {}", msg);
            ctx.writeAndFlush(Unpooled.copiedBuffer("请登录".getBytes()));
        }

    }
}
