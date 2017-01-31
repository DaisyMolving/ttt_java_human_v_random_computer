import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session = new Session(new CliDisplay(), new Messenger(), new PlayerCreator(), new BoardCreator());

    @Test
    public void passesPlayersCreatedToNewGame() {
    }
}
