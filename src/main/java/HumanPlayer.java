import java.util.List;

public class HumanPlayer implements Player{

    private String name = "";
    private String marker = "";

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public void build(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public List<String> makeMove(Board currentBoard) {
        int cellPosition = getCellPosition("1");
        return currentBoard.markCell(cellPosition, getMarker());
    }

    public Integer getCellPosition(String cellPosition) {
        int cellIndex = Integer.valueOf(cellPosition) - 1;
        return cellIndex;
    }
}
