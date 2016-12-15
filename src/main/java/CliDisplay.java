import java.util.Scanner;

public class CliDisplay {

    public void printMessage(String message) {
       System.out.print(message);
    }

    public String getResponse(String message) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }

}
