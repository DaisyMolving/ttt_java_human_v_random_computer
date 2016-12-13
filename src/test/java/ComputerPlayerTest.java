import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerPlayerTest {

    @Test
    public void computerPlayerHasEmptyMarkerUponInitialization() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        assertTrue(computerPlayer.getMarker().isEmpty());
    }

    @Test
    public void computerPlayerHasSetNameUponInitialization() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        assertEquals("Computer", computerPlayer.getName());
    }

    @Test
    public void computerMoveGeneratesRandomCellNumber() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        assertTrue(computerPlayer.move().matches("[0-8]"));
    }
}
