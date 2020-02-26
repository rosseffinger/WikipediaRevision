import domain.WikiPage;

import java.util.Scanner;
public class main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("What website do you need");
        String userInput = input.nextLine();
        WikiPage test = new WikiPage(userInput);
        System.out.println(test);




    }
}
