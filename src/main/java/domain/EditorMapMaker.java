package domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class EditorMapMaker {
    public Map<String,Integer> makeEditorMap(JsonArray revisionsArray){
        Map<String, Integer> editors = new LinkedHashMap<>();
        for (int i = 0; i < revisionsArray.size(); i++) {
            JsonObject revision = revisionsArray.get(i).getAsJsonObject();
            String username = revision.get("user").getAsString();

            if(editors.containsKey(username)){
                Integer count = editors.get(username) + 1;
                editors.put(username,count);
            }else{
                editors.put(username,1);
            }
        }
        return editors;
    }
}
