package top.alvinsite.chat.server.utils;

import top.alvinsite.chat.common.model.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alvin
 */
public class SessionHolder {

    private static final Map<String, User> SESSION_MAP = new ConcurrentHashMap<>(16);

    public static void saveSession(String userId, User user){
        SESSION_MAP.put(userId, user);
    }

    public static void removeSession(String userId){
        SESSION_MAP.remove(userId) ;
    }
}
