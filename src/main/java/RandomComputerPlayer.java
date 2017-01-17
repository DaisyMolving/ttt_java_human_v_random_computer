import java.util.List;
import java.util.Random;

public class RandomComputerPlayer implements Player {

    private String marker;
    private String name;
    private Display display = new CliDisplay();
    private Messenger messenger = new Messenger();

    public RandomComputerPlayer(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getMarker(){
        return marker;
    }

    public String getName(){
        return name;
    }

    public Board makeMove(Board currentBoard) {
        display.sendToTheDisplay(messenger.askPlayerForTurnInput(getName(), getMarker()));
        int cellPosition = getCellPosition(0, 8);
        return currentBoard.markCell(cellPosition, getMarker());
    }

    public Integer getCellPosition(int min, int max) {
        return generateWithinRange(min, max);
    }

    private int generateWithinRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
