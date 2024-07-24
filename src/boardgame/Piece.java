package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board bord) {
        this.board = bord;
    }

    protected Board getBoard() {
        return board;
    }
}
