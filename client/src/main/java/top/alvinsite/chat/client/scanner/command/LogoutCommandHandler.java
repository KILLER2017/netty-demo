package top.alvinsite.chat.client.scanner.command;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import top.alvinsite.chat.common.utils.PacketUtils;

/**
 * @author Alvin
 */
@Slf4j
public class LogoutCommandHandler extends AbstractCommandHandler {
    @Override
    public boolean isSupport(String message) {
        return message.startsWith("logout");
    }

    @Override
    @SneakyThrows
    public void handle(String message) {
        sendMessage(PacketUtils.logoutReq());
    }
}
