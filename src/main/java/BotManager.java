import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.updateshandlers.SentCallback;

import java.io.IOException;
import java.io.Serializable;


/**
 * Created by Аглиуллины on 12.09.2017.
 */
public class BotManager extends TelegramLongPollingBot {
private String buffer=null;
private String CHANNEL_NAME="@ZennoArtChannel";
private int flag=0;
    @Override
    public void onUpdateReceived(Update update) {
//        Message message = update.getMessage();
//        while (true) {
//            if (message.getText() != null && flag==2) {
//                SendText(CHANNEL_NAME, message.getText());
//                flag = 1;
//            }
//            else
//                execute();
//        }
    }


    public BotManager() {
        String currentPostId = null;
        while (true) {

            Parser parser = new Parser();
            Document doc = null;
            try {
                doc = Jsoup.connect("https://vk.com/zennoart").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentPostId = parser.getPostId(0, doc);
            try {
                Thread.sleep(60000);
                if (parser.getStringFromFile().equals(currentPostId)) {

                } else {
                    //написать метод в botService, который будет все данные собирать и отправлять в бот
                    parser.writeStringInFile(currentPostId);
                    SendText(CHANNEL_NAME, BotService.putPostInBot());
                }
                // System.out.println(currentPostId);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "ZennoArtBot";
    }

    @Override
    public String getBotToken() {
        return "428706480:AAF6Al_WXGF1r50F-p1GjTERQV5Z-sqq8vg";
    }

    public void SendText(String chat_id,  String out){



        SendMessage message = new SendMessage().setChatId(chat_id).setText(out);


        try {

            sendMessage(message); // Sending our message object to user

        } catch (TelegramApiException e) {

            e.printStackTrace();

        }

    }


}
