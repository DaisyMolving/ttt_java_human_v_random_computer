import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board newBoard = new Board(Arrays.asList("", "", "", "", "", "", "", "", ""));
        Game newGame = new Game(newBoard, new CliDisplay(), new Messenger());
        newGame.playNew();
    }
}
