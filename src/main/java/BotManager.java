import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import static java.awt.DefaultKeyboardFocusManager.sendMessage;

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

    public void SendText(Long chat_id,  String out){



        SendMessage message = new SendMessage().setChatId(chat_id).setText(out);


        try {

            sendMessage(message); // Sending our message object to user

        } catch (TelegramApiException e) {

            e.printStackTrace();

        }

    }
}
