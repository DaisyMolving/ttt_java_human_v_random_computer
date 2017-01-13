import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Messenger messenger = new Messenger();

    public String validate(String responseToInput, String userInput) {
        while (responseToInput != userInput) {
            return responseToInput;
        } return userInput;
    }

    public String validateGameType(String userInput) {
        if (validGameType(userInput)) {
            return userInput;
        } return messenger.invalidGameTypeMessage();
    }

    public String validateTurn(String userInput, Board board) {
        if (validTurn(userInput, board)) {
            return userInput;
        } return messenger.invalidTurnMessage();
    }

    private boolean validGameType(String userInput) {
        return isValidMatch(userInput, "[abcd]");
    }

    private boolean validTurn(String userInput, Board board) {
        return isValidMatch(userInput, "[1-9]") &&
                board.isAvailableCell(Integer.valueOf(userInput) - 1);
    }

    private boolean isValidMatch(String userInput, String matchRequirements) {
        Pattern validOptions = Pattern.compile(matchRequirements);
        Matcher inputToValidate = validOptions.matcher(userInput);
        return inputToValidate.matches();
    }
}
