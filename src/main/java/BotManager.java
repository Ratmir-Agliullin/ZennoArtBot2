import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
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
private String CHANNEL_NAME="@channel1ByRadrigo";
    @Override
    public void onUpdateReceived(Update update) {

    }

    public BotManager() {
        Parser parser = new Parser();
        Document doc =null;
        try {
         doc = Jsoup.connect("https://vk.com/unwebsiteinrussian").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String currentPostId = parser.getPostId(0,doc);
        try {
            if(parser.getStringFromFile().equals(currentPostId)){

            }
            else
            {
                //написать метод в botService, который будет все данные собирать и отправлять в бот
                parser.writeStringInFile(currentPostId);
                SendText(CHANNEL_NAME,BotService.putPostInBot());
            }
            System.out.println(currentPostId);
        } catch (IOException e) {
            e.printStackTrace();
        }
//            for(int i=0;i<3;i++) {
//                try {
//                    Thread.sleep(60000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                parser.getPostId();
//                try {
//                    Document doc = Jsoup.connect("https://vk.com/unwebsiteinrussian").get();
//                    SendText("@channel1ByRadrigo", parser.getPostText(2, doc) + "\n" + parser.getVideoPostFormIndex(2, doc));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

    }

    @Override
    public String getBotUsername() {
        return "Bot2";
    }

    @Override
    public String getBotToken() {
        return "367015082:AAHDEcfBder_4Z_oY5LWygwa3qtJlWhzE28";
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
