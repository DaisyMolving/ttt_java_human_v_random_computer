import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> cells = Arrays.asList("", "", "", "", "", "", "", "", "");

    public List<String> getCells() {
        return cells;
    }

    public boolean gridIsEmpty() {
       List<String> currentBoard = getCells();
       for (int i = 0; i < currentBoard.size(); i++) {
           if (currentBoard.get(i) != "") {
               return false;
           } else {
               continue;
           }
       } return true;
    }

    public List<String> markCell(int index, String marker) {
        List<String> currentGrid = getCells();
        currentGrid.set(index, marker);
        return currentGrid;
    }

    public boolean availableCell(int index) {
        List<String> currentGrid = getCells();
        String cell = (String) currentGrid.get(index);
        return cell.isEmpty();
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
        List<String> currentBoard = getCells();
        for (int i = 0; i < currentBoard.size(); i++) {
            if (currentBoard.get(i) == "") {
                return false;
            } else {
                continue;
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
        if (sequences.contains(markedSequenceO()) || sequences.contains(markedSequenceX())){
            return true;
        } else {
            return false;
        }
    }

    private List<String> markedSequenceX() {
        List<String> markedSequenceX = Arrays.asList("x", "x", "x");
        return markedSequenceX;
    }

    private List<String> markedSequenceO() {
        List<String> markedSequenceO = Arrays.asList("o", "o", "o");
        return markedSequenceO;
    }

    private List<List<String>> getSequences(){
        List<List<String>> sequences = new ArrayList<List<String>>();
        sequences.addAll(getRows());
        sequences.addAll(getColumns());
        sequences.addAll(getDiagonals());
        return sequences;
    }

}
