import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session = new Session(new CliDisplay(), new Messenger(), new PlayerCreator());

    @Test
    public void passesPlayersCreatedToNewGame() {
        Player playerOne = new HumanPlayer("Player One", "x", new CliDisplay());
        Player playerTwo = new RandomComputerPlayer("Player Two", "o", new CliDisplay());
        Game game = session.buildGame(playerOne, playerTwo);
        assertTrue(game.playerOne instanceof HumanPlayer);
        assertTrue(game.playerTwo instanceof RandomComputerPlayer);
    }
}
