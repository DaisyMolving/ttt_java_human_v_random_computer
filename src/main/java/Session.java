import java.util.Arrays;

public class Session {

    private Display display;
    private Messenger messenger;
    public PlayerCreator playerCreator = new PlayerCreator();
    public Game game;

    public Session(Display display, Messenger messenger) {
        this.display = display;
        this.messenger = messenger;
    }

    public void start() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        String userResponse = display.getResponse(messenger.askGameType());
        createPlayersOfType(userResponse);
        buildGame(playerCreator.playerOne, playerCreator.playerTwo);
        game.play();
    }

    public void createPlayersOfType(String userResponse) {
        if (userResponse.equals("a")) {
            playerCreator.createTwoHumans();
        } else if (userResponse.equals("b")){
            playerCreator.createHumanAndRandomComputer();
        } else if (userResponse.equals("c")) {
            playerCreator.createHumanAndUnbeatableComputer();
        } else if (userResponse.equals("d")) {
            playerCreator.createTwoUnbeatableComputers();
        }
    }

    public void buildGame(Player player1, Player player2) {
        Board board = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        this.game = new Game(board, display, messenger, player1, player2);
    }

}
