import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<String> cells;

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

    public boolean boardIsEmpty() {
        for (int i = 0; i < cells.size(); i++) {
            if (isPopulatedCell(i)) {
                return false;
            }
        } return true;
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

    public boolean isPopulatedCell(int i) {
        return !isAvailableCell(i);
    }

    public Board markCell(int index, String marker) {
        Board clone = new Board(new ArrayList<String>(getCells()));
        clone.getCells().set(index, marker);
        return clone;
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
        for (int i = 0; i < getCells().size(); i++) {
            if (beginningOfRow(i)) {
                startNewRow(rows, i);
            } else {
                addToExistingRow(rows, i);
            }
        } return rows;
    }

    public List<List<String>> getColumns() {
        List<List<String>> columns = new ArrayList<List<String>>();
        for (int i = 0; i < getCells().size(); i++) {
            if (beginningOfColumn(i)) {
                startNewColumn(columns, i);
            } else {
                addToExistingColumn(columns, i);
            }
        } return columns;
    }

    public List<List<String>> getDiagonals() {
        List<List<String>> diagonals = new ArrayList<List<String>>();
        diagonals.add(takeForwardDiagonal(diagonals));
        diagonals.add(takeBackwardDiagonal(diagonals));
        return diagonals;
    }

    private List<String> giveEmptyCells(int dimension) {
        cells = new ArrayList<String>();
        for (int i = 0; i < (squareBoard(dimension)); i++) {
            cells.add("");
        } return cells;
    }

    private boolean beginningOfRow(int index) {
        return index % dimension == 0;
    }

    private List<List<String>> startNewRow(List<List<String>> rows, int index) {
        List<String> row = new ArrayList<String>();
        rows.add(row);
        row.add(getCells().get(index));
        return rows;
    }

    private List<List<String>> addToExistingRow(List<List<String>> rows, int index) {
        rows.get(lastRow(rows)).add(getCells().get(index));
        return rows;
    }

    private int lastRow(List<List<String>> rows) {
        return rows.size() - 1;
    }

    private boolean beginningOfColumn(int index) {
        return index < dimension;
    }

    private List<List<String>> startNewColumn(List<List<String>> columns, int index) {
        List<String> column = new ArrayList<String>();
        columns.add(column);
        column.add(getCells().get(index));
        return columns;
    }

    private List<List<String>> addToExistingColumn(List<List<String>> columns, int index) {
        columns.get(index % dimension).add(getCells().get(index));
        return columns;
    }

    private List<String> takeForwardDiagonal(List<List<String>> diagonals) {
        List<String> diagonal = new ArrayList<String>();
        for (int i = 0; i < getCells().size(); i++) {
            if (belongsToForwardDiagonal(i)) {
                diagonal.add(getCells().get(i));
            }
        } return diagonal;
    }

    private List<String> takeBackwardDiagonal(List<List<String>> diagonals) {
        List<String> diagonal = new ArrayList<String>();
        for (int i = 0; i < getCells().size(); i++) {
            if (belongsToBackwardDiagonal(i)) {
                diagonal.add(getCells().get(i));
            }
        } return diagonal;
    }

    private boolean belongsToForwardDiagonal(int index) {
        return index % (dimension + 1) == 0;
    }

    private boolean belongsToBackwardDiagonal(int index) {
        return (index % (dimension - 1) == 0) && (index != 0) && (index != getCells().size() - 1);
    }

    private int squareBoard(int dimension) {
        return dimension * dimension;
    }

    private boolean allMarked(List<List<String>> sequences) {
        return (sequences.contains(markedSequenceNought()) ||
                sequences.contains(markedSequenceCross()));
    }

    private List<String> markedSequenceCross() {
        List<String> winningCrossSequence = new ArrayList<String>();
        for (int i = 0; i < dimension; i ++) {
            winningCrossSequence.add("x");
        } return winningCrossSequence;
    }

    private List<String> markedSequenceNought() {
        List<String> winningNoughtSequence = new ArrayList<String>();
        for (int i = 0; i < dimension; i ++) {
            winningNoughtSequence.add("o");
        } return winningNoughtSequence;
    }

    private List<List<String>> getSequences(){
        List<List<String>> sequences = new ArrayList<List<String>>();
        sequences.addAll(getRows());
        sequences.addAll(getColumns());
        sequences.addAll(getDiagonals());
        return sequences;
    }
}
