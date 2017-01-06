public class Game {

    private Board board;
    private CliDisplay cliDisplay;
    private Messenger messenger;

    public Game(Board board, CliDisplay cliDisplay, Messenger messenger) {
        this.board = board;
        this.cliDisplay = cliDisplay;
        this.messenger = messenger;
    }

}
