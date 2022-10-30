import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Valuate {

    public static ResponseItem getValuate(String ccy) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();

            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);

            return responses.stream().filter(responseItem -> responseItem.getCcy().equals(ccy)).findAny().orElse(null);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
