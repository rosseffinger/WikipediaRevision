package domain;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class WikiPage {
    public WikiPage(Scanner input) throws IOException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exsentences=1&exintro=&explaintext=&exsectionformat=plain&titles=" + input;
        InputStream is = con.getInputStream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream())) {
            String line = null;
            while(line = br.readline())

        }


    }

}

