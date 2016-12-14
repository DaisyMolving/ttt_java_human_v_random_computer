import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomComputerPlayerTest {

    private RandomComputerPlayer randomComputerPlayer = new RandomComputerPlayer("Computer", "o");

    @Test
    public void computerSetsNameUponInitialization() {
        assertEquals("Computer", randomComputerPlayer.getName());
    }

    @Test
    public void computerSetsMarkerUponInitialization() {
        assertEquals("o", randomComputerPlayer.getMarker());
    }

    @Test
    public void computerGeneratesRandomCellPositionWithinGivenRange() {
        int randomNumber = randomComputerPlayer.getCellPosition(0, 8);
        assertTrue(-1 < randomNumber);
        assertTrue(9 > randomNumber);
    }

    @Test
    public void computerMakesMoveOnBoardWithRandomCellWithinGivenRange() {
        Board emptyBoard = new Board();
        List<String> movedOnBoard = randomComputerPlayer.makeMove(emptyBoard);
        assertFalse(movedOnBoard.isEmpty());
        assertTrue(movedOnBoard.contains("o"));
    }

}
