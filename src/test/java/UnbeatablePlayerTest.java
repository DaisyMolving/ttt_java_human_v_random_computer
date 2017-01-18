import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnbeatablePlayerTest {

    private Player unbeatablePlayer = new UnbeatablePlayer("Michelle Obama", "x", new CliDisplay());

    @Test
    public void unbeatablePlayerCAnSetNameAndMarker() {
        assertEquals("Michelle Obama", unbeatablePlayer.getName());
        assertEquals("x", unbeatablePlayer.getMarker());
    }

    @Test
    public void unbeatablePlayerMakesMoveOnBoardWithMinimaxBestMove() {
        Board board = new Board(Arrays.asList("x", "o", "", "", "", "", "", "", ""));
        Board movedOnBoard = new Board(unbeatablePlayer.makeMove(board).getCells());
        Board bestMoveBoard = new Board(Arrays.asList("x", "o", "", "x", "", "", "", "", ""));
        assertEquals(bestMoveBoard.getCells(), movedOnBoard.getCells());
    }

    @Test
    public void unbeatablePlayersAreUnbeatable() {
        Player unbeatablePlayer = new UnbeatablePlayer("Michelle Obama", "x", new CliDisplay());
        Player unbeatablePlayerTwo = new UnbeatablePlayer("Megalodon Shark", "o", new CliDisplay());
        Board newBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        Game newGame = new Game(newBoard, new CliDisplay(), new Messenger(), unbeatablePlayer, unbeatablePlayerTwo);
        newGame.play();
        assertTrue(newGame.board.draw());
    }
}
