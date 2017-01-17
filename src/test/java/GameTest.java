import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void switchesPlayers() {
        Game newGame = new Game(new Board(Arrays.asList("", "", "", "", "", "", "", "", "")), new CliDisplay(), new Messenger());
        newGame.createPlayers("b");
        newGame.switchPlayers();
        assertEquals("Player 2", newGame.playerOne.getName());
        assertEquals("Player 1", newGame.playerTwo.getName());
        assertEquals(RandomComputerPlayer.class, newGame.playerOne.getClass());
        assertEquals(HumanPlayer.class, newGame.playerTwo.getClass());
    }

}
