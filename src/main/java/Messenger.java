import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Messenger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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

    public String askBoardSize(List<String> boardOptions) {
        String initialQuestion = "What should the dimensions of the board be?\n";
        String menu = "";
        for (String option : boardOptions) {
            menu = menu + option + "\n";
        }
        return initialQuestion + menu;
    }

    public String invalidBoardTypeMessage(HashMap<String, Board> responseToUserInput) {
        String initialError =  "That is an invalid input. Please input one of these options:\n";
        String options = "";
        for (String key : responseToUserInput.keySet()) {
            options = options + key + "\n";
        } return initialError + options;
    }

    public String askPlayerForTurnInput(String playerName, String marker, int boardSize) {
        return "\n\n" + playerName + ", with "+ marker + ", please select a number from 1 - " + boardSize + " to mark a corresponding cell on the grid\n";
    }

    public String invalidTurnMessage(int boardSize) {
        return "That is an invalid input. Please select a number from 1 - " + boardSize + " corresponding to an available cell:\n";
    }

    public String winnerMessage(String playerNumber) {
        return "Player " + playerNumber + " wins!";
    }

    public String drawMessage() {
        return "It's a draw!";
    }

    public String setUpBoard(Board currentBoard){
        return formatBoard(colourMarkers(numberBoard(currentBoard)));
    }

    private Board colourMarkers(Board currentBoard) {
        for (int i = 0; i < currentBoard.getCells().size(); i++) {
            if (currentBoard.getCells().get(i) == "x") {
                currentBoard.getCells().set(i, ANSI_RED + "x" + ANSI_RESET);
            } else if (currentBoard.getCells().get(i) == "o") {
                currentBoard.getCells().set(i, ANSI_YELLOW + "o" + ANSI_RESET);
            }
        } return currentBoard;
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
            if (endOfRow(currentBoard, i)) {
                formattedBoard = formattedBoard.concat(currentBoard.getCells().get(i)).concat("\n");
            } else {
                formattedBoard = formattedBoard.concat(currentBoard.getCells().get(i)).concat(" ");
            }
        } return formattedBoard;
    }

    private boolean endOfRow(Board currentBoard, int index) {
        int dimension = (int) Math.sqrt(currentBoard.getCells().size());
        return ((index + 1) % dimension == 0);
    }
}