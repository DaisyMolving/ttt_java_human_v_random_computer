import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class Minimax {

    public int getBestMove(Board board, String currentPlayerMarker) {
        int bestMove = Integer.MIN_VALUE;
        int bestScore = Integer.MIN_VALUE;
        for (int move = 0; move < board.getCells().size(); move++) {
            if (board.isAvailableCell(move)) {
                Board possibleBoard = board.markCell(move, currentPlayerMarker);
                int minimaxValue = minimaxValue(possibleBoard, opponent(currentPlayerMarker), false);
                if (minimaxValue > bestScore) {
                    bestScore = minimaxValue;
                    bestMove = move;
                }
            }
        }
        return bestMove;
    }

    public int minimaxValue(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        if (isTerminal(board)) {
            return score(board, maximisingPlayer);
        } else if (maximisingPlayer) {
            return max(mapMinimaxValues(board, currentPlayerMarker, maximisingPlayer));
        } return min(mapMinimaxValues(board, currentPlayerMarker, maximisingPlayer));
    }

    private List<Integer> mapMinimaxValues(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        List<Integer> minimaxValues = new ArrayList<Integer>();
        for (int i = 0; i < findPossibleBoards(board, currentPlayerMarker).size(); i++) {
            int newValue = minimaxValue(findPossibleBoards(board, currentPlayerMarker).get(i), opponent(currentPlayerMarker), !maximisingPlayer);
            minimaxValues.add(newValue);
        } return minimaxValues;
    }

    private List<Board> findPossibleBoards(Board board, String currentPlayerMarker) {
        List<Board> possibleBoards = new ArrayList<Board>();
        for (int i = 0; i < board.getCells().size(); i++) {
            if (board.isAvailableCell(i)) {
                Board possibleBoard = board.markCell(i, currentPlayerMarker);
                possibleBoards.add(possibleBoard);
            }
        } return possibleBoards;
    }

    private int score(Board board, boolean maximisingPlayer) {
        if (board.win() && maximisingPlayer) {
            return -1;
        } else if (board.win() && !maximisingPlayer) {
            return 1;
        } return 0;
    }

    private String opponent(String currentPlayerMarker) {
        if (currentPlayerMarker.equals("x")) {
            return "o";
        } return "x";
    }

    private boolean isTerminal(Board board) {
        return board.win() || board.draw();
    }
}
