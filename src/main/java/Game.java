public class Game {

    public Board board;
    private Display display;
    private Messenger messenger;
    public Player playerOne;
    public Player playerTwo;

    public Game(Board board, Display display, Messenger messenger, Player playerOne, Player playerTwo) {
        this.board = board;
        this.display = display;
        this.messenger = messenger;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play() {
        while (inProgress()) {
            display.clearDisplay();
            requestMove();
            board = playerOne.makeMove(board);
            switchPlayers();
        } display.clearDisplay();
        display.sendToTheDisplay(messenger.setUpBoard(board));
        display.sendToTheDisplay(messenger.endResultMessage(playerTwo.getName(), board));
    }

    public void displayEndResult() {
        if (board.draw()) {
            display.sendToTheDisplay("\n\nIt's a draw!");
        } else if (board.win()) {
            display.sendToTheDisplay("\n\n" + playerTwo.getName() + " won!");
        }
    }

    public void switchPlayers() {
        Player temporaryPlayer = playerOne;
        playerOne = playerTwo;
        playerTwo = temporaryPlayer;
    }

    private void requestMove() {
        display.sendToTheDisplay(messenger.askPlayerForTurnInput(playerOne.getName(), playerOne.getMarker(), board.getCells().size()));
    }

    private boolean inProgress() {
        return !isOver();
    }

    private boolean isOver() {
        return board.draw() || board.win();
    }
}
