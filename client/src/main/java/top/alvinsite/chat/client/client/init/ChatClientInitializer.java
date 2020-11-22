package top.alvinsite.chat.client.client.init;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import top.alvinsite.chat.client.client.handler.ChatClientHandler;
import top.alvinsite.chat.common.packets.ChatMessage;

/**
 * @author Alvin
 */
public class ChatClientInitializer extends ChannelInitializer<Channel> {

    private ChatClientHandler chatClientHandler;

    public ChatClientInitializer() {
        chatClientHandler = new ChatClientHandler();
    }

    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline()
                .addLast(new IdleStateHandler(11, 0, 0))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(ChatMessage.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(chatClientHandler);
    }
}
