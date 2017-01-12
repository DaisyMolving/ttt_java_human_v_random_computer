public class Game {

    private Board board;
    private Display display;
    private Messenger messenger;

    public Game(Board board, CliDisplay cliDisplay, Messenger messenger) {
        this.board = board;
        this.display = display;
        this.messenger = messenger;
    }

    public void playNew() {
        setUpNewGame();
        while (inProgress()) {
            //request move
            //switch players
        } //display end result
    }

    public void setUpNewGame() {
        display.sendToTheDisplay(messenger.welcomePlayers());
        display.getResponse(messenger.requestGameType());
    }

    public boolean inProgress() {
        return !isOver();
    }

    public boolean isOver() {
        return board.draw() || board.win();
    }
}
