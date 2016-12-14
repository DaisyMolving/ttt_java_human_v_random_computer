import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void humanMoveGivesCellNumber() {
        int cellIndex = humanPlayer.getCellPosition("1");
        assertEquals(0, cellIndex);
    }

    @Test
    public void humanPlayerMakesMove() {
        humanPlayer.build("Celine Dion", "x");
        Board board = new Board();
        List<String> equivalentBoard = Arrays.asList("x", "", "", "", "", "", "", "", "");
        List<String> movedOnBoard = humanPlayer.makeMove(board);
        assertEquals(equivalentBoard, movedOnBoard);
    }
}
