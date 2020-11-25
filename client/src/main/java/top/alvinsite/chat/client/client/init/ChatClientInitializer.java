package top.alvinsite.chat.client.client.init;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import top.alvinsite.chat.client.client.ChatClient;
import top.alvinsite.chat.client.client.handler.ChatClientHandler;
import top.alvinsite.chat.client.client.handler.HeartbeatReqHandler;
import top.alvinsite.chat.common.packets.ChatMessage;

import java.util.concurrent.TimeUnit;

/**
 * @author Alvin
 */
public class ChatClientInitializer extends ChannelInitializer<Channel> {

    private ChatClient client;



    public ChatClientInitializer(ChatClient client) {
        this.client = client;
    }

    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline()
                .addLast(new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(ChatMessage.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new HeartbeatReqHandler(client))
                .addLast(new ChatClientHandler());
    }
}
