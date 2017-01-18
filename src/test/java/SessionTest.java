import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionTest {

    @Test
    public void sessionCreatesGameBasedOnUserInput() {
        Session session = new Session(new CliDisplay(), new Messenger());
        session.createGameOfType("a");
        assertEquals(HumanPlayer.class, session.game.playerOne.getClass());
    }
}
