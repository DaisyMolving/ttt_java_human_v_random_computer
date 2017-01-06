import java.util.List;

public interface Player {
    public Board makeMove(Board currentBoard);

    public String getName();
    public String getMarker();
}
