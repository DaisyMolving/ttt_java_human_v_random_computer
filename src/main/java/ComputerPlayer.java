import java.util.Random;
public class ComputerPlayer implements Player{
    private String marker = "";
    private String name = "Computer";

    public String getMarker(){
        return marker;
    }

    public String getName(){
        return name;
    }

    public String move() {
        return String.valueOf(randInt(0, 8));
    }

    private int randInt(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
