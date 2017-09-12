import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * Created by Аглиуллины on 12.09.2017.
 */
public class BotManager extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "Bot2";
    }

    @Override
    public String getBotToken() {
        return "367015082:AAHDEcfBder_4Z_oY5LWygwa3qtJlWhzE28";
    }
}
