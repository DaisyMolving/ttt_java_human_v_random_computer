import java.util.Scanner;

public class CliDisplay implements Display {

    public void sendMessageToDisplay(String message) {
       System.out.print(message);
    }

    public String getResponse(String request) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(request);
        return userInput.nextLine();
    }

}