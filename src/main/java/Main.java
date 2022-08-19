
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    private static final Logger LOGGER2 = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER2.info("START");
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            MainController mainController = new MainController();
            telegramBotsApi.registerBot(mainController);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
