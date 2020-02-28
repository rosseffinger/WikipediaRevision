package domain;

import static org.junit.jupiter.api.Assertions.*;

class WikiPageTest {

    @org.junit.jupiter.api.Test
    void wikiConnectionBuilderTest() throws Exception {
        String term = "soup";
        String result = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Soup&rvprop=timestamp%7Cuser&rvlimit=4&redirects";

        WikiPage page = new WikiPage();
        assertNotNull(page.wikiConnectionBuilder(term));
        }
    }
