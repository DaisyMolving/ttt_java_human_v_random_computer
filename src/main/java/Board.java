import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<String> cells;
    private GridLine gridLine = new GridLine();

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = giveEmptyCells(dimension);
    }

    public Board(List<String> cells) {
        this.cells = cells;
        this.dimension = (int) Math.sqrt(cells.size());
    }

    public List<String> getCells() {
        return cells;
    }

    public List<String> giveAvailableCells() {
        List<String> availableCells = new ArrayList<String>();
        for (int i = 0; i < cells.size(); i++) {
            if (isAvailableCell(i)) {
                availableCells.add(String.valueOf(i + 1));
            }
        } return availableCells;
    }

    public boolean isAvailableCell(int index) {
        return cells.get(index).equals("");
    }

    public Board markCell(int index, String marker) {
        Board clone = new Board(new ArrayList<String>(cells));
        clone.cells.set(index, marker);
        return clone;
    }

    public boolean win() {
        return gridLine.isWinningLine(cells);
    }

    public boolean draw() {
        for (int i = 0; i < cells.size(); i++) {
            if (isAvailableCell(i)) {
                return false;
            }
        } return true;
    }

    private int squareBoard(int dimension) {
        return dimension * dimension;
    }

    private List<String> giveEmptyCells(int dimension) {
        cells = new ArrayList<String>();
        for (int i = 0; i < (squareBoard(dimension)); i++) {
            cells.add("");
        } return cells;
    }
}
