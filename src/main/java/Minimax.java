import java.util.ArrayList;
import java.util.List;

public class Minimax {

    public int minimaxValue(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        if (terminal(board)) {
            return score(board, maximisingPlayer);
        } else if (maximisingPlayer) {
            return findMaximum(mapMinimaxValues(board, currentPlayerMarker, maximisingPlayer));
        } return findMinimum(mapMinimaxValues(board, currentPlayerMarker, maximisingPlayer));
    }

    public List<Integer> mapMinimaxValues(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        List<Integer> minimaxValues = new ArrayList<Integer>();
        for (int i = 0; i < findPossibleBoards(board, currentPlayerMarker).size(); i++) {
            int newValue = minimaxValue(findPossibleBoards(board, currentPlayerMarker).get(i), opponent(currentPlayerMarker), !maximisingPlayer);
            minimaxValues.add(newValue);
        } return minimaxValues;
    }

    public List<Board> findPossibleBoards(Board board, String currentPlayerMarker) {
        List<Board> possibleBoards = new ArrayList<Board>();
        for (int i = 0; i < board.getCells().size(); i++) {
            if (board.isAvailableCell(i)) {
                Board possibleBoard = board.markCell(i, currentPlayerMarker);
                possibleBoards.add(possibleBoard);
            }
        } return possibleBoards;
    }

    private Integer findMinimum(List<Integer> minimaxValues) {
        int min = 0;
        for (int i = 0; i < minimaxValues.size(); i++) {
            int number = minimaxValues.get(i);
            if (number < min) min = number;
        } return min;
    }

    private Integer findMaximum(List<Integer> minimaxValues) {
        int max = 0;
        for (int i = 0; i < minimaxValues.size(); i++) {
            int number = minimaxValues.get(i);
            if (number > max) max = number;
        } return max;
    }
    private int score(Board board, boolean maximisingPlayer) {
        if (board.win() && maximisingPlayer) {
            return -1;
        } else if (board.win() && !maximisingPlayer) {
            return 1;
        } return 0;
    }

    private String opponent(String currentPlayerMarker) {
        if (currentPlayerMarker == "x") {
            return "o";
        } return "x";
    }

    private boolean terminal(Board board) {
        return board.win() || board.draw();
    }
}
