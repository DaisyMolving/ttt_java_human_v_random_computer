import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board = new Board();
    private Board numberedBoard() {
        board.markCell(0, "1");
        board.markCell(1, "2");
        board.markCell(2, "3");
        board.markCell(3, "4");
        board.markCell(4, "5");
        board.markCell(5, "6");
        board.markCell(6, "7");
        board.markCell(7, "8");
        board.markCell(8, "9");
        return board;
    }

    @Test
    public void knowsANewBoardGridHasNineCells() {
        assertEquals(9, new Board().getCells().size());
    }

    @Test
    public void knowsANewBoardGridIsEmpty() {
        assertTrue(board.gridIsEmpty());
    }

    @Test
    public void marksACell() {
        List<String> currentGrid = Arrays.asList(
                "x", "", "",
                "", "", "",
                "", "", "");
        ArrayList markedBoard = new ArrayList(currentGrid);
        assertEquals(markedBoard, board.markCell(0, "x"));
    }

    @Test
    public void knowsAMarkedBoardIsNotEmpty() {
        board.markCell(0, "x");
        assertFalse(board.gridIsEmpty());
    }

    @Test
    public void knowsIfACellIsEmpty() {
        board.markCell(0, "x");
        assertFalse(board.availableCell(0));
        assertTrue(board.availableCell(1));
    }

    @Test
    public void findsBoardRows() {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("4", "5", "6"),
                Arrays.asList("7", "8", "9")
        );
        assertEquals(rows, numberedBoard().getRows());
    }

    @Test
    public void findsBoardColumns() {
        List<List<String>> columns = Arrays.asList(
                Arrays.asList("1", "4", "7"),
                Arrays.asList("2", "5", "8"),
                Arrays.asList("3", "6", "9")
        );
        assertEquals(columns, numberedBoard().getColumns());
    }

    @Test
    public void findsBoardDiagonals() {
        List<List<String>> diagonals = Arrays.asList(
                Arrays.asList("1", "5", "9"),
                Arrays.asList("3", "5", "7")
        );
        assertEquals(diagonals, numberedBoard().getDiagonals());
    }

    @Test
    public void recognisesARowWin() {
        board.markCell(0, "x");
        board.markCell(1, "x");
        board.markCell(2, "x");
        assertTrue(board.win());
    }

    @Test
    public void recognisesANonWin() {
        board.markCell(0, "x");
        board.markCell(2, "x");
        assertFalse(board.win());
        board.markCell(0, "x");
        board.markCell(1, "o");
        board.markCell(2, "x");
        assertFalse(board.win());
    }

    @Test
    public void recognisesAColumnWin() {
        board.markCell(0, "o");
        board.markCell(3, "o");
        board.markCell(6, "o");
        assertTrue(board.win());
    }

    @Test
    public void recognisesADiagonalWin() {
        board.markCell(0, "o");
        board.markCell(4, "o");
        board.markCell(8, "o");
        assertTrue(board.win());
    }

    @Test
    public void recognisesADraw() {
        board.markCell(0, "x");
        board.markCell(1, "o");
        board.markCell(2, "x");
        board.markCell(3, "x");
        board.markCell(4, "o");
        board.markCell(5, "x");
        board.markCell(6, "o");
        board.markCell(7, "x");
        board.markCell(8, "o");
        assertTrue(board.draw());
    }

    @Test
    public void recognisesANonDraw() {
        board.markCell(0, "x");
        board.markCell(1, "o");
        board.markCell(2, "x");
        board.markCell(3, "x");
        board.markCell(5, "x");
        board.markCell(6, "o");
        assertFalse(board.draw());
    }
}