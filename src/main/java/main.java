import ParseAndRequest.DataParser;
import com.google.gson.JsonArray;
import domain.RevisionsLister;
import domain.WikiPage;

import java.io.InputStream;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //System.out.println("What website do you need");
        //String term = input.nextLine();

        String term = "soup";

        // create connection (returns input stream)
        WikiPage page = new WikiPage();
        InputStream stream = page.wikiConnectionBuilder(term);
        // parse data AKA get data (returns revisions array)
        DataParser parser = new DataParser();
        JsonArray revisions = parser.parseData(stream);
        RevisionsLister revisionLister = new RevisionsLister();
        String output = revisionLister.listRevisions(revisions);
        System.out.println(output);
    }
}
