package ParseAndRequest;

import com.google.gson.JsonObject;
import domain.WikiPage;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataParserTest {

    @Test
    void parseData() throws Exception {
        String term = "soup";
        WikiPage page = new WikiPage();
        InputStream stream = page.wikiConnectionBuilder(term);
        DataParser parser = new DataParser();
        JsonObject query = parser.parseData(stream);
        assertNotNull(query);

    }
}