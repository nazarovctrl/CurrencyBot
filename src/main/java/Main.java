
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {


    public static void main(String[] args) {


        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            MainController mainController = new MainController();
            telegramBotsApi.registerBot(mainController);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
