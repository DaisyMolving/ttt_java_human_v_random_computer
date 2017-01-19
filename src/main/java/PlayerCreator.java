public class PlayerCreator {

    public Player playerOne;
    public Player playerTwo;


    public void createTwoHumans() {
        this.playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        this.playerTwo = new HumanPlayer("Player 2", "o", new CliDisplay());
    }

    public void createHumanAndRandomComputer() {
        this.playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        this.playerTwo = new RandomComputerPlayer("Player 2", "o", new CliDisplay());
    }

    public void createHumanAndUnbeatableComputer() {
        this.playerOne = new HumanPlayer("Player 1", "x", new CliDisplay());
        this.playerTwo = new UnbeatablePlayer("Player 2", "o", new CliDisplay());
    }

    public void createTwoUnbeatableComputers() {
        this.playerOne = new UnbeatablePlayer("Player 1", "x", new CliDisplay());
        this.playerTwo = new UnbeatablePlayer("Player 2", "o", new CliDisplay());
    }
}
