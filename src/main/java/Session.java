import java.util.Arrays;
import java.util.List;

public class Session {

    private Display display;
    private Messenger messenger;
    private PlayerCreator playerCreator;
    private BoardCreator boardCreator;

    public Session(Display display, Messenger messenger, PlayerCreator playerCreator, BoardCreator boardCreator) {
        this.display = display;
        this.messenger = messenger;
        this.playerCreator = playerCreator;
        this.boardCreator = boardCreator;
    }

    public void start() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        List<Player> listOfPlayers = playerCreator.requestPlayerCreation();
        Board board = boardCreator.requestBoardCreation();
        Game game = new Game(board, display, messenger, listOfPlayers.get(0), listOfPlayers.get(1));
        game.play();
    }

}
