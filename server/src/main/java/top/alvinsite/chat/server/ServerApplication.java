package top.alvinsite.chat.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.alvinsite.chat.server.config.properties.ChatServerProperties;
import top.alvinsite.chat.server.server.ChatServer;
import top.alvinsite.chat.server.server.init.ChatServerInitializer;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    @Autowired
    private ChatServerProperties chatServerProperties;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ChatServer chatServer = new ChatServer();
        chatServer.setChatServerProperties(chatServerProperties);
        chatServer.setChatServerInitializer(new ChatServerInitializer());
        chatServer.start();
    }
}
