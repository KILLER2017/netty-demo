package top.alvinsite.chat.client.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 聊天客户端配置
 * @author Alvin
 */
@Data
@ConfigurationProperties(ChatClientProperties.PREFIX)
public class ChatClientProperties {

    public static final String PREFIX = "chat.client";

    /**
     * 端口号
     */
    private int port = 12345;
}
