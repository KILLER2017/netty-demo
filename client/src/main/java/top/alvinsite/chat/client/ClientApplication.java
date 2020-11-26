package top.alvinsite.chat.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.alvinsite.chat.client.client.ChatClient;
import top.alvinsite.chat.client.client.init.ChatClientInitializer;
import top.alvinsite.chat.client.config.properties.ChatServerProperties;
import top.alvinsite.chat.client.scanner.InputScan;
import top.alvinsite.chat.client.scanner.command.*;
import top.alvinsite.chat.common.utils.PacketUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    private List<ChatClient> clients = new ArrayList<>();

    @Autowired
    private ChatServerProperties chatServerProperties;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int num = 1000;
        for (int i = 1; i <= num; i++) {
            int port = 20000 + i;
            clients.add(createClient(port));
        }

        ChatClient chatClient = new ChatClient();
        chatClient.setChatServerProperties(chatServerProperties);
        chatClient.addHandler(new LoginCommandHandler())
                .addHandler(new LogoutCommandHandler())
                .addHandler(new PriChatCommandHandler())
                .addHandler(new GroupChatCommandHandler())
                .addHandler(new DefaultCommandHandler());
        chatClient.start();

        InputScan inputScan = new InputScan();
        inputScan.setChatClient(chatClient);
        Thread thread = new Thread(inputScan);
        thread.setName("scan-thread");
        thread.start();
    }

    private ChatClient createClient(int port) {
        ChatClient chatClient = new ChatClient();
        chatClient.setPort(port);
        chatClient.setChatServerProperties(chatServerProperties);
        chatClient.addHandler(new LoginCommandHandler())
                .addHandler(new LogoutCommandHandler())
                .addHandler(new PriChatCommandHandler())
                .addHandler(new GroupChatCommandHandler())
                .addHandler(new DefaultCommandHandler());
        chatClient.start();
        return chatClient;
    }
}
