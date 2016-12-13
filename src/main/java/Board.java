import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<String> cells = Arrays.asList("", "", "", "", "", "", "", "", "");

    public List<String> getCells() {
        return cells;
    }

    public boolean isEmpty(List<String> currentBoard) {
       for (int i = 0; i < currentBoard.size(); i++) {
           if (isNotEmptyCell(currentBoard, i)) {
               return false;
           }
       } return true;
    }

    private boolean isNotEmptyCell(List<String> currentBoard, int i) {
        return currentBoard.get(i) != "";
    }

    public List<String> markCell(int index, String marker) {
        List<String> currentGrid = getCells();
        currentGrid.set(index, marker);
        return currentGrid;
    }

    public boolean isAvailableCell(List<String> currentCells, int index) {
        String cell = currentCells.get(index);
        return cell.isEmpty();
    }

    public boolean win(List<String> currentBoard) {
        List<List<String>> sequences = getSequences(currentBoard);
        if (allMarked(sequences)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean draw(List<String> currentBoard) {
        for (int i = 0; i < currentBoard.size(); i++) {
            if (isAvailableCell(currentBoard, i)) {
                return false;
            }
        } return true;
    }

    public List<List<String>> getRows(List<String> currentBoard) {
        List<List<String>> rows = new ArrayList<List<String>>();
        rows.add(currentBoard.subList(0, 3));
        rows.add(currentBoard.subList(3, 6));
        rows.add(currentBoard.subList(6, 9));
        return rows;
    }

    public List<List<String>> getColumns(List<String> currentBoard) {
        List<List<String>> columns = new ArrayList<List<String>>();
        columns.add(Arrays.asList(currentBoard.get(0), currentBoard.get(3), currentBoard.get(6)));
        columns.add(Arrays.asList(currentBoard.get(1), currentBoard.get(4), currentBoard.get(7)));
        columns.add(Arrays.asList(currentBoard.get(2), currentBoard.get(5), currentBoard.get(8)));
        return columns;
    }

    public List<List<String>> getDiagonals(List<String> currentBoard) {
        List<List<String>> diagonals = new ArrayList<List<String>>();
        diagonals.add(Arrays.asList(currentBoard.get(0), currentBoard.get(4), currentBoard.get(8)));
        diagonals.add(Arrays.asList(currentBoard.get(2), currentBoard.get(4), currentBoard.get(6)));
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

    private List<List<String>> getSequences(List<String> currentBoard){
        List<List<String>> sequences = new ArrayList<List<String>>();
        sequences.addAll(getRows(currentBoard));
        sequences.addAll(getColumns(currentBoard));
        sequences.addAll(getDiagonals(currentBoard));
        return sequences;
    }

}
