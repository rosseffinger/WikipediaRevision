import domain.WikiPage;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("What website do you need");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        Scanner wiki = input;

        WikiPage test = new WikiPage(wiki);
    }
}
