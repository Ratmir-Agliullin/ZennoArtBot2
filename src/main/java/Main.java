import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

/**
 * Created by Аглиуллины on 03.09.2017.
 */
public class Main {


    public static void main(String[] args) {


        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotManager());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

//        Parser parser = new Parser();
//        try {
//            parser.writeStringInFile("tsretxtrxo");
//            System.out.println("Done!");
//            Thread.sleep(10000);
//            System.out.println(parser.getStringFromFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
