import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {

    private Minimax minimax = new Minimax();

    @Test
    public void scoresWinAsOne() {
        Board winningBoard = new Board(Arrays.asList(
                "", "", "x",
                "o", "x", "",
                "x", "o", ""));
        int maximisingResult = minimax.alphaBeta(winningBoard, "o", Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        int minimisingResult = minimax.alphaBeta(winningBoard, "o", Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        assertEquals(-1, maximisingResult);
        assertEquals(1, minimisingResult);
    }

    @Test public void scoresDrawAsZero() {
        Board drawingBoard = new Board(Arrays.asList(
                "x", "x", "o",
                "o", "o", "x",
                "x", "x", "o"));
        int maximisingResult = minimax.alphaBeta(drawingBoard, "o", Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        int minimisingResult = minimax.alphaBeta(drawingBoard, "o", Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        assertEquals(0, maximisingResult);
        assertEquals(0, minimisingResult);
    }

    @Test
    public void takesTheWinningMove() {
        Board futureWinningBoard = new Board(Arrays.asList(
                "", "", "x",
                "x", "x", "o",
                "o", "o", ""));
        int bestMove = minimax.getBestMove(futureWinningBoard, "o");
        assertEquals(8, bestMove);
    }

    @Test
    public void takesFutureWinningMove() {
        Board futureWinningBoard = new Board(Arrays.asList(
                "", "o", "",
                "o", "x", "o",
                "", "x", ""));
        int bestMoveForCross = minimax.getBestMove(futureWinningBoard, "x");
        int bestMoveForNought = minimax.getBestMove(futureWinningBoard, "o");
        assertEquals(6, bestMoveForCross);
        assertEquals(0, bestMoveForNought);
    }

    @Test
    public void blocksOpponentWinAndWins() {
        Board board = new Board(Arrays.asList(
                "o", "o", "",
                "", "x", "o",
                "x", "", ""));
        int bestMoveForCross = minimax.getBestMove(board, "x");
        int bestMoveForNought = minimax.getBestMove(board, "o");
        assertEquals(2, bestMoveForCross);
        assertEquals(2, bestMoveForNought);
    }

    @Test
    public void blocksOpponentWinAndDoesNotLose() {
        Board board = new Board(Arrays.asList(
                "", "", "o",
                "", "", "",
                "x", "x", ""));
        int bestMoveForNought = minimax.getBestMove(board, "o");
        assertEquals(8, bestMoveForNought);
    }

    @Test
    public void preventsOpponentFromSettingUpFutureCrossWin() {
        Board board = new Board(Arrays.asList(
                "", "", "",
                "", "x", "",
                "", "", ""));
        int bestMoveForNought = minimax.getBestMove(board, "o");
        assertEquals(0, bestMoveForNought);
    }

    @Test
    public void preventsOpponentFromSettingUpSureWin() {
        Board board = new Board(Arrays.asList(
                "", "o", "x",
                "", "", "",
                "", "x", ""));
        int bestMoveForNought = minimax.getBestMove(board, "o");
        assertEquals(6, bestMoveForNought);
    }

    @Test
    public void takesFirstPossibleMoveOnUnWinnableBoard() {
        Board unwinnableBoard = new Board(Arrays.asList("o", "", "", "x", "x", "o", "o", "", "x"));
        int bestMoveForCross = minimax.getBestMove(unwinnableBoard, "x");
        int bestMoveForNought = minimax.getBestMove(unwinnableBoard, "o");
        assertEquals(1, bestMoveForCross);
        assertEquals(1, bestMoveForNought);
    }

    @Test
    public void inAnyGameOpponentsWillDrawOnThreeByThree() {
        Board newBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        int maximisingResult = minimax.alphaBeta(newBoard, "x", Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        int minimisingResult = minimax.alphaBeta(newBoard, "x", Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        assertEquals(0, maximisingResult);
        assertEquals(0, minimisingResult);
    }
}
