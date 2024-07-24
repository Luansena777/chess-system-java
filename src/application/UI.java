package application;

import Chess.ChessPiece;

public class UI {

    /**
     * Imprime o tabuleiro de xadrez no console.
     *
     * @param pieces uma matriz 2D representando as peças no tabuleiro de xadrez.
     */

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {// Loop para percorrer cada linha do tabuleiro
            // Imprime o número da linha (8 a 1)
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) { // Loop para percorrer cada coluna do tabuleiro
                // Chama o método para imprimir a peça na posição atual
                printPiece(pieces[i][j]);
            }
            System.out.println(); // Pula para a próxima linha após imprimir todas as peças na linha atual
        }
        System.out.println("  a b c d e f g h"); // Imprime os identificadores das colunas
    }


    public static void printPiece(ChessPiece piece) { //Imprime uma peça de xadrez no console.
        if (piece == null) { // Verifica se a posição atual está vazia e Imprime um traço.
            System.out.print("-");
        } else { // Imprime a representação da peça
            System.out.print(piece);
        }
        System.out.print(" ");// Imprime um espaço após a peça ou traço
    }
}
