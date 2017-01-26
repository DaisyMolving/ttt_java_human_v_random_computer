import java.util.Arrays;
import java.util.List;

public class Session {

    private Display display;
    private Messenger messenger;
    private PlayerCreator playerCreator;

    public Session(Display display, Messenger messenger, PlayerCreator playerCreator) {
        this.display = display;
        this.messenger = messenger;
        this.playerCreator = playerCreator;
    }

    public void start() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        List<Player> listOfPlayers = playerCreator.requestPlayerCreation();
        Game game = buildGame(3, listOfPlayers.get(0), listOfPlayers.get(1));
        game.play();
    }

    public Game buildGame(int dimension, Player player1, Player player2) {
        Board board = new Board(dimension);
        return new Game(board, display, messenger, player1, player2);
    }

}
