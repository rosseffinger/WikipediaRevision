/*import ParseAndRequest.DataParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import domain.*;

import java.io.InputStream;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("What website do you need");
        String term = input.nextLine();

        // create connection (returns input stream)
        WikiPage page = new WikiPage();
        InputStream stream = page.wikiConnectionBuilder(term);
        //checks for no connection
        if (stream == null) {
            System.out.println("no connection");
        }

        // parse data AKA get data (returns revisions array)
        DataParser parser = new DataParser();
        JsonObject query = parser.parseData(stream);

        if (query == null) {
            System.out.println("Page does not exist.");
        } else {
            // Gets revisions Object
            RevisionsObjectGetter getter = new RevisionsObjectGetter();
            JsonArray revisions = getter.getRevisionsObject(query);

            // Check for redirects
            checkRedirects checker = new checkRedirects();
            String redirects = checker.checkForRedirects(query);
            if (redirects != null) {
                System.out.println("You have been redirected from " + term + " to " + redirects);
            }

            RevisionsLister revisionLister = new RevisionsLister();
            String output = revisionLister.listRevisions(revisions);

            System.out.println(output);

            // Sort Editors
            EditorSort editorSort = new EditorSort();
            String result = editorSort.sortEditors(revisions).toString();

            // Display Editors list
            System.out.println(result);
        }
    }
}
*/