import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerCreatorTest {

    private PlayerCreator playerCreator = new PlayerCreator();

    @Test
    public void playerCreatorCreatesTwoHumanPlayers() {
        List<Player> listOfPlayers = playerCreator.createTwoHumans();
        assertEquals(HumanPlayer.class, listOfPlayers.get(0).getClass());
        assertEquals(HumanPlayer.class, listOfPlayers.get(1).getClass());
    }

    @Test
    public void playerCreatorCreatesHumanPlayerAndRandomComputerPlayer() {
        List<Player> listOfPlayers = playerCreator.createHumanAndRandomComputer();
        assertEquals(HumanPlayer.class, listOfPlayers.get(0).getClass());
        assertEquals(RandomComputerPlayer.class, listOfPlayers.get(1).getClass());
    }

    @Test
    public void playerCreatorCreatesHumanPlayerAndUnbeatableComputerPlayer() {
        List<Player> listOfPlayers = playerCreator.createHumanAndUnbeatableComputer();
        assertEquals(HumanPlayer.class, listOfPlayers.get(0).getClass());
        assertEquals(UnbeatablePlayer.class, listOfPlayers.get(1).getClass());
    }

    @Test
    public void playerCreatorCreatesTwoUnbeatableComputerPlayers() {
        List<Player> listOfPlayers = playerCreator.createTwoUnbeatableComputers();
        assertEquals(UnbeatablePlayer.class, listOfPlayers.get(0).getClass());
        assertEquals(UnbeatablePlayer.class, listOfPlayers.get(1).getClass());
    }

}
