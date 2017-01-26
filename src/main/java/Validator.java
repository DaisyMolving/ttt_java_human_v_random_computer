import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean isExistingGameTypeOption(String option) {
        return isValidMatch(option, "[abcd]");
    }

    public boolean withinConfinesOfTheBoard(String position) {
        return isValidMatch(position, "[1-9]");
    }

    private boolean isValidMatch(String userInput, String matchRequirements) {
        Pattern validOptions = Pattern.compile(matchRequirements);
        Matcher inputToValidate = validOptions.matcher(userInput);
        return inputToValidate.matches();
    }
}
