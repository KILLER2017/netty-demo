package top.alvinsite.chat.client.scanner.command;

/**
 * @author Alvin
 */
public interface CommandHandler {

    /**
     * 是否支持
     * @param message 消息
     * @return true/false
     */
    boolean isSupport(String message);

    /**
     * 处理消息逻辑
     * @param message 消息
     */
    void handle(String message);
}
