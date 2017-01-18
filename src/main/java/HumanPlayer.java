public class HumanPlayer implements Player {

    private String name;
    private String marker;
    private Display display;
    private Messenger messenger = new Messenger();

    public HumanPlayer(String name, String marker, Display display) {
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

    public Board makeMove(Board currentBoard) {
        String move = display.getResponse(messenger.askPlayerForTurnInput(getName(), getMarker()));
        return currentBoard.markCell(getCellPosition(move), getMarker());
    }

    public Integer getCellPosition(String cellPosition) {
        return Integer.valueOf(cellPosition) - 1;
    }
}
