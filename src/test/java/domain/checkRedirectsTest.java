package domain;

import ParseAndRequest.DataParser;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class checkRedirectsTest {

    @Test
    void checkForRedirects() throws Exception {
        String term = "soup";
        WikiPage page = new WikiPage();
        InputStream stream = page.wikiConnectionBuilder(term);
        DataParser parser = new DataParser();
        JsonObject query = parser.parseData(stream);

        checkRedirects checker = new checkRedirects();
        String redirects = checker.checkForRedirects(query);

        }

}