public class UnbeatablePlayer implements Player{

    private String name;
    private String marker;
    private Display display;
    private Messenger messenger = new Messenger();
    private Minimax minimax = new Minimax();

    public UnbeatablePlayer(String name, String marker, Display display) {
        this.name = name;
        this.marker = marker;
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public Board makeMove(Board board) {
        display.sendToTheDisplay(messenger.askPlayerForTurnInput(getName(), getMarker(), board.getCells().size()));
        int cellPosition = minimax.getBestMove(board, marker);
        return board.markCell(cellPosition, getMarker());
    }
}
