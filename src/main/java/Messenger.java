import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Messenger {

    public String welcomePlayers() {
        return "\nWelcome to TicTacToe!\n\n";
    }

    public String askGameType(List<String> listOfOptions) {
        String initialQuestion = "What sort of game would you like to play?\n";
        String menu = "";
        for (String option : listOfOptions) {
            menu = menu + option + "\n";
        }
        return initialQuestion + menu;
    }

    public String invalidGameTypeMessage(HashMap<String, List<Player>> responseToUserInput) {
        String initialError =  "That is an invalid input. Please input one of these options:\n";
        String options = "";
        for (String key : responseToUserInput.keySet()) {
            options = options + key + "\n";
        } return initialError + options;
    }

    public String askPlayerForTurnInput(String playerName, String marker) {
        return playerName + ", with "+ marker + ", please select a number from 1 - 9 to mark a corresponding cell on the grid\n";
    }

    public String invalidTurnMessage() {
        return "That is an invalid input. Please select a number from 1 - 9 corresponding to an available cell:\n";
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