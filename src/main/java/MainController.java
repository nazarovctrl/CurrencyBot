
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class MainController extends TelegramLongPollingBot {

    private Map<String, Contact> contactMap = new LinkedHashMap<>();
    private final Buttons buttons = new Buttons(this);

    private LinkedHashMap<Long, String> lastButtonCurrency = new LinkedHashMap<>();

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

        if (message.getContact() != null) {
            replyToContact(message);

            return;
        }

        if (message.getText().equals("/start")) {
            start(message, sendMessage);
            return;
        }

        if (!check(message, sendMessage)) {
            return;
        }

        message.setText(back(message));
        sendMessage = buttons.getButtonMessage(message);
        if (sendMessage.getText() != null) {
            sendMSG(sendMessage);
            return;
        }

        sendMessage = convertor(message);
        if (sendMessage.getText() == null) {
            sendMessage.setText("Mazgi nimabu");
        }

        sendMSG(sendMessage);


    }


    private SendMessage convertor(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        if (checkNumber(message.getText())) {
            String s = lastButtonCurrency.get(message.getChatId());
            double d = Double.parseDouble(message.getText());

            switch (s) {
                case "USD $(dollar) to UZS(so'm)":
                    sendMessage.setText(convertorToUsz(Valuate.getValuate("USD"), d));
                    break;

                case "UZS(so'm) to  USD $(dollar)":
                    sendMessage.setText(convertorToForeignCurrency(Valuate.getValuate("USD"), d));
                    break;
                case "RUB ₽(rubl) to UZS(so'm)":
                    sendMessage.setText(convertorToUsz(Valuate.getValuate("RUB"), d));
                    break;

                case "UZS(so'm) to RUB ₽(rubl)":
                    sendMessage.setText(convertorToForeignCurrency(Valuate.getValuate("RUB"), d));
                    break;
                case "UZS(so'm) to EUR €(yevro)":
                    sendMessage.setText(convertorToForeignCurrency(Valuate.getValuate("EUR"), d));
                    break;
                case "EUR €(yevro) to UZS(so'm)":
                    sendMessage.setText(convertorToUsz(Valuate.getValuate("EUR"), d));
                    break;
            }
        }
        return sendMessage;
    }

    private boolean checkNumber(String number) {

        for (int i = 0; i < number.length(); i++) {

            if (!number.substring(i, i + 1).matches("\\d") &&
                    !number.substring(i, i + 1).matches("[.]")) {
                return false;
            }


        }

        return true;
    }

    private String convertorToUsz(ResponseItem currency, double a) {

        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + Double.parseDouble(currency.getNominal()) * a + "* _" + currency.getCcy() + "_" + " - *" + Double.parseDouble(currency.getRate()) * a + "* " + "_" + "UZS" + "_";

    }

    private String convertorToForeignCurrency(ResponseItem currency, double a) {
        double d = a / Double.parseDouble(currency.getRate());
        d = d - d % 0.01;
        return "\uD83C\uDDEC\uD83C\uDDE7*En:* " + "_" + currency.getCcy() + "_" + "\n" +
                "\uD83C\uDDFA\uD83C\uDDFF*Uz:* " + "_" + currency.getCcyNm_UZ() + "_" + "\n" +
                "*" + a + "* _" + "UZS" + "_" + " - *" + d + "* " + "_" + currency.getCcy() + "_";

    }

    private void replyToContact(Message message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setParseMode(null);

        sendMessage.setText("Eslatib otaman qoidalarga amal qiling");
        KeyboardButton boshlashButton = new KeyboardButton("Boshlash");
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(boshlashButton);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        keyboardRowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMSG(sendMessage);

        sendMessage.setChatId(message.getChatId()
        );
        sendMessage.setText("Botdan foydalanish uchun quyidagi \nkannalga obuna boling ");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lst2 = new ArrayList<>();
        List<InlineKeyboardButton> lst = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Kanalga obuna bolish");
        inlineKeyboardButton.setCallbackData("kanal");
        inlineKeyboardButton.setUrl("https://t.me/space_coders_uz");

        lst.add(inlineKeyboardButton);
        lst2.add(lst);
        inlineKeyboardMarkup.setKeyboard(lst2);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMSG(sendMessage);
    }


    private void sendMSG(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean check(Message message, SendMessage sendMessage) {
        GetChatMember getChatMember = new GetChatMember("-1001550716634", message.getFrom().getId());
        ChatMember chatMember;
        try {
            chatMember = execute(getChatMember);
//            System.out.println(chatMember.getStatus());


        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        if (chatMember.getStatus().equalsIgnoreCase("left")) {

            sendMessage.setText("*Mazgi obuna bol kanalga!*");
            sendMessage.setChatId(message.getChatId());
            sendMSG(sendMessage);
            return false;
        }
        return true;
    }

    private void start(Message message, SendMessage sendMessage) {

        sendMessage.setText("Assalomu alaykum " + message.getChat().getFirstName() + " Valuate bot ga xushkelibsiz! ");
        KeyboardButton keyboardButton = new KeyboardButton("Contact jonatish");
        keyboardButton.setRequestContact(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(keyboardButton);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        keyboardRowList.add(keyboardRow);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMSG(sendMessage);

    }

    private String back(Message message) {
        if (message.getText().equals("ORTGA↩️")) {
            return "Boshlash";
        } else if (message.getText().equals("ORTGA\uD83D\uDD19")) {
            return "Valyuta kurslari\uD83D\uDCB9";
        }
        return message.getText();
    }


    public Map<String, Contact> getContactMap() {
        return contactMap;
    }

    public void setContactMap(Map<String, Contact> contactMap) {
        this.contactMap = contactMap;
    }

    public LinkedHashMap<Long, String> getLastButtonCurrency() {
        return lastButtonCurrency;
    }

    public void setLastButtonCurrency(LinkedHashMap<Long, String> lastButtonCurrency) {
        this.lastButtonCurrency = lastButtonCurrency;
    }
}