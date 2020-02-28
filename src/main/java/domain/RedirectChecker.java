package domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RedirectChecker {
    public String checkForRedirects(JsonObject query) {
        if (query.has("redirects")) {
            JsonArray array = query.getAsJsonArray("redirects");
            return array.get(0).getAsJsonObject().get("to").getAsString();
        } else {
            return null;
        }
    }
}
