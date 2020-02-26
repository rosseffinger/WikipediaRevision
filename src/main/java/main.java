import domain.WikiPage;

import java.util.Scanner;
public class main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("What website do you need");
        String userInput = input.nextLine();
        String Json = new WikiPage(userInput).getJsonString();
        System.out.println(Json);
        //DataParser test2 = new DataParser().revisionsParse();
        //String test2 = new DataParser().revisionsParse(Json);






    }
}
