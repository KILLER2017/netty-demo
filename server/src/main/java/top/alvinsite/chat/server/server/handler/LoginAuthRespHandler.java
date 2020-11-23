package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alvin
 */
public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();

    private String[] whiteList = {"127.0.0.1", "192.168.31.84"};

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ChatMessage message = (ChatMessage) msg;

        // 如果是登录请求，则处理，否则透传
        if (MessageType.LOGIN_REQ == message.getType()) {

        }
    }

}
