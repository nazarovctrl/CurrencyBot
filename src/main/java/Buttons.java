import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
    private final MainController mainController;

    public Buttons(MainController mainController) {
        this.mainController = mainController;
    }

    public SendMessage getButtonMessage(Message message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        if (message.getText().equals("Boshlash")) {
            boshlash(sendMessage);
        } else if (message.getText().equals("Valyuta kurslari\uD83D\uDCB9")) {
            valuate(sendMessage);
        } else if (message.getText().equals("USD $(dollar)\uD83D\uDCB5")) {
            usdButton(sendMessage);
        } else if (message.getText().equals("RUB ₽(rubl)")) {
            rubButton(sendMessage);
        } else if (message.getText().equals("EUR €(yevro)\uD83D\uDCB6")) {
            eurButton(sendMessage);
        } else if (message.getText().equals("Biz haqimizda\uD83D\uDCC3")) {
            info(sendMessage);
        } else if (message.getText().equals("UZS(so'm) to  USD $(dollar)")) {
            uzsToUsd(sendMessage, message);
        } else if (message.getText().equals("USD $(dollar) to UZS(so'm)")) {
            usdToUzs(sendMessage, message);
        } else if (message.getText().equals("UZS(so'm) to RUB ₽(rubl)")) {
            uszToRub(sendMessage, message);
        } else if (message.getText().equals("RUB ₽(rubl) to UZS(so'm)")) {
            rubToUzs(sendMessage, message);
        } else if (message.getText().equals("UZS(so'm) to EUR €(yevro)")) {
            uzsToEur(sendMessage, message);
        } else if (message.getText().equals("EUR €(yevro) to UZS(so'm)")) {
            eurToUzs(sendMessage, message);
        }
        return sendMessage;
    }

    private SendMessage uzsToUsd(SendMessage sendMessage, Message message) {
        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());

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

        return sendMessage;

    }

    private SendMessage usdToUzs(SendMessage sendMessage, Message message) {
        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());
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

        return sendMessage;
    }

    private SendMessage uszToRub(SendMessage sendMessage, Message message) {
        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());
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

        return sendMessage;
    }

    private SendMessage rubToUzs(SendMessage sendMessage, Message message) {
        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());
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

        return sendMessage;
    }

    private SendMessage uzsToEur(SendMessage sendMessage, Message message) {

        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());
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

        return sendMessage;
    }

    private SendMessage eurToUzs(SendMessage sendMessage, Message message) {
        mainController.getLastButtonCurrency().put(message.getChatId(), message.getText());
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

        return sendMessage;
    }

    private SendMessage boshlash(SendMessage sendMessage) {
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
        return sendMessage;
    }

    private SendMessage valuate(SendMessage sendMessage) {

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
        return sendMessage;
    }

    private SendMessage usdButton(SendMessage sendMessage) {

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
        return sendMessage;
    }

    private SendMessage rubButton(SendMessage sendMessage) {
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
        return sendMessage;

    }

    private SendMessage eurButton(SendMessage sendMessage) {
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

        return sendMessage;
    }

    private SendMessage info(SendMessage sendMessage) {
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setText("\uD83E\uDD16_Bot:_ *Nazarov Azimjon*\uD83E\uDDD1\u200D\uD83D\uDCBB _tomonidan yaratilgan_ \n" +
                "\uD83D\uDCF1_Telegram:_ *@Nazarov22222*");
        return sendMessage;
    }

    private String createText(ResponseItem currency) {

        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + currency.getNominal() + "* _" + currency.getCcy() + "_" + " - *" + currency.getRate() + "* " + "_" + "UZS" + "_";

    }
}


