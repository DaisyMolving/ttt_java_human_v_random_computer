import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessengerTest {

    private Messenger messenger = new Messenger();

    @Test
    public void thatMessengerWelcomesPlayers() {
        assertEquals("Welcome to TicTacToe!", messenger.welcomePlayers());
    }

    @Test
    public void thatMessengerAsksUserToSelectGameType() {
        assertTrue(messenger.askGameType().contains("Human vs Human"));
        assertTrue(messenger.askGameType().contains("Human vs Random Computer"));
    }

    @Test
    public void thatMessengerGivesInvalidMessageOfInvalidGameTypeInput() {
        assertTrue(messenger.invalidGameTypeMessage().contains("That is an invalid input"));
    }

    @Test
    public void thatMessengerAsksPlayerForTurnInput() {
        assertTrue(messenger.askPlayerForTurnInput("1", "x").contains("a number from 1 - 9"));
        assertTrue(messenger.askPlayerForTurnInput("1", "x").contains("Player 1, with x"));
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
        List<String> currentBoard = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        assertEquals("1 2 3\n4 5 6\n7 8 9\n", messenger.formatBoard(currentBoard));
        List<String> markedBoard = Arrays.asList("x", "o", "x", "x", "o", "x", "o", "x", "o");
        assertEquals("x o x\nx o x\no x o\n", messenger.formatBoard(markedBoard));
    }

}
