import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.*;

public class Minimax {

    public int getBestMove(Board board, String currentPlayerMarker) {
        int bestMove = Integer.MIN_VALUE;
        int bestScore = Integer.MIN_VALUE;
        if (timeToCalculate(board)) {
            for (int move = 0; move < board.getCells().size(); move++) {
                if (board.isAvailableCell(move)) {
                    Board possibleBoard = board.markCell(move, currentPlayerMarker);
                    int minimaxValue = alphaBeta(possibleBoard, opponent(currentPlayerMarker), Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                    if (minimaxValue > bestScore) {
                        bestScore = minimaxValue;
                        bestMove = move;
                    }
                }
            }
        } else {
            bestMove = randomlyPlacedMove(board);
        }
        return bestMove;
    }

    private int randomlyPlacedMove(Board board) {
        Random randomizer = new Random();
        List<String> availableCells = board.giveAvailableCells();
        String cell = availableCells.get(randomizer.nextInt(availableCells.size()));
        return Integer.valueOf(cell) - 1;
    }

    private boolean timeToCalculate(Board board) {
        return (dimension(board) <= 3) || (dimension(board) > 3 && board.giveAvailableCells().size() <= (board.getCells().size() - 5));
    }

    private int dimension(Board board) {
        return (int) Math.sqrt(board.getCells().size());
    }

    public int alphaBeta(Board board, String currentPlayerMarker, int alpha, int beta, boolean maximisingPlayer) {
        if (isTerminal(board)) {
            return score(board, maximisingPlayer);
        }
        if (maximisingPlayer) {
            for (Board child : findPossibleBoards(board, currentPlayerMarker)) {
                alpha = max(Arrays.asList(alpha, alphaBeta(child, opponent(currentPlayerMarker), alpha, beta, false)));
                if (alpha >= beta) {
                    break; }
            } return alpha;
        } else {
            for (Board child : findPossibleBoards(board, currentPlayerMarker)) {
                beta = min(Arrays.asList(beta, alphaBeta(child, opponent(currentPlayerMarker), alpha, beta, true)));
                if (alpha >= beta) {
                    break;
                }
            } return beta;
        }
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
