package domain;

import com.google.gson.JsonArray;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class EditorSorter {
    public StringBuilder sortEditors(JsonArray revisionsArray){
        RevisionMapMaker revisionMapMaker = new RevisionMapMaker();
        EditorMapMaker editorMapMaker = new EditorMapMaker();
        Map<String,Instant> revisionMap = revisionMapMaker.makeRevisionMap(revisionsArray);
        Map<String,Integer> editorMap = editorMapMaker.makeEditorMap(revisionsArray);

        ArrayList<Editors> editors = new ArrayList<>();

        Iterator<Map.Entry<String, Integer>> iterator = editorMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> element = iterator.next();
            String username = element.getKey();
            int revisions = element.getValue();
            Instant timestamp = revisionMap.get(element.getKey());
            editors.add(new Editors(username, revisions, timestamp));
        }

        editors.sort(new sortByEdits());

        StringBuilder result = new StringBuilder(editors.size() + " editors returned\n");

        for(Editors editor : editors){
            String username = editor.username;
            Instant timestamp = editor.timestamp;
            int revisions = editor.revisions;
            result.append("Username: "+username + " | Timestamp: "+timestamp+" | Revisions: "+revisions+"\n");
        }
        return result;
    }
}
