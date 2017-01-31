import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridLineTest {

    GridLine gridLine = new GridLine();
    List<String> cellsOfThirdDimension = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    List<String> cellsOfFourthDimension = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16");

    @Test
    public void recognisesARowWinOfThree() {
        List<String> cells = Arrays.asList("x", "x", "x", "", "", "", "", "", "");
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
