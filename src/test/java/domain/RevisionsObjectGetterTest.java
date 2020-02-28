package domain;

import ParseAndRequest.DataParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RevisionsObjectGetterTest {

    @Test
    void getRevisionsObject() throws Exception {
        String term = "soup";
        WikiPage page = new WikiPage();
        InputStream stream = page.wikiConnectionBuilder(term);
        DataParser parser = new DataParser();
        JsonObject query = parser.parseData(stream);
        assertNotNull(query);
        RevisionsObjectGetter getter = new RevisionsObjectGetter();
        JsonArray revisions = getter.getRevisionsObject(query);
        assertEquals(revisions.size(), 30);
        //assertEquals(revisions.toString(), "[{\"user\":\"InternetArchiveBot\",\"timestamp\":\"2020-02-24T17:26:22Z\"},{\"user\":\"Yunshui\",\"timestamp\":\"2020-02-09T12:48:23Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:49:19Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:48:49Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:47:36Z\"},{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"},{\"user\":\"Mitchellhobbs\",\"timestamp\":\"2019-10-12T23:10:46Z\"},{\"user\":\"Monkbot\",\"timestamp\":\"2019-09-25T01:11:16Z\"},{\"user\":\"Anfecaro\",\"timestamp\":\"2019-08-16T00:28:36Z\"},{\"user\":\"BrownHairedGirl\",\"timestamp\":\"2019-07-14T13:34:25Z\"},{\"user\":\"Mtpaley\",\"timestamp\":\"2019-06-30T11:21:25Z\"},{\"user\":\"James Bowes\",\"timestamp\":\"2019-06-30T08:09:36Z\"},{\"user\":\"Unknown19871\",\"timestamp\":\"2019-06-09T23:52:43Z\"},{\"user\":\"RexxS\",\"timestamp\":\"2019-06-06T22:12:01Z\"},{\"user\":\"Undecillion\",\"timestamp\":\"2019-05-28T17:22:17Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-05-18T23:23:06Z\"},{\"user\":\"Tbhotch\",\"timestamp\":\"2019-04-07T06:19:17Z\"},{\"user\":\"Tbhotch\",\"timestamp\":\"2019-04-07T06:18:33Z\"},{\"user\":\"MarnetteD\",\"timestamp\":\"2019-04-05T04:49:29Z\"},{\"user\":\"MarnetteD\",\"timestamp\":\"2019-04-05T02:55:29Z\"},{\"user\":\"Materialscientist\",\"timestamp\":\"2019-03-27T21:59:45Z\"},{\"user\":\"Materialscientist\",\"timestamp\":\"2019-03-27T21:59:44Z\"},{\"user\":\"Kleuske\",\"timestamp\":\"2019-03-27T10:51:22Z\"},{\"user\":\"123MaxRick\",\"timestamp\":\"2019-03-27T10:51:16Z\"},{\"user\":\"Shellwood\",\"timestamp\":\"2019-03-27T10:49:48Z\"},{\"user\":\"123MaxRick\",\"timestamp\":\"2019-03-27T10:49:33Z\"},{\"user\":\"Kleuske\",\"timestamp\":\"2019-03-27T10:49:01Z\"}]");
    }
}