import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {

    private Minimax minimax = new Minimax();

    @Test
    public void scoresWinAsOne() {
        Board winningBoard = new Board(Arrays.asList(
                "", "", "x",
                "o", "x", "",
                "x", "o", ""));
        int maximisingResult = minimax.minimaxValue(winningBoard, "o", true);
        int minimisingResult = minimax.minimaxValue(winningBoard, "o", false);
        assertEquals(-1, maximisingResult);
        assertEquals(1, minimisingResult);
    }

    @Test
    public void scoresDrawAsZero() {
        Board drawingBoard = new Board(Arrays.asList("x", "x", "o", "o", "o", "x", "x", "x", "o"));
        int maximisingResult = minimax.minimaxValue(drawingBoard, "o", true);
        int minimisingResult = minimax.minimaxValue(drawingBoard, "o", false);
        assertEquals(0, maximisingResult);
        assertEquals(0, minimisingResult);
    }

    @Test
    public void scoresFutureWinAsOne() {
        Board futureWinningBoard = new Board(Arrays.asList(
                "", "", "x",
                "x", "x", "o",
                "o", "o", ""));
        int maximisingResult = minimax.minimaxValue(futureWinningBoard, "o", true);
        int minimisingResult = minimax.minimaxValue(futureWinningBoard, "o", false);
        assertEquals(Arrays.asList(0, 0, 1), minimax.mapMinimaxValues(futureWinningBoard, "o", true));
        assertEquals(1, maximisingResult);
        assertEquals(-1, minimisingResult);
    }

    //This test fails
    @Test
    public void scoresFutureWinTwoMovesDownAsOne() {
        Board futureWinningBoard = new Board(Arrays.asList(
                "", "o", "",
                "", "x", "o",
                "", "x", ""));
        int maximisingResult = minimax.minimaxValue(futureWinningBoard, "x", true);
        int minimisingResult = minimax.minimaxValue(futureWinningBoard, "x", false);
        assertEquals(Arrays.asList(0, 0, -1, 0, 1), minimax.mapMinimaxValues(futureWinningBoard, "x", true));
        assertEquals(1, maximisingResult);
        assertEquals(-1, minimisingResult);
    }

    @Test
    public void returnsPossibleBoards() {
        Board currentBoard = new Board(Arrays.asList("x", "x", "", "o", "", "o", "x", "o", "x"));
        List<Board> possibleBoards = minimax.findPossibleBoards(currentBoard, "x");
        Board possibleBoardOne = new Board(Arrays.asList("x", "x", "x", "o", "", "o", "x", "o", "x"));
        Board possibleBoardTwo = new Board(Arrays.asList("x", "x", "", "o", "x", "o", "x", "o", "x"));
        List<Board> setUpBoards = Arrays.asList(possibleBoardOne, possibleBoardTwo);
        assertEquals(getPossibleCells(setUpBoards), getPossibleCells(possibleBoards));
    }

    private List<List<String>> getPossibleCells(List<Board> possibleBoards) {
        List<List<String>> possibleCells = new ArrayList<List<String>>();
        for (int i = 0; i < possibleBoards.size(); i++) {
            possibleCells.add(possibleBoards.get(i).getCells());
        } return possibleCells;
    }

    @Test
    public void scoresAnUnwinnableBoardAsZero() {
        Board unwinnableBoard = new Board(Arrays.asList("o", "", "", "x", "x", "o", "o", "", "x"));
        int maximisingResult = new Minimax().minimaxValue(unwinnableBoard, "x", true);
        int minimisingResult = new Minimax().minimaxValue(unwinnableBoard, "x", false);
        assertEquals(0, maximisingResult);
        assertEquals(0, minimisingResult);

    }
}
