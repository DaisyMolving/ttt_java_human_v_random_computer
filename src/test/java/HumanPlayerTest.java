import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer = new HumanPlayer();

    @Test
    public void humanPlayerHasEmptyNameUponInitialization() {
        assertTrue(humanPlayer.getName().isEmpty());
    }

    @Test
    public void humanPlayerHasEmptyMarkerUponInitialization() {
        assertTrue(humanPlayer.getMarker().isEmpty());
    }

    @Test
    public void humanPlayerCanSetNameAndMarker() {
        humanPlayer.build("Shania Twain", "x");
        assertEquals("Shania Twain", humanPlayer.getName());
        assertEquals("x", humanPlayer.getMarker());
    }

}
