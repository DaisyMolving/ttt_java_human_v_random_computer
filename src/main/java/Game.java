public class Game {

    private Board board;
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
            requestMove();
            board = playerOne.makeMove(board);
            switchPlayers();
        } display.sendToTheDisplay("goodbye");
    }

    public void switchPlayers() {
        Player temporaryPlayer = playerOne;
        playerOne = playerTwo;
        playerTwo = temporaryPlayer;
    }

    private void requestMove() {
        display.sendToTheDisplay(messenger.setUpBoard(board));
    }

    private boolean inProgress() {
        return !isOver();
    }

    private boolean isOver() {
        return board.draw() || board.win();
    }
}
