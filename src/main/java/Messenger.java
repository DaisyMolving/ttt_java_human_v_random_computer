import java.util.ArrayList;
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

    public String askPlayerForTurnInput(String playerName, String marker) {
        return playerName + ", with "+ marker + ", please select a number from 1 - 9 to mark a corresponding cell on the grid\n";
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

    public String setUpBoard(Board currentBoard){
        return formatBoard(numberBoard(currentBoard));
    }

    public StatusMessagePair requestGameType(String option) {
        if (option == "a") {
            return new StatusMessagePair("ok", "");
        } else if (option == "b") {
            return new StatusMessagePair("ok", "");
        } else {
            return new StatusMessagePair("invalid", invalidGameTypeMessage());
        }
    }

    public StatusMessagePair requestTurn(String option) {
        if (option.matches("[1-9]")) {
            return new StatusMessagePair("ok", "");
        } else {
            return new StatusMessagePair("invalid", invalidTurnMessage());
        }
    }

    private Board numberBoard(Board currentBoard) {
        List<String> cells = new ArrayList<String>(currentBoard.getCells());
        Board numberedBoard = new Board(cells);
        for (int i = 0; i < numberedBoard.getCells().size(); i ++) {
            if (numberedBoard.getCells().get(i) == "") {
                numberedBoard.getCells().set(i, String.valueOf(i + 1));
            }
        } return numberedBoard;
    }

    private String formatBoard(Board currentBoard) {
        String formattedBoard = "";
        for (int i = 0; i < currentBoard.getCells().size(); i++) {
            if (endOfRow(i)) {
                formattedBoard = formattedBoard.concat(currentBoard.getCells().get(i)).concat("\n");
            } else {
                formattedBoard = formattedBoard.concat(currentBoard.getCells().get(i)).concat(" ");
            }
        } return formattedBoard;
    }

    private boolean endOfRow(int index) {
        return ((index + 1) % 3 == 0);
    }
}