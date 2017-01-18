import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer = new HumanPlayer("Shania Twain", "x", new CliDisplay());

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
//
//    @Test
//    public void humanPlayerMakesMove() {
//        Board emptyBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
//        Board equivalentBoard = new Board(Arrays.asList("x", "", "", "", "", "", "", "", ""));
//        Board movedOnBoard = new Board(humanPlayer.makeMove(emptyBoard).getCells());
//        assertEquals(equivalentBoard.getCells(), movedOnBoard.getCells());
//    }
}
