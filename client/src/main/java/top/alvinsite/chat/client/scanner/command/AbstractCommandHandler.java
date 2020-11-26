package top.alvinsite.chat.client.scanner.command;

import top.alvinsite.chat.client.client.ChatClient;
import top.alvinsite.chat.client.scanner.InputScan;
import top.alvinsite.chat.common.packets.ChatMessage;

/**
 * @author Alvin
 */
public abstract class AbstractCommandHandler implements CommandHandler {

    private ChatClient client;

    public void setClient(ChatClient client) {
        this.client = client;
    }

    public void doHandler(String message) {
        if (isSupport(message)) {
            handle(message);
        }
    }

    public void sendMessage(ChatMessage message) {
        client.sendMessage(message);
    }
}
