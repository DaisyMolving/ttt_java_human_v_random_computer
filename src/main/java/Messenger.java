import java.util.List;

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

    public String askPlayerForTurnInput(String playerNumber, String marker) {
        return "Player " + playerNumber + ", with "+ marker + ", please select a number from 1 - 9 to mark a corresponding cell on the grid\n";
    }

    public String invalidTurnMessage() {
        return "That is an invalid input. Please select a number from 1 - 9 corresponding to an available cell";
    }

    public String winnerMessage(String playerNumber) {
        return "Player " + playerNumber + " wins!";
    }

    public String drawMessage() {
        return "It's a draw!";
    }

    public String setUpBoard(List<String> currentBoard){
        return formatBoard(numberBoard(currentBoard));
    }

    private List<String> numberBoard(List<String> currentBoard) {
        for (int i = 0; i < currentBoard.size(); i ++) {
            if (currentBoard.get(i) == "") {
                currentBoard.set(i, String.valueOf(i + 1));
            }
        } return currentBoard;
    }

    private String formatBoard(List<String> currentBoard) {
        String formattedBoard = "";
        for (int i = 0; i < currentBoard.size(); i++) {
            if (endOfRow(i)) {
                formattedBoard = formattedBoard.concat(currentBoard.get(i)).concat("\n");
            } else {
                formattedBoard = formattedBoard.concat(currentBoard.get(i)).concat(" ");
            }
        } return formattedBoard;
    }

    private boolean endOfRow(int index) {
        return ((index + 1) % 3 == 0);
    }

    public Pair requestGameType(String option) {
        if (option == "a") {
            return new Pair("ok", "");
        } else if (option == "b") {
            return new Pair("ok", "");
        } else {
            return new Pair("invalid", invalidGameTypeMessage());
        }
    }

    public Pair requestTurn(String option) {
        if (option.matches("[1-9]")) {
            return new Pair("ok", "");
        } else {
            return new Pair("invalid", invalidTurnMessage());
        }
    }
}