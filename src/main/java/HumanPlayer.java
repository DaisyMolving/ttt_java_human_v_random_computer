import java.util.List;

public class HumanPlayer implements Player {

    private String name;
    private String marker;
    private Display display = new CliDisplay();
    private Messenger messenger = new Messenger();

    public HumanPlayer(String name, String marker) {
        this.name = name;
        this.marker = marker;
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
