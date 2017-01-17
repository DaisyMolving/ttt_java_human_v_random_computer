import java.util.Arrays;

public class Session {

    private Display display;
    private Messenger messenger;
    private Game game;

    public Session(Display display, Messenger messenger) {
        this.display = display;
        this.messenger = messenger;
    }

    public void start() {
        createNewGame();
        game.play();
    }

    public void createNewGame() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        String userResponse = display.getResponse(messenger.askGameType());
        decideGameType(userResponse);
    }

    public void decideGameType(String userResponse) {
        if (userResponse.equals("a")) {
            buildGame(
                    new HumanPlayer("Player 1", "x", display),
                    new HumanPlayer("Player 2", "o", display));
        } else if (userResponse.equals("b")){
            buildGame(
                    new HumanPlayer("Player 1", "x", display),
                    new RandomComputerPlayer("Player 2", "o", display));
        }
    }

    public void buildGame(Player player1, Player player2) {
        Board board = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        this.game = new Game(board, display, messenger, player1, player2);
    }

}
