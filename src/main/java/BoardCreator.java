import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoardCreator {

    private static final List<String> BOARD_OPTIONS = new ArrayList<String>();

    static {
        BOARD_OPTIONS.add("a) a 3 by 3 grid board?");
        BOARD_OPTIONS.add("b) a 4 by 4 grid board?");
    }

    private static final HashMap<String, Board> responseToUserInput = new HashMap();

    static {
        responseToUserInput.put("a", new Board(3));
        responseToUserInput.put("b", new Board(4));
    }

    private Validator validator = new Validator();
    private Messenger messenger = new Messenger();
    private Display display = new CliDisplay();

    public Board requestBoardCreation() {
        return createBoard(requestBoardSizeFromHuman());
    }

    private Board createBoard(String chosenSizeOption) {
        if (isChosenDimensionValid(chosenSizeOption)) {
            return responseToUserInput.get(chosenSizeOption);
        } return createBoard(requestAlternativeChoice());
    }

    private boolean isChosenDimensionValid(String chosenSizeOption) {
        return validator.isExistingBoardSizeOption(chosenSizeOption);
    }

    private String requestBoardSizeFromHuman() {
        return display.getResponse(messenger.askBoardSize(BOARD_OPTIONS));
    }

    private String requestAlternativeChoice() {
        return display.getResponse(messenger.invalidBoardTypeMessage(responseToUserInput));
    }
}
