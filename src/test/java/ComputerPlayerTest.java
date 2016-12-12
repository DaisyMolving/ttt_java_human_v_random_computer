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
}
