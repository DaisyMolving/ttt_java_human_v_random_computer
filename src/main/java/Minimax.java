public class Minimax {

    public int minimaxValue(Board board, String currentPlayerMarker, boolean maximisingPlayer) {
        if (terminal(board)) {
            return score(board, maximisingPlayer);
        } return 1;
    }

    public int score(Board board, boolean maximisingPlayer) {
        if (board.win() && maximisingPlayer) {
            return 1;
        } else if (board.win() && !maximisingPlayer) {
            return -1;
        } return 0;

    }

    private boolean terminal(Board board) {
        return board.win() || board.draw();
    }

}
