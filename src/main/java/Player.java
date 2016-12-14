import java.util.List;

public interface Player {
    public List<String> makeMove(Board currentBoard);

    public String getName();
    public String getMarker();
}
