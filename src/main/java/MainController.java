import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class MainController extends TelegramLongPollingBot {


    private LinkedHashMap<Long, String> currency = new LinkedHashMap<>();


    private static final Logger LOGGER2 = LoggerFactory.getLogger(MainController.class);

    @Override
    public String getBotUsername() {
        return "@currency_onlinebot";
    }

    @Override
    public String getBotToken() {
        return "5640888708:AAGEwdIiowZVOnSznWrkxG90qEcTVIwDBPs";
    }

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setParseMode(ParseMode.MARKDOWN);

        sendMessage.setText("*Mazgi nima bu*");
        if (message.getText().equals("ORTGA↩️")) {
            //codee
            message.setText("Boshlash");
        } else if (message.getText().equals("ORTGA\uD83D\uDD19")) {
            message.setText("Valyuta kurslari\uD83D\uDCB9");
        }

        if (message.getText().equals("/start")) {

            sendMessage.setText("Assalomu alaykum " + message.getChat().getFirstName() + " Valuate bot ga xushkelibsiz! ");
            KeyboardButton keyboardButton = new KeyboardButton("Boshlash");
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(keyboardButton);
            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("Boshlash")) {

            sendMessage.setText("*Tanlang*");
            KeyboardButton keyboardButton = new KeyboardButton("Valyuta kurslari\uD83D\uDCB9");
            KeyboardButton keyboardButton1 = new KeyboardButton("Biz haqimizda\uD83D\uDCC3");
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(keyboardButton);
            keyboardRow.add(keyboardButton1);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("Valyuta kurslari\uD83D\uDCB9")) {


            sendMessage.setText("Valyutani tanlang\uD83D\uDCB9");
            KeyboardRow keyboardRow = new KeyboardRow();

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA↩️");
            exitRow.add(exit);


            KeyboardButton usdButton = new KeyboardButton("USD $(dollar)\uD83D\uDCB5");
            keyboardRow.add(usdButton);

            KeyboardButton rubButton = new KeyboardButton("RUB ₽(rubl)");
            keyboardRow.add(rubButton);

            KeyboardButton eurButton = new KeyboardButton("EUR €(yevro)\uD83D\uDCB6");
            keyboardRow.add(eurButton);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


        } else if (message.getText().equals("USD $(dollar)\uD83D\uDCB5")) {


            String text = createText(Valuate.getValuate("USD"));
            sendMessage.setText(text);


            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardButton uzsToUsd = new KeyboardButton("UZS(so'm) to  USD $(dollar)");
            keyboardRow.add(uzsToUsd);

            KeyboardButton usdToUzs = new KeyboardButton("USD $(dollar) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


        } else if (message.getText().equals("RUB ₽(rubl)")) {

            String text = createText(Valuate.getValuate("RUB"));

            sendMessage.setText(text);

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardButton uzsToUsd = new KeyboardButton("UZS(so'm) to RUB ₽(rubl)");
            keyboardRow.add(uzsToUsd);

            KeyboardButton usdToUzs = new KeyboardButton("RUB ₽(rubl) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


        } else if (message.getText().equals("EUR €(yevro)\uD83D\uDCB6")) {
            String text = createText(Valuate.getValuate("EUR"));
            sendMessage.setText(text);

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardButton uzsToUsd = new KeyboardButton("UZS(so'm) to EUR €(yevro)");
            keyboardRow.add(uzsToUsd);

            KeyboardButton usdToUzs = new KeyboardButton("EUR €(yevro) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


        } else if (message.getText().equals("Biz haqimizda\uD83D\uDCC3")) {

            sendMessage.setText("\uD83E\uDD16_Bot:_ *Nazarov Azimjon*\uD83E\uDDD1\u200D\uD83D\uDCBB _tomonidan yaratilgan_ \n" +
                    "\uD83D\uDCF1_Telegram:_ *@Nazarov22222*");


        } else if (message.getText().equals("UZS(so'm) to  USD $(dollar)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kriting*");

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();

            KeyboardButton usdToUzs = new KeyboardButton("USD $(dollar) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


        } else if (message.getText().equals("USD $(dollar) to UZS(so'm)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kriting*");

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();

            KeyboardButton uzsToUsd = new KeyboardButton("UZS(so'm) to  USD $(dollar)");
            keyboardRow.add(uzsToUsd);


            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("UZS(so'm) to RUB ₽(rubl)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kiriting*");
            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardButton usdToUzs = new KeyboardButton("RUB ₽(rubl) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("RUB ₽(rubl) to UZS(so'm)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kiriting*");

            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardButton usdToUzs = new KeyboardButton("UZS(so'm) to RUB ₽(rubl)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("UZS(so'm) to EUR €(yevro)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kiriting*");
            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();

            KeyboardButton usdToUzs = new KeyboardButton("EUR €(yevro) to UZS(so'm)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        } else if (message.getText().equals("EUR €(yevro) to UZS(so'm)")) {
            currency.put(message.getChatId(), message.getText());
            sendMessage.setText("*Miqdorni kiriting*");
            KeyboardRow exitRow = new KeyboardRow();
            KeyboardButton exit = new KeyboardButton("ORTGA\uD83D\uDD19");
            exitRow.add(exit);

            KeyboardRow keyboardRow = new KeyboardRow();

            KeyboardButton usdToUzs = new KeyboardButton("UZS(so'm) to EUR €(yevro)");
            keyboardRow.add(usdToUzs);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            keyboardRowList.add(keyboardRow);
            keyboardRowList.add(exitRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            replyKeyboardMarkup.setResizeKeyboard(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

        }


        String m = message.getText();
        boolean isNumber = true;
        for (int i = 0; i < m.length(); i++) {

            if (m.substring(i, i + 1).matches("[0-9]") || m.substring(i, i + 1).matches("[.]")) {
                continue;
            }

            isNumber = false;
            break;

        }
        if (isNumber) {
            String s = currency.get(message.getChatId());
            double d = Double.parseDouble(message.getText());
            if (s.equals("USD $(dollar) to UZS(so'm)")) {

                sendMessage.setText(convertor(Valuate.getValuate("USD"), d));
            } else if (s.equals("UZS(so'm) to  USD $(dollar)")) {

                sendMessage.setText(convertor2(Valuate.getValuate("USD"), d));
            } else if (s.equals("RUB ₽(rubl) to UZS(so'm)")) {
                sendMessage.setText(convertor(Valuate.getValuate("RUB"), d));
            } else if (s.equals("UZS(so'm) to RUB ₽(rubl)")) {
                sendMessage.setText(convertor2(Valuate.getValuate("RUB"), d));
            } else if (s.equals("UZS(so'm) to EUR €(yevro)")) {
                sendMessage.setText(convertor2(Valuate.getValuate("EUR"), d));
            } else if (s.equals("EUR €(yevro) to UZS(so'm)")) {
                sendMessage.setText(convertor(Valuate.getValuate("EUR"), d));
            }
        }


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public String createText(ResponseItem currency) {

        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + currency.getNominal() + "* _" + currency.getCcy() + "_" + " - *" + currency.getRate() + "* " + "_" + "UZS" + "_";

    }

    public String convertor(ResponseItem currency, double a) {

        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + Double.parseDouble(currency.getNominal()) * a + "* _" + currency.getCcy() + "_" + " - *" + Double.parseDouble(currency.getRate()) * a + "* " + "_" + "UZS" + "_";

    }

    public String convertor2(ResponseItem currency, double a) {
        double d = a / Double.parseDouble(currency.getRate());
        d = d - d % 0.01;
        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + a + "* _" + "UZS" + "_" + " - *" + d + "* " + "_" + currency.getCcy() + "_";

    }
}
