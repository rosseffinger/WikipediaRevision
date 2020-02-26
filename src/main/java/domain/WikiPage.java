package domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class WikiPage {
    private String input;

    public WikiPage(String input) {
        this.input = input;
    }

    public String getJsonString() throws IOException {

        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                input + "rvprop=timestamp|user&rvlimit=30&redirects");
        java.net.URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (http://www.cs.bsu.edu/; rdeffinger@bsu.edu)");
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
        String result = scanner.nextLine();
        return result;
    }
}
