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
        return continueTryingForValidMove(requestMoveFromHuman(), currentBoard);
    }

    public Board continueTryingForValidMove(String chosenMove, Board currentBoard) {
        if (isChosenMoveValid(currentBoard, chosenMove)) {
            return currentBoard.markCell(getCellPosition(chosenMove), getMarker());
        }
        return continueTryingForValidMove(requestAlternativeMove(), currentBoard);
    }

    private boolean isChosenMoveValid(Board currentBoard, String chosenMove) {
        return validator.withinConfinesOfTheBoard(chosenMove) && currentBoard.isAvailableCell(moveToIndex(chosenMove));
    }

    private int moveToIndex(String chosenMove) {
        return getCellPosition(chosenMove);
    }

    private String requestMoveFromHuman() {
        return display.getResponse(messenger.askPlayerForTurnInput(getName(), getMarker()));
    }

    private String requestAlternativeMove() {
        return display.getResponse(messenger.invalidTurnMessage());
    }

    private Integer getCellPosition(String cellPosition) {
        return Integer.valueOf(cellPosition) - 1;
    }
}
