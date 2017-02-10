import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void switchesPlayers() {
        Display display = new CliDisplay();
        Player Barry = new HumanPlayer("Barry", "x", display);
        Player Gary = new RandomComputerPlayer("Gary", "x", display);
        Game newGame = new Game(new Board(Arrays.asList("", "", "", "", "", "", "", "", "")), display, new Messenger(), Barry, Gary);
        newGame.switchPlayers();
        assertEquals("Gary", newGame.playerOne.getName());
        assertEquals("Barry", newGame.playerTwo.getName());
        assertEquals(RandomComputerPlayer.class, newGame.playerOne.getClass());
        assertEquals(HumanPlayer.class, newGame.playerTwo.getClass());
    }

    @Test
    public void twoUnbeatableComputersWillDraw() {
        Display display = new CliDisplay();
        Player ComputerOne = new UnbeatablePlayer("Computer", "x", display);
        Player ComputerTwo = new UnbeatablePlayer("Computer", "o", display);
        Board fourByFourBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        Game newGame = new Game(fourByFourBoard, display, new Messenger(), ComputerOne, ComputerTwo);
        newGame.play();
        assertTrue(newGame.board.draw());
    }
}
