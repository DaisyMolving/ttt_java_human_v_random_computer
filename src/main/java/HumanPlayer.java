import java.util.List;

public class HumanPlayer implements Player{

    private String name;
    private String marker;
    private Display display;
    private Messenger messenger = new Messenger();
    private Validator validator = new Validator();

    public HumanPlayer(String name, String marker, Display display) {
        this.name = name;
        this.marker = marker;
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public Board makeMove(Board currentBoard) {
        return continueTryingForValidMove(requestMoveFromHuman(currentBoard), currentBoard);
    }

    public Board continueTryingForValidMove(String chosenMove, Board currentBoard) {
        if (validator.isExistingTurnOption(currentBoard, chosenMove)) {
            return currentBoard.markCell(getCellPosition(chosenMove), getMarker());
        }
        return continueTryingForValidMove(requestAlternativeMove(currentBoard), currentBoard);
    }

    private String requestMoveFromHuman(Board board) {
        return display.getResponse(messenger.askPlayerForTurnInput(getName(), getMarker(), board.getCells().size()));
    }

    private String requestAlternativeMove(Board board) {
        return display.getResponse(messenger.invalidTurnMessage(board.getCells().size()));
    }

    private Integer getCellPosition(String cellPosition) {
        return Integer.valueOf(cellPosition) - 1;
    }
}
