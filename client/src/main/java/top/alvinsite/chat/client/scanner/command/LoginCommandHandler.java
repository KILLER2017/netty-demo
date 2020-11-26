package top.alvinsite.chat.client.scanner.command;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class LoginCommandHandler extends AbstractCommandHandler {

    @Override
    public boolean isSupport(String message) {
        return message.startsWith("login");
    }

    @Override

    public void handle(String message) {
        try {
            String body = message.split(" ")[1];
            String[] result = body.split("@");
            sendMessage(PacketUtils.loginReq(result[0], result[1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("command mode: login username@password, but your command text is [{}]. it is invalid!", message);
        }

    }
}
