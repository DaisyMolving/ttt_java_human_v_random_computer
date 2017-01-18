import java.util.Random;

public class RandomComputerPlayer implements Player {

    private String marker;
    private String name;
    private Display display;
    private Messenger messenger = new Messenger();

    public RandomComputerPlayer(String name, String marker, Display display) {
        this.name = name;
        this.marker = marker;
        this.display = display;
    }

    public String getMarker(){
        return marker;
    }

    public String getName(){
        return name;
    }

    public Board makeMove(Board currentBoard) {
        display.sendToTheDisplay(messenger.askPlayerForTurnInput(getName(), getMarker()));
        int cellPosition = getCellPosition(currentBoard);
        return currentBoard.markCell(cellPosition, getMarker());
    }

    public Integer getCellPosition(Board currentBoard) {
        int cellPosition = generateWithinRange(currentBoard.getCells().size());
        while (!currentBoard.isAvailableCell(cellPosition)) {
            cellPosition = generateWithinRange(currentBoard.getCells().size());
        }
        return cellPosition;
    }

    private int generateWithinRange(int boardSize) {
        int min = 0;
        int max = boardSize - 1;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}