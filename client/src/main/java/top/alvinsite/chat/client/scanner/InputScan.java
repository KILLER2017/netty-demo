package top.alvinsite.chat.client.scanner;


import lombok.Setter;
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
public class InputScan implements Runnable {

    private final static Logger LOGGER = LoggerFactory.getLogger(InputScan.class);

    @Setter
    private ChatClient chatClient;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            if ("2".equals(message)) {
                chatClient.sendMessage();
            }
            chatClient.sendMessage(message);
        }
    }

}
