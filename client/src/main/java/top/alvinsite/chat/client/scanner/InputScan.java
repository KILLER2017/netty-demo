package top.alvinsite.chat.client.scanner;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.alvinsite.chat.client.client.ChatClient;


import java.util.Scanner;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2018/12/21 16:44
 * @since JDK 1.8
 */
@Slf4j
public class InputScan implements Runnable {

    private final static Logger LOGGER = LoggerFactory.getLogger(InputScan.class);

    @Setter
    private ChatClient chatClient;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();

            chatClient.handlerCommand(message);
        }
    }

    private void handleCommand(String message) {
        String command = message.split(" ")[0];
        switch (command) {
            case "login":
                log.info("登录指令");
                break;
            case "logout":
                log.info("注销指令");
                break;
            case "priChat":
                log.info("私聊指令");
                break;
            case "grpChat":
                log.info("群聊指令");
                break;
            default:
                log.info("错误指令");
        }
    }

}
