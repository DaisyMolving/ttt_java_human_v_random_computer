public class Messenger {

    public String welcomePlayers() {
        return "Welcome to TicTacToe!";
    }

    public String askGameType() {
        return "What sort of game would you like to play?\n\na) Human vs Human?\nOr b) Human vs Random Computer?\n";
    }

    public String invalidGameTypeMessage() {
        return "That is an invalid input. Please select option a or b:\n";
    }
}
