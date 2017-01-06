public class Minimax {

    public int minimaxValue(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        return score(board, maximisingPlayer);
    }

    public int score(Board board, boolean maximisingPlayer) {
        if (board.win() && maximisingPlayer) {
            return 1;
        } else if (board.win() && !maximisingPlayer) {
            return -1;
        } return 0;

    }

}
