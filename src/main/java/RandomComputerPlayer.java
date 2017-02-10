import java.util.List;
import java.util.Random;

public class RandomComputerPlayer implements Player{

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
        display.sendToTheDisplay(messenger.setUpBoard(currentBoard));
        int cellPosition = getCellPosition(currentBoard);
        return currentBoard.markCell(cellPosition, getMarker());
    }


    public Integer getCellPosition(Board currentBoard) {
        int cellPosition = takeRandomAvailableCell(currentBoard);
        return cellPosition;
    }

    private int takeRandomAvailableCell(Board board) {
        Random randomizer = new Random();
        List<String> availableCells = board.giveAvailableCells();
        String cell = availableCells.get(randomizer.nextInt(availableCells.size()));
        return Integer.valueOf(cell) - 1;
    }

}