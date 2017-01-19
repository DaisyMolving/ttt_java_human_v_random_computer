import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session = new Session(new CliDisplay(), new Messenger());

    @Test
    public void sessionCreatesPlayersBasedOnUserInput() {
        session.createPlayersOfType("a");
        assertTrue(session.playerCreator.playerOne instanceof HumanPlayer);
        assertTrue(session.playerCreator.playerTwo instanceof HumanPlayer);
        session.createPlayersOfType("d");
        assertTrue(session.playerCreator.playerOne instanceof UnbeatablePlayer);
        assertTrue(session.playerCreator.playerTwo instanceof UnbeatablePlayer);
    }

    @Test
    public void passesPlayersCreatedToNewGame() {
        session.createPlayersOfType("b");
        session.buildGame(session.playerCreator.playerOne, session.playerCreator.playerTwo);
        assertTrue(session.game.playerOne instanceof HumanPlayer);
        assertTrue(session.game.playerTwo instanceof RandomComputerPlayer);
    }
}
