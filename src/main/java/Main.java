import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by Аглиуллины on 03.09.2017.
 */
public class Main {


    public static void main(String[] args) {
//        Parser parser = new Parser();
//        parser.getPostId();

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotManager());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
