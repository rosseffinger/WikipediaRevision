package ParseAndRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import domain.redirect;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataParser {
    public JsonObject parseData(InputStream input) {
        Reader reader = new InputStreamReader(input);
        JsonElement element = JsonParser.parseReader(reader);
        JsonObject object = element.getAsJsonObject();
        if (!object.has("batchcomplete")) {
            JsonObject query = object.getAsJsonObject("query");
            return query;
        } else {
            return null;
        }

    }

    JsonArray redirectsParser(InputStream input) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(input);
        JsonElement rootElement = parser.parse(reader);

        JsonObject rootObject = rootElement.getAsJsonObject();
        return rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
    }

    List<redirect> createRedirectsList(JsonArray redirectsArray) {
        List<redirect> redirectsList = new ArrayList<>();
        String from = null;
        String to = null;

        for (JsonElement red : redirectsArray) {
            JsonObject redirectObject = red.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : redirectObject.entrySet()) {
                String entryKey = entry.getKey();
                JsonElement entryElement = entry.getValue();
                if (entryKey.equals("from")) {
                    from = entryElement.getAsString();
                } else if (entryKey.equals("to")) {
                    to = entryElement.getAsString();
                }
            }

            redirect redirect = new redirect(from, to);
            redirectsList.add(redirect);
        }
        return redirectsList;
    }
}