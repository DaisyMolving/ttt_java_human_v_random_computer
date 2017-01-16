import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Board emptyBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
    private Board numberedBoard = new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    private Board markedBoard = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));

    @Test
    public void knowsANewBoardGridHasNineCells() {
        assertEquals(9, emptyBoard.getCells().size());
    }

    @Test
    public void knowsANewBoardGridIsEmpty() {
        assertTrue(emptyBoard.boardIsEmpty());
    }

    @Test
    public void marksACell() {
        assertEquals(markedBoard.getCells(), emptyBoard.markCell(0, "x").getCells());
    }

    @Test
    public void knowsAMarkedBoardIsNotEmpty() {
        assertFalse(markedBoard.boardIsEmpty());
    }

    @Test
    public void knowsIfACellIsEmpty() {
        assertFalse(markedBoard.isAvailableCell(0));
        assertTrue(markedBoard.isAvailableCell(1));
    }

    @Test
    public void findsBoardRows() {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("4", "5", "6"),
                Arrays.asList("7", "8", "9")
        );
        assertEquals(rows, numberedBoard.getRows());
    }

    @Test
    public void findsBoardColumns() {
        List<List<String>> columns = Arrays.asList(
                Arrays.asList("1", "4", "7"),
                Arrays.asList("2", "5", "8"),
                Arrays.asList("3", "6", "9")
        );
        assertEquals(columns, numberedBoard.getColumns());
    }

    @Test
    public void findsBoardDiagonals() {
        List<List<String>> diagonals = Arrays.asList(
                Arrays.asList("1", "5", "9"),
                Arrays.asList("3", "5", "7")
        );
        assertEquals(diagonals, numberedBoard.getDiagonals());
    }

    @Test
    public void recognisesARowWin() {
        Board winningRowBoard = new Board(Arrays.asList("x", "x", "x", "", "", "", "", "", ""));
        assertTrue(winningRowBoard.win());
    }

    @Test
    public void recognisesANonWin() {
        Board notWinningBoard = new Board(Arrays.asList("x", "x", "", "", "", "", "", "", ""));
        assertFalse(notWinningBoard.win());
        Board blockedFromWinBoard = new Board(Arrays.asList("x", "o", "x", "", "", "", "", "", ""));
        assertFalse(blockedFromWinBoard.win());
    }

    @Test
    public void recognisesAColumnWin() {
        Board winningColumnBoard = new Board(Arrays.asList("x", "", "", "x", "", "", "x", "", ""));
        assertTrue(winningColumnBoard.win());
    }

    @Test
    public void recognisesADiagonalWin() {
        Board winningDiagonalBoard = new Board(Arrays.asList("x", "", "", "", "x", "", "", "", "x"));
        assertTrue(winningDiagonalBoard.win());
    }

    @Test
    public void recognisesADraw() {
        Board drawingBoard = new Board(Arrays.asList("x", "o", "x", "x", "o", "x", "o", "x", "o"));
        assertTrue(drawingBoard.draw());
    }

    @Test
    public void theCaseWhishBugged() {
        Board drawingBoard = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));
        assertFalse(drawingBoard.draw());
    }

    @Test
    public void recognisesANonDraw() {
        Board boardInProgress = new Board(Arrays.asList("x", "o", "x", "x", "o", "x", "", "", ""));
        assertFalse(boardInProgress.draw());
    }
}
