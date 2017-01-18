import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
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
        int randomNumber = randomComputerPlayer.getCellPosition(0, 8);
        assertTrue(-1 < randomNumber);
        assertTrue(9 > randomNumber);
    }

    @Test
    public void computerMakesMoveOnBoardWithRandomCellWithinGivenRange() {
        Board emptyBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        Board movedOnBoard = new Board(randomComputerPlayer.makeMove(emptyBoard).getCells());
        assertTrue(movedOnBoard.getCells().contains("o"));
    }

}
