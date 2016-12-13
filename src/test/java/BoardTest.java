import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board = new Board();
    private List<String> numberedBoard = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Test
    public void knowsANewBoardGridHasNineCells() {
        assertEquals(9, new Board().getCells().size());
    }

    @Test
    public void knowsANewBoardGridIsEmpty() {
        List<String> emptyBoard = Arrays.asList("", "", "", "", "", "", "", "", "");
        assertTrue(board.isEmpty(emptyBoard));
    }

    @Test
    public void marksACell() {
        List<String> markedBoard = Arrays.asList(
                "x", "", "",
                "", "", "",
                "", "", "");
        assertEquals(markedBoard, board.markCell(0, "x"));
    }

    @Test
    public void knowsAMarkedBoardIsNotEmpty() {
        List<String> markedBoard = Arrays.asList("x", "", "", "", "", "", "", "", "");
        assertFalse(board.isEmpty(markedBoard));
    }

    @Test
    public void knowsIfACellIsEmpty() {
        List<String> markedBoard = Arrays.asList("x", "", "", "", "", "", "", "", "");
        assertFalse(board.isAvailableCell(markedBoard, 0));
        assertTrue(board.isAvailableCell(markedBoard, 1));
    }

    @Test
    public void findsBoardRows() {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("4", "5", "6"),
                Arrays.asList("7", "8", "9")
        );
        assertEquals(rows, board.getRows(numberedBoard));
    }

    @Test
    public void findsBoardColumns() {
        List<List<String>> columns = Arrays.asList(
                Arrays.asList("1", "4", "7"),
                Arrays.asList("2", "5", "8"),
                Arrays.asList("3", "6", "9")
        );
        assertEquals(columns, board.getColumns(numberedBoard));
    }

    @Test
    public void findsBoardDiagonals() {
        List<List<String>> diagonals = Arrays.asList(
                Arrays.asList("1", "5", "9"),
                Arrays.asList("3", "5", "7")
        );
        assertEquals(diagonals, board.getDiagonals(numberedBoard));
    }

    @Test
    public void recognisesARowWin() {
        List<String> markedBoard = Arrays.asList("x", "x", "x", "", "", "", "", "", "");
        assertTrue(board.win(markedBoard));
    }

    @Test
    public void recognisesANonWin() {
        List<String> markedBoard = Arrays.asList("x", "x", "", "", "", "", "", "", "");
        assertFalse(board.win(markedBoard));
        List<String> markedBoardTwo = Arrays.asList("x", "o", "x", "", "", "", "", "", "");
        assertFalse(board.win(markedBoardTwo));
    }

    @Test
    public void recognisesAColumnWin() {
        List<String> markedBoard = Arrays.asList("x", "", "", "x", "", "", "x", "", "");
        assertTrue(board.win(markedBoard));
    }

    @Test
    public void recognisesADiagonalWin() {
        List<String> markedBoard = Arrays.asList("x", "", "", "", "x", "", "", "", "x");
        assertTrue(board.win(markedBoard));
    }

    @Test
    public void recognisesADraw() {
        List<String> markedBoard = Arrays.asList("x", "o", "x", "x", "o", "x", "o", "x", "o");
        assertEquals(true, board.draw(markedBoard));
    }

    @Test
    public void recognisesANonDraw() {
        List<String> markedBoard = Arrays.asList("x", "o", "x", "x", "o", "x", "", "", "");
        assertFalse(board.draw(markedBoard));
    }
}