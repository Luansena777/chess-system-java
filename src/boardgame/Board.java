package boardgame;

import java.io.StringWriter;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro ao criar o tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) { // Retorna a peça na posição especificada por linha e coluna
        if (!positionExits(row, column)) {
            throw new BoardException("Posição não encontrada no tabuleiro.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Posição não encontrada no tabuleiro.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) { // Responsavel por colocar uma peça numa dada posiçao
        if (thereIsAPiece(position)) {
            throw new BoardException("Já existe uma peça nesta posição. " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExits(position)) {
            throw new BoardException("Posição não encontrada no tabuleiro.");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExits(int row, int column) {
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public boolean positionExits(Position position) { // Verifica se existe a posição no tabuleiro
        return positionExits(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) { //Verifica se há uma peça na posicao fornecida
        if (!positionExits(position)) {
            throw new BoardException("Posição não encontrada no tabuleiro.");
        }
        return piece(position) != null;
    }


}
