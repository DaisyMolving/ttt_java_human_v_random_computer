import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RandomComputerPlayerTest {

    private RandomComputerPlayer randomComputerPlayer = new RandomComputerPlayer();

    @Test
    public void computerPlayerHasEmptyMarkerUponInitialization() {
        assertTrue(randomComputerPlayer.getMarker().isEmpty());
    }

    @Test
    public void computerPlayerHasSetNameUponInitialization() {
        assertEquals("Computer", randomComputerPlayer.getName());
    }

    @Test
    public void computerSetsMarkerUponInitialization() {
        randomComputerPlayer.build("o");
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
        randomComputerPlayer.build("o");
        Board emptyBoard = new Board();
        List<String> movedOnBoard = randomComputerPlayer.makeMove(emptyBoard);
        assertFalse(movedOnBoard.isEmpty());
        assertTrue(movedOnBoard.contains("o"));
    }

}
