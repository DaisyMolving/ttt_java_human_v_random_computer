import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GridLine {

    public List<List<String>> sequences = new ArrayList<List<String>>();

    public boolean isWinningLine(List<String> cells) {
        if (allMarked(cells))  {
            return true;
        } else {
            return false;
        }
    }

    private boolean allMarked(List<String> cells) {
        return (getSequences(cells).contains(markedSequenceAllSame(cells, "o")) ||
                getSequences(cells).contains(markedSequenceAllSame(cells, "x")));
    }

    private List<List<String>> getSequences(List<String> cells) {
        makeRows(0, new LinkedList<String>(), cells);
        makeColumns(0, new LinkedList<String>(), cells);
        makeDiagonals(cells);
        return sequences;
    }

    private List<String> markedSequenceAllSame(List<String> cells, String marker) {
        List<String> winningSequence = new ArrayList<String>();
        for (int i = 0; i < getDimension(cells); i ++) {
            winningSequence.add(marker);
        } return winningSequence;
    }

    public void makeRows(int index, List<String> row, List<String> cells) {
        if (allRowsTraversed(cells, index)) {
            sequences.add(row);
        } else if (isFull(row, cells)) {
            sequences.add(row);
            makeRows(index, new ArrayList<String>(), cells);
        } else {
            row.add(row.size(), cells.get(index));
            makeRows(index + 1, row, cells);
        }
    }

    private boolean allRowsTraversed(List<String> cells, int index) {
        return index == cells.size();
    }

    private boolean isFull(List<String> line, List<String> cells) {
        return line.size() == getDimension(cells);
    }

    public void makeColumns(int index, List<String> column, List<String> cells) {
        if (allColumnsTraversed(cells, index)) {
            sequences.add(column);
        } else if (isFull(column, cells)) {
            sequences.add(column);
            makeColumns(index + 1, new ArrayList<String>(), cells);
        } else {
            for (int amount = 0; amount < getDimension(cells); amount++) {
                column.add(cells.get(index + (getDimension(cells) * amount)));
            }
            makeColumns(index, column, cells);
        }
    }

    private boolean allColumnsTraversed(List<String> cells, int index) {
        return index == getDimension(cells);
    }

    public List<List<String>> makeDiagonals(List<String> cells) {
        sequences.add(takeForwardDiagonal(new LinkedList<String>(), cells));
        sequences.add(takeBackwardDiagonal(new LinkedList<String>(), cells));
        return sequences;
    }

    private List<String> takeForwardDiagonal(List<String> diagonal, List<String> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (belongsToForwardDiagonal(cells, i)) {
                diagonal.add(cells.get(i));
            }
        } return diagonal;
    }

    private boolean belongsToForwardDiagonal(List<String> cells, int index) {
        return index % (getDimension(cells) + 1) == 0;
    }

    private List<String> takeBackwardDiagonal(List<String> diagonal, List<String> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (belongsToBackwardDiagonal(cells, i)) {
                diagonal.add(cells.get(i));
            }
        } return diagonal;
    }

    private boolean belongsToBackwardDiagonal(List<String> cells, int index) {
        return (index % (getDimension(cells) - 1) == 0) && (index != 0) && (index != cells.size() - 1);
    }

    private int getDimension(List<String> cells){
        return (int) Math.sqrt(cells.size());
    }
}
