package ParseAndRequest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
}