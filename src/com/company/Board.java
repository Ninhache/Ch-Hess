package com.company;

import com.company.pieces.*;

public class Board {

    private BoardCase[][] board;
    private BoardCase selected;

    public Board() {

        board = new BoardCase[8][8];
        this.selected = null;

    }

    public BoardCase setSelected(String selected) {

        if(!isOnBoard(selected)) {
            this.selected = null;
            return this.selected;
        }

        selected = selected.toUpperCase();
        int colonne = (selected.charAt(0) - 'A') % this.board.length;
        int ligne = Integer.parseInt(selected.charAt(1) + "");

        this.selected = this.board[colonne][ligne];
        return this.selected;
    }

    public boolean isOnBoard(String selected) {
        System.out.println(selected);
        return true;
    }

    public void setPieces(char letter, int number, Pieces p ) {

        if( ((int)(letter - 65) < 0 || (int)(letter - 65) > 8) || (number < 0 || number > 8)) return;

        this.board[letter - 65][number].setPieces(p);

    }

    public void setPieces(int number, Pieces p ) {

        int letter = number%8;

    }

    // https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation
    // rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
    public void initiateBoard(String fen) {
        fen = fen.replaceAll("/", "");

        for(int idx = 0 ; idx < fen.length() ; idx ++) {
            int colonne = idx % this.board.length;
            int ligne = idx / this.board.length;

            char piece = fen.charAt(idx);

            boolean isWhite = Character.isLowerCase(piece);

            this.board[ligne][colonne] = new BoardCase(ligne, colonne);
            System.out.println(this.board[ligne][colonne]);
            switch (Character.toLowerCase(piece)) {
                case 'p':
                    this.board[ligne][colonne].setPieces(new Pawn(isWhite ? "Blanc" : "Noir"));
                    break;
                case 'r':
                    this.board[ligne][colonne].setPieces(new Rook(isWhite ? "Blanc" : "Noir"));
                    break;
                case 'n':
                    this.board[ligne][colonne].setPieces(new Knight(isWhite ? "Blanc" : "Noir"));
                    break;
                case 'b':
                    this.board[ligne][colonne].setPieces(new Bishop(isWhite ? "Blanc" : "Noir"));
                    break;
                case 'q':
                    this.board[ligne][colonne].setPieces(new Queen(isWhite ? "Blanc" : "Noir"));
                    break;
                case 'k':
                    this.board[ligne][colonne].setPieces(new King(isWhite ? "Blanc" : "Noir"));
                    break;
                default:
                    break;
            }
        }
    }

    public Pieces getPieces(String s) {
        //if(toString().length() != 2) return null;

        int c1 = Character.toUpperCase(s.charAt(0)) - 65;
        int c2 = Integer.parseInt(Character.toUpperCase(s.charAt(1)) + "");

        if( ((int)(c1 - 65) < 0 || (int)(c1 - 65) > 8) || (c2 < 0 || c2 > 8)) return null;

        return board[c1][c2].getPieces();
    }

    @Override
    public String toString() {

        String res = "   0  1  2  3  4  5  6  7\n";

        for(int i = 0 ; i < board[0].length ; i++ ) {
            res += (char)('A' + i)+ " " ;
            for( int j = 0 ; j < board[1].length ; j++ ) {
                System.out.println(">>"+this.selected);
                if(this.selected != null) {
                    if(this.selected.getPieces().getAccessibleCases().contains(board[i][j])){
                        res += "[□]";
                    } else if(this.selected == board[i][j]) {
                        res += "{" + board[i][j] + "}";
                    } else {
                        res += "[" + board[i][j] + "]";
                    }
                } else {
                    res += "[ ]";
                }
            }
            res += "\n";
        }

        return res;
    }
}
