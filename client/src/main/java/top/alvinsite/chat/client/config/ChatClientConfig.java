package top.alvinsite.chat.client.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.alvinsite.chat.client.config.properties.ChatClientProperties;

/**
 * @author Alvin
 */
@Configuration
@EnableConfigurationProperties(ChatClientProperties.class)
public class ChatClientConfig {
}
