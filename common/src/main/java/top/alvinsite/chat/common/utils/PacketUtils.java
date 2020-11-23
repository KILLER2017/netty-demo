package top.alvinsite.chat.common.utils;

import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.packets.MessageType;
import top.alvinsite.chat.common.packets.ReceiverType;

/**
 * packet构造工具类
 * @author Alvin
 */
public class PacketUtils {

    /**
     * 登录请求包
     */
    public static ChatMessage loginReq(String username, String password) {
        return ChatMessage.newBuilder()
                .setType(MessageType.LOGIN_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .setContent(username + "#" + password)
                .build();
    }

    /**
     * 登录响应包
     */
    public static ChatMessage loginResp() {
        return ChatMessage.newBuilder()
                .setType(MessageType.LOGIN_RESP)
                .setReceiverType(ReceiverType.SYSTEM)
                .build();
    }

    /**
     * 注销请求包
     */
    public static ChatMessage logoutReq() {
        return ChatMessage.newBuilder()
                .setType(MessageType.LOGOUT_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .build();
    }

    /**
     * 注销响应包
     */
    public static ChatMessage logoutResp() {
        return ChatMessage.newBuilder()
                .setType(MessageType.LOGOUT_RESP)
                .setReceiverType(ReceiverType.SYSTEM)
                .build();
    }

    /**
     * 心跳请求包
     */
    public static ChatMessage heartbeatReq() {
        return ChatMessage.newBuilder()
                .setType(MessageType.HEARTBEAT_REQ)
                .setReceiverType(ReceiverType.SYSTEM)
                .build();
    }

    /**
     * 心跳响应包
     */
    public static ChatMessage heartbeatResp() {
        return ChatMessage.newBuilder()
                .setType(MessageType.HEARTBEAT_RESP)
                .setReceiverType(ReceiverType.SYSTEM)
                .build();
    }

    /**
     * 私聊请求包
     */
    public static ChatMessage privateChatReq(String receiver, String content) {
        return ChatMessage.newBuilder()
                .setType(MessageType.CHAT_REQ)
                .setReceiverType(ReceiverType.USER)
                .setReceiver(receiver)
                .setContent(content)
                .build();
    }

    /**
     * 私聊响应包
     */
    public static ChatMessage privateChatResp(String sender, String content) {
        return ChatMessage.newBuilder()
                .setType(MessageType.CHAT_RESP)
                .setReceiverType(ReceiverType.USER)
                .setReceiver(sender)
                .setContent(content)
                .build();
    }

    /**
     * 群聊请求包
     */


    public static ChatMessage othersResp(String content) {
        return ChatMessage.newBuilder()
                .setType(MessageType.OTHERS)
                .setReceiverType(ReceiverType.SYSTEM)
                .setContent(content)
                .build();
    }
}
