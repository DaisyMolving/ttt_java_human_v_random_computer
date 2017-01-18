import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Messenger messenger = new Messenger();

    private String gameTypeErrorMessage;
    private String turnErrorMessage;
    private Board board;
    private Display display;

    public Validator(Board board, Messenger messenger) {
        this.messenger = messenger;
        this.gameTypeErrorMessage = messenger.invalidGameTypeMessage();
        this.turnErrorMessage = messenger.invalidTurnMessage();
        this.board = board;
    }

    public String validate(StatusMessagePair statusMessagePair) {
        String validResponse = "";
        while (statusMessagePair.status.equals("error")) {
            validResponse = display.getResponse(statusMessagePair.message);
        }
        return validResponse;
    }

    public StatusMessagePair validateGameType(String userInput) {
        if (isGameTypeMatch(userInput)) {
            return new StatusMessagePair("success", userInput);
        } return new StatusMessagePair("invalid", gameTypeErrorMessage);
    }

    public StatusMessagePair validateTurn(String userInput) {
        if (isTurnMatch(userInput)) {
            return new StatusMessagePair("success", userInput);
        } return new StatusMessagePair("invalid", turnErrorMessage);
    }

    private boolean isGameTypeMatch(String userInput) {
        return isValidMatch(userInput, "[abcd]");
    }

    private boolean isTurnMatch(String userInput) {
        return isValidMatch(userInput, "[1-9]") &&
                board.isAvailableCell(Integer.valueOf(userInput) - 1);
    }

    private boolean isValidMatch(String userInput, String matchRequirements) {
        Pattern validOptions = Pattern.compile(matchRequirements);
        Matcher inputToValidate = validOptions.matcher(userInput);
        return inputToValidate.matches();
    }
}
