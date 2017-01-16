import java.util.Arrays;
import java.util.List;

public class Game {

    private Board board;
    private Display display;
    private Messenger messenger;
    private Player playerOne;
    private Player playerTwo;

    public Game(Board board, Display display, Messenger messenger) {
        this.board = board;
        this.display = display;
        this.messenger = messenger;
    }

    public void playNew() {
        setUpNewGame();
        while (inProgress()) {
            requestMove();
            switchPlayers();
        } display.sendToTheDisplay("goodbye");
    }

    public void setUpNewGame() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        display.sendToTheDisplay(messenger.askGameType());
        playerOne = new HumanPlayer("Player 1", "x");
        playerTwo = new HumanPlayer("Player 2", "o");
    }

    public Board requestMove() {
        display.sendToTheDisplay(messenger.setUpBoard(board));
        return Player.makeMove(board);
    }

    public void switchPlayers() {
        HumanPlayer temporaryPlayer = new HumanPlayer(playerOne.getName(), playerOne.getMarker());
        playerOne = playerTwo;
        playerTwo = temporaryPlayer;
    }

    public boolean inProgress() {
        return !isOver();
    }

    public boolean isOver() {
        return board.draw() || board.win();
    }
}
