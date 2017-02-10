import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridLineTest {

    GridLine gridLine = new GridLine();
    long start;

    @Before
    public void start() {
        start = System.currentTimeMillis();
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
    public void benchmarkGetSequences() {
        List<String> cells = Arrays.asList("", "", "x", "", "x", "", "x", "", "");

        for (int i = 0; i < 1000; i++) {
            gridLine.isWinningLine(cells);
        }
    }

    @Test
    public void recognisesARowWinOfThree() {
        List<String> firstRowCells = Arrays.asList("x", "x", "x", "", "", "", "", "", "");
        assertTrue(gridLine.isWinningLine(firstRowCells));
        List<String> lastRowCells = Arrays.asList("", "", "", "", "", "", "x", "x", "x");
        assertTrue(gridLine.isWinningLine(lastRowCells));
    }

    @Test
    public void recognisesARowWinOfFour() {
        List<String> firstRowCells = Arrays.asList("x", "x", "x", "x", "", "", "", "", "", "", "", "", "", "", "", "");
        assertTrue(gridLine.isWinningLine(firstRowCells));
        List<String> lastRowCells = Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "x", "x", "x", "x");
        assertTrue(gridLine.isWinningLine(lastRowCells));
    }

    @Test
    public void recognisesAColumnWinOfThree() {
        List<String> firstColumnCells = Arrays.asList("x", "", "", "x", "", "", "x", "", "");
        assertTrue(gridLine.isWinningLine(firstColumnCells));
        List<String> lastColumnCells = Arrays.asList("", "", "o", "", "", "o", "", "", "o");
        assertTrue(gridLine.isWinningLine(lastColumnCells));
    }

    @Test
    public void recognisesAColumnWinOfFour() {
        List<String> firstColumnCells = Arrays.asList("x", "", "", "", "x", "", "", "", "x", "", "", "", "x", "", "", "");
        assertTrue(gridLine.isWinningLine(firstColumnCells));
        List<String> lastColumnCells = Arrays.asList("", "", "", "x", "", "", "", "x", "", "", "", "x", "", "", "", "x");
        assertTrue(gridLine.isWinningLine(lastColumnCells));
    }

    @Test
    public void recognisesADiagonalWinOfThree() {
        List<String> forwardsDiagonalCells = Arrays.asList("x", "", "", "", "x", "", "", "", "x");
        assertTrue(gridLine.isWinningLine(forwardsDiagonalCells));
        List<String> backwardsDiagonalCells = Arrays.asList("", "", "x", "", "x", "", "x", "", "");
        assertTrue(gridLine.isWinningLine(backwardsDiagonalCells));
    }

    @Test
    public void recognisesADiagonalWinOfFour() {
        List<String> forwardDiagonalCells = Arrays.asList("x", "", "", "", "", "x", "", "", "", "", "x", "", "", "", "", "x");
        assertTrue(gridLine.isWinningLine(forwardDiagonalCells));
        List<String> backwardDiagonalCells = Arrays.asList("", "", "", "x", "", "", "x", "", "", "x", "", "", "x", "", "", "");
        assertTrue(gridLine.isWinningLine(backwardDiagonalCells));
    }

    @Test
    public void recognisesANonWin() {
        List<String> notYetWinCells = Arrays.asList("x", "x", "", "", "", "", "", "", "");
        assertFalse(gridLine.isWinningLine(notYetWinCells));
        List<String> lastRowNotYetWinCells = Arrays.asList("", "", "", "", "", "", "", "x", "x");
        assertFalse(gridLine.isWinningLine(lastRowNotYetWinCells));
        List<String> blockedFromWinCells = Arrays.asList("x", "o", "x", "", "", "", "", "", "");
        assertFalse(gridLine.isWinningLine(blockedFromWinCells));
    }
}
