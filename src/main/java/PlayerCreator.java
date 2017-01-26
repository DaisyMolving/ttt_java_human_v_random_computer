import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlayerCreator {

    private static final List<String> GAME_OPTIONS = new ArrayList<String>();

    static {
        GAME_OPTIONS.add("a) Human vs Human?");
        GAME_OPTIONS.add("b) Human vs Random Computer?");
        GAME_OPTIONS.add("c) Human vs Unbeatable Computer?");
        GAME_OPTIONS.add("d) Unbeatable Computer vs Unbeatable Computer?");
    }

    private static final HashMap<String, List<Player>> responseToUserInput = new HashMap();

    static {
        responseToUserInput.put("a", createTwoHumans());
        responseToUserInput.put("b", createHumanAndRandomComputer());
        responseToUserInput.put("c", createHumanAndUnbeatableComputer());
        responseToUserInput.put("d", createTwoUnbeatableComputers());
    }

    private Validator validator = new Validator();
    private Messenger messenger = new Messenger();
    private Display display = new CliDisplay();

    public List<Player> requestPlayerCreation() {
        return createPlayers(requestGameTypeFromHuman());
    }

    public List<Player> createPlayers(String chosenGameType) {
        if (isChosenGameTypeValid(chosenGameType)) {
            return responseToUserInput.get(chosenGameType);
        } return createPlayers(requestAlternativeChoice());
    }

    private boolean isChosenGameTypeValid(String choice) {
        return validator.isExistingGameTypeOption(choice);
    }

    private String requestGameTypeFromHuman() {
        return display.getResponse(messenger.askGameType(GAME_OPTIONS));
    }

    private String requestAlternativeChoice() {
        return display.getResponse(messenger.invalidGameTypeMessage(responseToUserInput));
    }

    public static List<Player> createTwoHumans() {
        Player playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        Player playerTwo = new HumanPlayer("Player 2", "o", new CliDisplay());
        return Arrays.asList(playerOne, playerTwo);
    }

    public static List<Player> createHumanAndRandomComputer() {
        Player playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        Player playerTwo = new RandomComputerPlayer("Player 2", "o", new CliDisplay());
        return Arrays.asList(playerOne, playerTwo);
    }

    public static List<Player> createHumanAndUnbeatableComputer() {
        Player playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        Player playerTwo = new UnbeatablePlayer("Player 2", "o", new CliDisplay());
        return Arrays.asList(playerOne, playerTwo);
    }

    public static List<Player> createTwoUnbeatableComputers() {
        Player playerOne = new UnbeatablePlayer("Player 1", "x", new CliDisplay());
        Player playerTwo = new UnbeatablePlayer("Player 2", "o", new CliDisplay());
        return Arrays.asList(playerOne, playerTwo);
    }
}
