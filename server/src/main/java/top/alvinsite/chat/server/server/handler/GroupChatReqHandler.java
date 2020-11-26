package top.alvinsite.chat.server.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.packets.ReceiverType;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
public class GroupChatReqHandler extends ChannelInboundHandlerAdapter {

    private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("ChannelGroups", GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CHANNEL_GROUP.add(ctx.channel());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        CHANNEL_GROUP.remove(ctx);
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ChatMessage message = (ChatMessage) msg;
        if (message.getType() == MessageType.CHAT_REQ && message.getReceiverType() == ReceiverType.GROUP) {

            String text = String.format("this is has %d client connection now", CHANNEL_GROUP.size());
            CHANNEL_GROUP.writeAndFlush(PacketUtils.privateChatResp("channelGroup", text));
            return;
        }
        super.channelRead(ctx, msg);
    }
}
