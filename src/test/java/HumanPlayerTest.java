import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer = new HumanPlayer("Shania Twain", "x");

    @Test
    public void humanPlayerCanSetNameAndMarker() {
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
        Board board = new Board();
        List<String> equivalentBoard = Arrays.asList("x", "", "", "", "", "", "", "", "");
        List<String> movedOnBoard = humanPlayer.makeMove(board);
        assertEquals(equivalentBoard, movedOnBoard);
    }
}
