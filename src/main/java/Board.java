import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> cells;

    public Board(List<String> cells) {
        this.cells = cells;
    }

    public List<String> getCells() {
        return cells;
    }

    public boolean boardIsEmpty() {
       for (int i = 0; i < cells.size(); i++) {
           if (isNotEmptyCell(cells, i)) {
               return false;
           }
       } return true;
    }

    private boolean isNotEmptyCell(List<String> currentBoard, int i) {
        return currentBoard.get(i) != "";
    }

    public Board markCell(int index, String marker) {
        getCells().set(index, marker);
        return new Board(getCells());
    }

    public boolean isAvailableCell(int index) {
        String cell = cells.get(index);
        return cell.equals("");
    }

    public boolean win() {
        List<List<String>> sequences = getSequences();
        if (allMarked(sequences)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean draw() {
        for (int i = 0; i < getCells().size(); i++) {
            if (isAvailableCell(i)) {
                return false;
            }
        } return true;
    }

    public List<List<String>> getRows() {
        List<List<String>> rows = new ArrayList<List<String>>();
        rows.add(getCells().subList(0, 3));
        rows.add(getCells().subList(3, 6));
        rows.add(getCells().subList(6, 9));
        return rows;
    }

    public List<List<String>> getColumns() {
        List<List<String>> columns = new ArrayList<List<String>>();
        columns.add(Arrays.asList(getCells().get(0), getCells().get(3), getCells().get(6)));
        columns.add(Arrays.asList(getCells().get(1), getCells().get(4), getCells().get(7)));
        columns.add(Arrays.asList(getCells().get(2), getCells().get(5), getCells().get(8)));
        return columns;
    }

    public List<List<String>> getDiagonals() {
        List<List<String>> diagonals = new ArrayList<List<String>>();
        diagonals.add(Arrays.asList(getCells().get(0), getCells().get(4), getCells().get(8)));
        diagonals.add(Arrays.asList(getCells().get(2), getCells().get(4), getCells().get(6)));
        return diagonals;
    }

    private boolean allMarked(List<List<String>> sequences) {
        return (sequences.contains(markedSequenceNought()) ||
                sequences.contains(markedSequenceCross()));
    }

    private List<String> markedSequenceCross() {
        return Arrays.asList("x", "x", "x");
    }

    private List<String> markedSequenceNought() {
        return Arrays.asList("o", "o", "o");
    }

    private List<List<String>> getSequences(){
        List<List<String>> sequences = new ArrayList<List<String>>();
        sequences.addAll(getRows());
        sequences.addAll(getColumns());
        sequences.addAll(getDiagonals());
        return sequences;
    }
}
