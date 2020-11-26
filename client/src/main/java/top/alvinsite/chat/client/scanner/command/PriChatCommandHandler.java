package top.alvinsite.chat.client.scanner.command;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.packets.ChatMessage;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class PriChatCommandHandler extends AbstractCommandHandler {
    @Override
    public boolean isSupport(String message) {
        return message.startsWith("priChat ");
    }

    @Override
    @SneakyThrows
    public void handle(String message) {
        try {
            String[] result = message.split(" ")[1].split("@");
            ChatMessage message1 = PacketUtils.privateChatReq(result[1], result[0]);
            sendMessage(message1);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("command mode: priChat message@username, but your command text is [{}]. it is invalid!", message);
        }

    }
}
