package top.alvinsite.chat.server.server.init;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.server.server.handler.AuthHandler;
import top.alvinsite.chat.server.server.handler.ChatServerHandler;
import top.alvinsite.chat.server.server.handler.GroupChatReqHandler;
import top.alvinsite.chat.server.server.handler.HeartbeatRespHandler;

/**
 * @author Alvin
 */
public class ChatServerInitializer extends ChannelInitializer<Channel> {

    private ChatServerHandler chatServerHandler;

    public ChatServerInitializer() {
        this.chatServerHandler = new ChatServerHandler();
    }

    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline()
                //11 秒没有向客户端发送消息就发生心跳
                .addLast(new IdleStateHandler(11, 0, 0))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(ChatMessage.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new AuthHandler())
                .addLast(new HeartbeatRespHandler())
                .addLast(new GroupChatReqHandler())
                .addLast(chatServerHandler);
    }
}
