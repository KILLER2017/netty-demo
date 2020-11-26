package top.alvinsite.chat.server.utils;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import top.alvinsite.chat.common.model.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alvin
 */
public class SessionHolder {
    private static final Map<String, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);
    private static final Map<String, User> SESSION_MAP = new ConcurrentHashMap<>(16);

    public static void saveSession(String userId, User user){
        SESSION_MAP.put(userId, user);
    }

    public static void removeSession(String userId){
        SESSION_MAP.remove(userId) ;
    }

    public static void put(String userId, NioSocketChannel socketChannel) {
        CHANNEL_MAP.put(userId, socketChannel);
    }

    public static NioSocketChannel get(String userId) {
        return CHANNEL_MAP.get(userId);
    }

    public static Map<String, NioSocketChannel> getRelationShip() {
        return CHANNEL_MAP;
    }

    public static void remove(String userId) {
        CHANNEL_MAP.remove(userId);
    }
    public static void remove(NioSocketChannel nioSocketChannel) {
        CHANNEL_MAP.entrySet().stream().filter(entry -> entry.getValue() == nioSocketChannel).forEach(entry -> CHANNEL_MAP.remove(entry.getKey()));
    }

    public static User getUser(NioSocketChannel nioSocketChannel) {
        for (Map.Entry<String, NioSocketChannel> entry : CHANNEL_MAP.entrySet()) {
            NioSocketChannel value = entry.getValue();
            if (nioSocketChannel == value){
                String key = entry.getKey();
                User user = SESSION_MAP.get(key);
                return user ;
            }
        }
        return null;

    }
}
