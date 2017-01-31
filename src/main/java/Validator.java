import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean isExistingGameTypeOption(String option) {
        return isValidMatch(option, "[abcd]");
    }

    public boolean isExistingTurnOption(Board board, String position) {
        List<String> possibleMoves = board.giveAvailableCells();
        return possibleMoves.contains(position);
    }

    public boolean isExistingBoardSizeOption(String dimensionOption) {
        return isValidMatch(dimensionOption, "[ab]");
    }

    private boolean isValidMatch(String userInput, String matchRequirements) {
        Pattern validOptions = Pattern.compile(matchRequirements);
        Matcher inputToValidate = validOptions.matcher(userInput);
        return inputToValidate.matches();
    }
}
