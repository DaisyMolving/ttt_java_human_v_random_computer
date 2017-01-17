import java.util.Arrays;
import java.util.List;

public class Game {

    private Board board;
    private Display display;
    private Messenger messenger;
    public Player playerOne;
    public Player playerTwo;

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
        String gameType = display.getResponse(messenger.askGameType());
        createPlayers(gameType);
    }

    public void createPlayers(String gameType) {
        if (gameType.equals("a")) {
            createHVHGame();
        } else if (gameType.equals("b")) {
            createHVCGame();
        }
    }

    public void createHVHGame() {
        playerOne = new HumanPlayer("Player 1", "x");
        playerTwo = new HumanPlayer("Player 2", "o");
    }

    public void createHVCGame() {
        playerOne = new HumanPlayer("Player 1", "x");
        playerTwo = new RandomComputerPlayer("Player 2", "o");
    }

    public Board requestMove() {
        display.sendToTheDisplay(messenger.setUpBoard(board));
        return playerOne.makeMove(board);
    }

    public void switchPlayers() {
        Player temporaryPlayer = playerOne;
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
