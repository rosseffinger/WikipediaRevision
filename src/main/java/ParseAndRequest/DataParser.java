package ParseAndRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import domain.UserAndTime;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataParser{
    public JsonArray revisionsParse(InputStream input) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(input);
        JsonElement rootElement = parser.parse(reader);

        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisionsArray = null;
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionsArray = entryObject.getAsJsonArray("revisions");
        }

        return revisionsArray;
    }

    List<UserAndTime> createRevisionsList(JsonArray revisionsArray){
        List<UserAndTime> revisionsList = new ArrayList<UserAndTime>();
        //ConvertLocalTime convertTime = new ConvertLocalTime();
        String username = null;
        String timestamp = null;

        for(JsonElement rev : revisionsArray) {
            JsonObject revObject = rev.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry : revObject.entrySet()) {
                String entryKey = entry.getKey();
                JsonElement entryElement = entry.getValue();
                if (entryKey.equals("user")) {
                    username = entryElement.getAsString();
                }
               // else if (entryKey.equals("timestamp")) {
                 //   timestamp = convertTime.convertLocalTime(entryElement.getAsString());
                }
            }

            UserAndTime userandtime = new UserAndTime(username, timestamp);
            revisionsList.add(userandtime);
            return revisionsList;

        }

    JsonArray redirectsParser(InputStream input) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(input);
        JsonElement rootElement = parser.parse(reader);

        JsonObject rootObject = rootElement.getAsJsonObject();
        return rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
    }

    /*List<Redirect> createRedirectsList(JsonArray redirectsArray) {
        List<Redirect> redirectsList = new ArrayList<>();
        String from = null;
        String to = null;

        for(JsonElement red : redirectsArray) {
            JsonObject redirectObject = red.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry : redirectObject.entrySet()) {
                String entryKey = entry.getKey();
                JsonElement entryElement = entry.getValue();
                if(entryKey.equals("from")) {
                    from = entryElement.getAsString();
                }
                else if(entryKey.equals("to")) {
                    to = entryElement.getAsString();
                }
            }

            Redirect redirect = new Redirect(from, to);
            redirectsList.add(redirect);
        }
        return redirectsList;
    }*/
}