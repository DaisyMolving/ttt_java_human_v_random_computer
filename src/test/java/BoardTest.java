import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Board emptyBoardOfNine = new Board(3);
    private Board emptyBoardOfSixteen = new Board(4);
    private Board markedBoardOfNine = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));
    private Board markedBoardOfSixteen = new Board( Arrays.asList("x", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

    @Test
    public void boardCanBeInitialisedWithAnyDimensionButMustBeSquare() {
        Board fourByFourBoard = new Board(4);
        Board threeByThreeBoard = new Board(3);
        assertEquals(16, fourByFourBoard.getCells().size());
        assertEquals(9, threeByThreeBoard.getCells().size());
    }

    @Test
    public void knowsANewBoardGridIsEmpty() {
        assertTrue(emptyBoardOfNine.boardIsEmpty());
        assertTrue(emptyBoardOfSixteen.boardIsEmpty());
    }

    @Test
    public void marksACell() {
        assertEquals(markedBoardOfNine.getCells(), emptyBoardOfNine.markCell(0, "x").getCells());
        assertEquals(markedBoardOfSixteen.getCells(), emptyBoardOfSixteen.markCell(0, "x").getCells());
    }

    @Test
    public void knowsAMarkedBoardIsNotEmpty() {
        assertFalse(markedBoardOfNine.boardIsEmpty());
        assertFalse(markedBoardOfSixteen.boardIsEmpty());
    }

    @Test
    public void knowsIfACellIsEmpty() {
        assertTrue(markedBoardOfNine.isPopulatedCell(0));
        assertTrue(markedBoardOfNine.isAvailableCell(1));
    }

    @Test
    public void canProduceAListOfAvailablePositions() {
        Board boardInProgress = new Board(Arrays.asList("", "x", "o", "x", "", "x", "", "o", "o"));
        assertEquals(Arrays.asList("1", "5", "7"), boardInProgress.giveAvailableCells());
    }

    @Test
    public void createsNewBoardEveryTimeACellIsMarked() {
        Board clone = emptyBoardOfNine.markCell(1, "x");
        assertTrue(clone.isPopulatedCell(1) );
        assertTrue(emptyBoardOfNine.isAvailableCell(1) );
    }

    @Test
    public void findsBoardRowsOfThree() {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("4", "5", "6"),
                Arrays.asList("7", "8", "9")
        );
        assertEquals(rows, getNumberedBoard(3).getRows());
    }

    @Test
    public void findsBoardRowsOfFour() {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("1", "2", "3", "4"),
                Arrays.asList("5", "6", "7", "8"),
                Arrays.asList("9", "10", "11", "12"),
                Arrays.asList("13", "14", "15", "16")
        );
        assertEquals(rows, getNumberedBoard(4).getRows());
    }

    @Test
    public void findsBoardColumnsOfThree() {
        List<List<String>> columns = Arrays.asList(
                Arrays.asList("1", "4", "7"),
                Arrays.asList("2", "5", "8"),
                Arrays.asList("3", "6", "9")
        );
        assertEquals(columns, getNumberedBoard(3).getColumns());
    }

    @Test
    public void findsBoardColumnsOfFour() {
        List<List<String>> columns = Arrays.asList(
                Arrays.asList("1", "5", "9", "13"),
                Arrays.asList("2", "6", "10", "14"),
                Arrays.asList("3", "7", "11", "15"),
                Arrays.asList("4", "8", "12", "16")
        );
        assertEquals(columns, getNumberedBoard(4).getColumns());
    }

    @Test
    public void findsBoardDiagonalsOfThree() {
        List<List<String>> diagonals = Arrays.asList(
                Arrays.asList("1", "5", "9"),
                Arrays.asList("3", "5", "7")
        );
        assertEquals(diagonals, getNumberedBoard(3).getDiagonals());
    }

    @Test
    public void findsBoardDiagonalsOfFour() {
        List<List<String>> diagonals = Arrays.asList(
                Arrays.asList("1", "6", "11", "16"),
                Arrays.asList("4", "7", "10", "13")
        );
        assertEquals(diagonals, getNumberedBoard(4).getDiagonals());
    }

    @Test
    public void recognisesARowWinOfThree() {
        Board winningRowBoard = new Board(Arrays.asList("x", "x", "x", "", "", "", "", "", ""));
        assertTrue(winningRowBoard.win());
    }

    @Test
    public void recognisesARowWinOfFour() {
        Board winningBoard = new Board(Arrays.asList("x", "x", "x", "x", "", "", "", "", "", "", "", "", "", "", "", ""));
        assertTrue(winningBoard.win());
    }

    @Test
    public void recognisesANonWin() {
        Board notWinningBoard = new Board(Arrays.asList("x", "x", "", "", "", "", "", "", ""));
        assertFalse(notWinningBoard.win());
        Board blockedFromWinBoard = new Board(Arrays.asList("x", "o", "x", "", "", "", "", "", ""));
        assertFalse(blockedFromWinBoard.win());
    }

    @Test
    public void recognisesAColumnWinOfThree() {
        Board winningColumnBoard = new Board(Arrays.asList("x", "", "", "x", "", "", "x", "", ""));
        assertTrue(winningColumnBoard.win());
    }

    @Test
    public void recognisesAColumnWinOfFour() {
        Board winningColumnBoard = new Board(Arrays.asList("x", "", "", "", "x", "", "", "", "x", "", "", "", "x", "", "", ""));
        assertTrue(winningColumnBoard.win());
    }

    @Test
    public void recognisesADiagonalWinOfThree() {
        Board winningDiagonalBoard = new Board(Arrays.asList("x", "", "", "", "x", "", "", "", "x"));
        assertTrue(winningDiagonalBoard.win());
    }

    @Test
    public void recognisesADiagonalWinOfFour() {
        Board winningDiagonalBoard = new Board(Arrays.asList("x", "", "", "", "", "x", "", "", "", "", "x", "", "", "", "", "x"));
        assertTrue(winningDiagonalBoard.win());
    }

    @Test
    public void recognisesADrawOnThreeByThree() {
        Board drawingBoard = new Board(Arrays.asList("x", "o", "x", "x", "o", "x", "o", "x", "o"));
        assertTrue(drawingBoard.draw());
    }

    @Test
    public void recognisesADrawOnFourByFour() {
        Board drawingBoard = new Board(Arrays.asList(
                "x", "o", "x", "x",
                "o", "x", "o", "x",
                "o", "x", "o", "o",
                "x", "x", "x", "o"));
        assertTrue(drawingBoard.draw());
    }

    @Test
    public void recognisesANonDraw() {
        Board boardInProgress = new Board(Arrays.asList("x", "o", "x", "x", "o", "x", "", "", ""));
        assertFalse(boardInProgress.draw());
    }

    @Test
    public void recognisesAnotherNonDraw() {
        Board drawingBoard = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));
        assertFalse(drawingBoard.draw());
    }

    private Board getNumberedBoard(int dimension) {
        Board board = new Board(dimension);
        for (int i = 0; i < board.getCells().size(); i ++) {
            int cellNumber = i + 1;
            board.getCells().set(i, String.valueOf(cellNumber));
        } return board;
    }
}
