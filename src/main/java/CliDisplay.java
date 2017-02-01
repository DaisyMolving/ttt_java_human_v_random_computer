import java.util.Scanner;

public class CliDisplay implements Display {

    public void sendToTheDisplay(String message) {
       System.out.print(message);
    }

    public String getResponse(String request) {
        Scanner userInput = new Scanner(System.in);
        sendToTheDisplay(request);
        return userInput.nextLine();
    }

    public void clearDisplay() {
        System.out.println("\033[H\033[2J");
    }

}