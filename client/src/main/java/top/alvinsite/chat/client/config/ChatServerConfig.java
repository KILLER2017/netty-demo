package top.alvinsite.chat.client.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.alvinsite.chat.client.config.properties.ChatServerProperties;

/**
 * @author Alvin
 */
@Configuration
@EnableConfigurationProperties(ChatServerProperties.class)
public class ChatServerConfig {
}
