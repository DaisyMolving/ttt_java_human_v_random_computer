import java.util.List;

public class HumanPlayer implements Player {

    private String name;
    private String marker;

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
        return currentBoard.markCell(getCellPosition("1"), getMarker());
    }

    public Integer getCellPosition(String cellPosition) {
        return Integer.valueOf(cellPosition) - 1;
    }
}
