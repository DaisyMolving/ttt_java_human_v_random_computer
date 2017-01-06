import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class MinimaxTest {

    @Test
    public void scoresWinAsOne() {
        Board winningBoard = new Board(Arrays.asList("", "", "x", "o", "x", "", "x", "o", ""));
        int minimisingResult = new Minimax().minimaxValue(winningBoard, "o", false);
        int maximisingResult = new Minimax().minimaxValue(winningBoard, "o", true);
        assertEquals(-1, minimisingResult);
        assertEquals(1, maximisingResult);
    }

    @Test
    public void scoresDrawAsZero() {
        Board drawingBoard = new Board(Arrays.asList("x", "x", "o", "o", "o", "x", "x", "x", "o"));
        int maximisingResult = new Minimax().minimaxValue(drawingBoard, "o", true);
        int minimisingResult = new Minimax().minimaxValue(drawingBoard, "o", false);
        assertEquals(0, maximisingResult);
        assertEquals(0, minimisingResult);
    }
}
