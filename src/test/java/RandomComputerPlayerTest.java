import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomComputerPlayerTest {

    private RandomComputerPlayer randomComputerPlayer = new RandomComputerPlayer("Computer", "o", new CliDisplay());

    @Test
    public void computerSetsNameAndMarkerUponInitialization() {
        assertEquals("Computer", randomComputerPlayer.getName());
        assertEquals("o", randomComputerPlayer.getMarker());
    }

    @Test
    public void computerGeneratesRandomCellPositionWithinGivenRange() {
        Board board = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        int randomNumber = randomComputerPlayer.getCellPosition(board);
        assertTrue(-1 < randomNumber);
        assertTrue(9 > randomNumber);
    }

    @Test
    public void computerMakesMoveOnBoardWithRandomCellWithinGivenRange() {
        Board emptyBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        Board movedOnBoard = new Board(randomComputerPlayer.makeMove(emptyBoard).getCells());
        assertTrue(movedOnBoard.getCells().contains("o"));
    }

    @Test
    public void randomComputerDoesNotTryToMarkOccupiedCell() {
        Board board = new Board(Arrays.asList("x", "", "", "", "", "o", "", "", ""));
        int randomNumber = randomComputerPlayer.getCellPosition(board);
        assertFalse(randomNumber == 0);
        assertFalse(randomNumber == 5);

    }

}
