import ParseAndRequest.DataParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import domain.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class mainUI extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField t;
    static JButton button;
    static JLabel label;
    static JTextArea revisionsText;
    static JTextArea editorsText;
    static JLabel noConnection;
    static JLabel noPage;
    static JTextArea redirected;

    public mainUI() {

        super("Wikipedia Revisions");

        UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));
        UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 10)));

        frame = new JFrame("revisions");
        label = new JLabel("enter your word here");
        button = new JButton("submit");
        t = new JTextField(10);
        revisionsText = new JTextArea();
        editorsText = new JTextArea();
        noPage = new JLabel();
        redirected = new JTextArea();

        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel panel = new JPanel();

        panel.setLayout(gridBagLayout);
        panel.add(button);
        panel.add(t);
        panel.add(label);



        setContentPane(panel);

        button.addActionListener(e -> {
            String article = t.getText();
            try {
                WikiPage page = new WikiPage();
                InputStream stream = page.wikiConnectionBuilder(article);
                //checks for no connection
                if (stream == null) {
                    noConnection.setText("no connection");
                    var noConnectionConstraints = new GridBagConstraints(1,1,1,1,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1,1,1,1), 0,0);
                    panel.add(noConnection,noConnectionConstraints);
                }

                // parse data AKA get data (returns revisions array)
                DataParser parser = new DataParser();
                JsonObject query = parser.parseData(stream);

                if (query == null) {
                    noPage.setText("no page exists");
                    var noPageConstraints = new GridBagConstraints(0,4,1,1,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10,1,10,1),0,0);
                    panel.add(noPage, noPageConstraints);
                    panel.updateUI();
                } else {
                    // Gets revisions Object
                    RevisionsObjectGetter getter = new RevisionsObjectGetter();
                    JsonArray revisions = getter.getRevisionsObject(query);

                    // Check for redirects
                    checkRedirects checker = new checkRedirects();
                    String redirects = checker.checkForRedirects(query);
                    if (redirects != null) {
                        redirected.setText("You have been redirected from " + article + '\n' + " to " + redirects);
                        redirected.setPreferredSize(new Dimension(100,100));
                        //var redirectedConstraints = new GridBagConstraints(0,0,1,1,1,1, GridBagConstraints.WEST, GridBagConstraints.BOTH,new Insets(2,2,0,0),0,0);

                        button.hide();
                        label.hide();
                        panel.add(redirected);
                        panel.updateUI();
                    }

                    RevisionsLister revisionLister = new RevisionsLister();
                    revisionsText.setText(revisionLister.listRevisions(revisions));
                    revisionsText.setPreferredSize(new Dimension(500,500));
                    panel.add(revisionsText);


                    // Sort Editors
                    EditorSort editorSort = new EditorSort();
                    String result = editorSort.sortEditors(revisions).toString();

                    editorsText.setText(result);
                    editorsText.setPreferredSize(new Dimension(500,600));
                    panel.add(editorsText);
                    panel.updateUI();

                    // Display Editors list
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        setPreferredSize(new Dimension(1100,1300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);


    }

    public static void main(String[] args) {
        new mainUI();


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {



    }
}
