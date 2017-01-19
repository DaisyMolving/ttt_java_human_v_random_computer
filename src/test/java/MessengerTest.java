import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessengerTest {

    private Messenger messenger = new Messenger();

    @Test
    public void thatMessengerWelcomesPlayers() {
        assertTrue(messenger.welcomePlayers().contains("Welcome to TicTacToe!"));
    }

    @Test
    public void thatMessengerAsksUserToSelectGameType() {
        assertTrue(messenger.askGameType().contains("Human vs Human"));
        assertTrue(messenger.askGameType().contains("Human vs Random Computer"));
        assertTrue(messenger.askGameType().contains("Human vs Unbeatable Computer"));
        assertTrue(messenger.askGameType().contains("Unbeatable Computer vs Unbeatable Computer"));
    }

    @Test
    public void thatMessengerGivesInvalidMessageOfInvalidGameTypeInput() {
        assertTrue(messenger.invalidGameTypeMessage().contains("That is an invalid input"));
    }

    @Test
    public void thatMessengerAsksPlayerForTurnInput() {
        assertTrue(messenger.askPlayerForTurnInput("Gary", "x").contains("a number from 1 - 9"));
        assertTrue(messenger.askPlayerForTurnInput("Player 1", "x").contains("Player 1, with x"));
    }


    @Test
    public void thatMessengerGivesInvalidMessageForInvalidTurnInput() {
        assertTrue(messenger.invalidTurnMessage().contains("That is an invalid input"));
        assertTrue(messenger.invalidTurnMessage().contains("1 - 9 corresponding to an available cell"));
    }

    @Test
    public void thatMessengerGivesMessageForWin() {
        assertTrue(messenger.winnerMessage("1").contains("Player 1 wins!"));
    }

    @Test
    public void thatMessengerGivesMessageForDraw() {
        assertTrue(messenger.drawMessage().contains("draw"));
    }

    @Test
    public void thatMessengerCorrectlyFormatsCurrentBoardIntoRows() {
        Board currentBoard = new Board(Arrays.asList("", "o", "", "", "", "", "x", "", ""));
        assertEquals("1 o 3\n4 5 6\nx 8 9\n", messenger.setUpBoard(currentBoard));
    }
}
