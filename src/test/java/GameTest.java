import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void switchesPlayers() {
        Display display = new CliDisplay();
        Player Barry = new HumanPlayer("Barry", "x", display);
        Player Gary = new RandomComputerPlayer("Gary", "x", display);
        Game newGame = new Game(new Board(Arrays.asList("", "", "", "", "", "", "", "", "")), new CliDisplay(), new Messenger(), Barry, Gary);
        newGame.switchPlayers();
        assertEquals("Gary", newGame.playerOne.getName());
        assertEquals("Barry", newGame.playerTwo.getName());
        assertEquals(RandomComputerPlayer.class, newGame.playerOne.getClass());
        assertEquals(HumanPlayer.class, newGame.playerTwo.getClass());
    }

}
