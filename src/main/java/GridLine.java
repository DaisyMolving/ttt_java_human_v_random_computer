import java.util.*;

public class GridLine {

    public boolean isWinningLine(List<String> cells) {
        List<List<String>> lines = getLines(cells);
        return anyWinningLines(lines);
    }

    private List<List<String>> getLines(List<String> cells) {
        List<List<String>> lines = new ArrayList<List<String>>();
        makeRows(lines, cells);
        makeColumns(lines, cells);
        makeDiagonals(lines, cells);
        return lines;
    }

    private boolean anyWinningLines(List<List<String>> lines) {
        for (int line = 0; line < lines.size(); line++) {
           if (isAllSame(lines.get(line))) {
               return true;
           }
        } return false;
    }

    private boolean isAllSame(List<String> line) {
        String first = line.get(0);
        if (first.equals("")) {
            return false;
        }
        for (int i = 1; i < line.size(); i++) {
            String next = line.get(i);
            if (!first.equals(next)) {
                return false;
            }
        } return true;
    }


    private void makeRows(List<List<String>> lines, List<String> cells) {
        List<String> row = new ArrayList<String>();
        int dimension = getDimension(cells);

        for (int i = 0; i < cells.size(); i++) {
            row.add(row.size(), cells.get(i));

            if (i % dimension == dimension - 1) {
                lines.add(row);
                row = new ArrayList<String>();
            }
        }
    }

    private void makeColumns(List<List<String>> lines, List<String> cells) {
        for (int i = 0; i < getDimension(cells); i ++){
            List<String> column = new ArrayList<String>();

            for (int amount = 0; amount < getDimension(cells); amount++) {
                column.add(cells.get(i + (getDimension(cells) * amount)));
            }

            lines.add(column);
        }
    }

    private List<List<String>> makeDiagonals(List<List<String>> lines, List<String> cells) {
        lines.add(takeForwardDiagonal(new LinkedList<String>(), cells));
        lines.add(takeBackwardDiagonal(new LinkedList<String>(), cells));
        return lines;
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
