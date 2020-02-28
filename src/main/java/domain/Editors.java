package domain;

import java.time.Instant;
import java.util.Comparator;

public class Editors {
    String username;
    Integer revisions;
    Instant timestamp;


    public Editors(String username, Integer revisions, Instant timestamp) {
        this.username = username;
        this.revisions = revisions;
        this.timestamp = timestamp;
    }
}

class sortByEdits implements Comparator<Editors> {
    public int compare(Editors a, Editors b) {
        return b.revisions - a.revisions;
    }
}
