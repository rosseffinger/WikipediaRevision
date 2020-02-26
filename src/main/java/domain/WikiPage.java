package domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WikiPage {
    InputStream input;

    public WikiPage(String scanner) {
        this.input = input;
    }

    public InputStream WikiPage(String input) throws IOException {
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles= " + input+
                    "Soup&rvprop=timestamp|user&rvlimit=30&redirects");
            java.net.URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Revision Tracker/0.1 (http://www.cs.bsu.edu/; rdeffinger@bsu.edu)");
            return connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
