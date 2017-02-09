import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridLineTest {

    GridLine gridLine = new GridLine();
    int start;

    @Before
    public void start() {
        start = (int) System.currentTimeMillis();
    }

    @After
    public void end() {
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void benchmarkForWinningLineTestWithNoWin() {
        System.out.println("not winning line");
        gridLine.isWinningLine(Arrays.asList("", "", "", "", "", "", "", "", ""));
    }

    @Test
    public void benchmarkForWinningLineTestWithWin() {
        System.out.println("winning line");
        gridLine.isWinningLine(Arrays.asList("x", "x", "x", "", "", "", "", "", ""));
    }

    @Test
    public void recognisesARowWinOfThree() {
        List<String> cells = Arrays.asList("x", "x", "x", "", "", "", "", "", "");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesARowWinOfFour() {
        List<String> cells = Arrays.asList("x", "x", "x", "x", "", "", "", "", "", "", "", "", "", "", "", "");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesAColumnWinOfThree() {
        List<String> cells = Arrays.asList("x", "", "", "x", "", "", "x", "", "");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesAColumnWinOfFour() {
        List<String> cells = Arrays.asList("x", "", "", "", "x", "", "", "", "x", "", "", "", "x", "", "", "");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesADiagonalWinOfThree() {
        List<String> cells = Arrays.asList("x", "", "", "", "x", "", "", "", "x");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesADiagonalWinOfFour() {
        List<String> cells = Arrays.asList("x", "", "", "", "", "x", "", "", "", "", "x", "", "", "", "", "x");
        assertTrue(gridLine.isWinningLine(cells));
    }

    @Test
    public void recognisesANonWin() {
        List<String> notYetWinCells = Arrays.asList("x", "x", "", "", "", "", "", "", "");
        assertFalse(gridLine.isWinningLine(notYetWinCells));
        List<String> blockedFromWinCells = Arrays.asList("x", "o", "x", "", "", "", "", "", "");
        assertFalse(gridLine.isWinningLine(blockedFromWinCells));
    }
}
