package top.alvinsite.chat.client.scanner.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alvin
 */
@Slf4j
public class DefaultCommandHandler extends AbstractCommandHandler {
    @Override
    public boolean isSupport(String message) {
        return true;
    }

    @Override
    public void handle(String message) {
        log.info("不支持的指令：{}", message);
    }
}
