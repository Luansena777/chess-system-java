package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Erro intanciando ChessPosition. Valores validos somente de a1 até h8");
        }
        this.column = column;
        this.row = row;
    }

    protected Position toPosition() { // Retorna uma nova posição no tabuleiro de xadrez.
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) { //Retorna a posicao inversa do toPosition. Petorna a posicao no sistema de xadrez e nao de matriz.
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
