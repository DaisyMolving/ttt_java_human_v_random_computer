import java.util.List;
import java.util.Random;

public class RandomComputerPlayer implements Player {

    public RandomComputerPlayer(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    private String marker = "";
    private String name = "";

    public String getMarker(){
        return marker;
    }

    public String getName(){
        return name;
    }

    public List<String> makeMove(Board currentBoard) {
        int cellPosition = getCellPosition(0, 8);
        return currentBoard.markCell(cellPosition, getMarker());
    }

    public Integer getCellPosition(int min, int max) {
        return generateWithinRange(min, max);
    }

    private int generateWithinRange(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
