public class Game {

    private Board board;
    private Display display;
    private Messenger messenger;
    private Validator validator;

    public Game(Board board, Display display, Messenger messenger, Validator validator) {
        this.board = board;
        this.display = display;
        this.messenger = messenger;
        this.validator = validator;
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
        validator.validateGameType(display.getResponse(messenger.askGameType()));
    }

    public boolean inProgress() {
        return !isOver();
    }

    public boolean isOver() {
        return board.draw() || board.win();
    }
}
