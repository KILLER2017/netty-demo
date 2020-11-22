package top.alvinsite.chat.client.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 聊天服务器配置
 * @author Alvin
 */
@Data
@ConfigurationProperties(ChatServerProperties.PREFIX)
public class ChatServerProperties {
    public static final String PREFIX = "chat.server";

    /**
     * 主机号
     */
    private String host = "127.0.0.1";

    /**
     * 端口号
     */
    private int port = 12345;
}
