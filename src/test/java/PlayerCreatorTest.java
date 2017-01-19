import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerCreatorTest {

    private PlayerCreator playerCreator = new PlayerCreator();

    @Test
    public void playerCreatorCreatesTwoHumanPlayers() {
        playerCreator.createTwoHumans();
        assertEquals(HumanPlayer.class, playerCreator.playerOne.getClass());
        assertEquals(HumanPlayer.class, playerCreator.playerTwo.getClass());
    }

    @Test
    public void playerCreatorCreatesHumanPlayerAndRandomComputerPlayer() {
        playerCreator.createHumanAndRandomComputer();
        assertEquals(HumanPlayer.class, playerCreator.playerOne.getClass());
        assertEquals(RandomComputerPlayer.class, playerCreator.playerTwo.getClass());
    }

    @Test
    public void playerCreatorCreatesHumanPlayerAndUnbeatableComputerPlayer() {
        playerCreator.createHumanAndUnbeatableComputer();
        assertEquals(HumanPlayer.class, playerCreator.playerOne.getClass());
        assertEquals(UnbeatablePlayer.class, playerCreator.playerTwo.getClass());
    }

    @Test
    public void playerCreatorCreatesTwoUnbeatableComputerPlayers() {
        playerCreator.createTwoUnbeatableComputers();
        assertEquals(UnbeatablePlayer.class, playerCreator.playerOne.getClass());
        assertEquals(UnbeatablePlayer.class, playerCreator.playerTwo.getClass());
    }

}
