import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessengerTest {

    @Test
    public void thatMessengerWelcomesPlayers() {
        Messenger messenger = new Messenger();
        assertEquals("Welcome to TicTacToe!", messenger.welcomePlayers());
    }

    @Test
    public void thatMessengerAsksUserToSelectGameType() {
        Messenger messenger = new Messenger();
        assertTrue(messenger.askGameType().contains("Human vs Human"));
        assertTrue(messenger.askGameType().contains("Human vs Random Computer"));
    }

    @Test
    public void thatMessengerGivesInvalidMessageOfInvalidGameTypeInput() {
        Messenger messenger = new Messenger();
        assertTrue(messenger.invalidGameTypeMessage().contains("That is an invalid input"));
    }

}
