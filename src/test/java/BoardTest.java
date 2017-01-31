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
    private Board markedBoardOfSixteen = new Board(Arrays.asList("x", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

    @Test
    public void boardCanBeInitialisedWithAnyDimensionButMustBeSquare() {
        Board fourByFourBoard = new Board(4);
        Board threeByThreeBoard = new Board(3);
        assertEquals(16, fourByFourBoard.getCells().size());
        assertEquals(9, threeByThreeBoard.getCells().size());
    }

    @Test
    public void marksACell() {
        assertEquals(markedBoardOfNine.getCells(), emptyBoardOfNine.markCell(0, "x").getCells());
        assertEquals(markedBoardOfSixteen.getCells(), emptyBoardOfSixteen.markCell(0, "x").getCells());
    }

    @Test
    public void canProduceAListOfAvailablePositions() {
        Board boardInProgress = new Board(Arrays.asList("", "x", "o", "x", "", "x", "", "o", "o"));
        assertEquals(Arrays.asList("1", "5", "7"), boardInProgress.giveAvailableCells());
    }

    @Test
    public void createsNewBoardEveryTimeACellIsMarked() {
        Board clone = emptyBoardOfNine.markCell(1, "x");
        assertTrue(clone.getCells().contains("x"));
        assertFalse(emptyBoardOfNine.getCells().contains("x"));
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
}
