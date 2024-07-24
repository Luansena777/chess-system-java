package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() { // Método responsável por obter uma matriz de peças de xadrez da partida.
        // Cria uma matriz de peças de xadrez com as linhas e colunas do tabuleiro
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {// Percorre todas as linhas do tabuleiro
            for (int j = 0; j < board.getColumns(); j++) {// Percorre todas as colunas da linha atual do tabuleiro
                // Obtém a peça na posição (i, j) do tabuleiro e a armazena na matriz
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        // Retorna a matriz de peças de xadrez
        return mat;
    }

    private void initialSetup() {//Responsavel por iniciar a partida de xadrez
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }

}

