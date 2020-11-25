package top.alvinsite.chat.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.alvinsite.chat.client.client.ChatClient;
import top.alvinsite.chat.client.client.init.ChatClientInitializer;
import top.alvinsite.chat.client.config.properties.ChatServerProperties;
import top.alvinsite.chat.client.scanner.InputScan;


@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private ChatServerProperties chatServerProperties;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ChatClient chatClient = new ChatClient();
        chatClient.setChatServerProperties(chatServerProperties);
        chatClient.start();

        InputScan inputScan = new InputScan();
        inputScan.setChatClient(chatClient);
        Thread thread = new Thread(inputScan);
        thread.setName("scan-thread");
        thread.start();
    }
}
