package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;

    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    public void validateSourcePosition(Position position) { //Validando a posicao de origem.
        if (!board.thereIsAPiece(position)) {
            throw new BoardException("Não existe peça na posição de origem.");
        }
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new BoardException("Não existe movimentos possiveis para a peça escolhida.");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) { //Coloca uma peça na posicao de xadrez
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() { //Responsavel por iniciar a partida de xadrez
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

}

