package com.company;

import com.company.pieces.*;

public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public static final String ANSI_CYAN = "\u001b[36;1m";
    private final String ANSI_FRONT_BLACK =  "\u001b[30m";
    private final String ANSI_FRONT_WHITE =  "\u001b[37m";



    private BoardCase[][] board;
    private BoardCase selected;

    public Board() {

        board = new BoardCase[8][8];
        this.selected = null;

    }

    public BoardCase getSelected() {
        return selected;
    }

    public BoardCase setSelected(String selected) {
        selected = selected.toUpperCase();
        int colonne = (selected.charAt(0) - 'A') % this.board.length;
        int ligne = Integer.parseInt(selected.charAt(1) + "");

        if(!isOnBoard(selected)) {
            this.selected = null;
            return this.selected;
        } else if(this.board[colonne][ligne].getPieces() != null) {
            this.selected = this.board[colonne][ligne];
            this.selected.setPieces(this.board[colonne][ligne].getPieces());
        } else {
            this.selected = null;
            return this.selected;
        }
        return this.selected;
    }

    public boolean isOnBoard(String selected) {
        char lettre = selected.charAt(0);
        char chiffre = selected.charAt(1);
        System.out.println(((int)lettre - 'A') + " <-> " + ((int) chiffre - '0'));
        return isOnBoard((int)lettre - 'A', (int) chiffre - '0');
    }

    public void setPieces(char letter, int number, Pieces p ) {

        if( ((int)(letter - 65) < 0 || (int)(letter - 65) > 8) || (number < 0 || number > 8)) return;

        this.board[letter - 65][number].setPieces(p);

    }

    public BoardCase[][] getBoard() {
        return board;
    }

    public void setPieces(int number, Pieces p ) {

        int letter = number%8;

    }

    public boolean isOnBoard(int ligne, int colonne) {
        if(ligne < 0 || colonne < 0) return false;
        return this.board.length > ligne && this.board[1].length > colonne;
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

            switch (Character.toLowerCase(piece)) {
                case 'p':
                    this.board[ligne][colonne].setPieces(new Pawn(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                case 'r':
                    this.board[ligne][colonne].setPieces(new Rook(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                case 'n':
                    this.board[ligne][colonne].setPieces(new Night(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                case 'b':
                    this.board[ligne][colonne].setPieces(new Bishop(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                case 'q':
                    this.board[ligne][colonne].setPieces(new Queen(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                case 'k':
                    this.board[ligne][colonne].setPieces(new King(isWhite ? "Blanc" : "Noir", ligne, colonne));
                    break;
                default:
                    break;
            }
        }
    }

    public Pieces getPieces(String s) {

        int c1 = Character.toUpperCase(s.charAt(0)) - 65;
        int c2 = Integer.parseInt(Character.toUpperCase(s.charAt(1)) + "");

        if( ((int)(c1 - 65) < 0 || (int)(c1 - 65) > 8) || (c2 < 0 || c2 > 8)) return null;

        return board[c1][c2].getPieces();
    }

    @Override
    public String toString() {

        String res = "   0  1  2  3  4  5  6  7\n";

        //System.out.println(this.selected.getPieces().getAccessibleCases(this));

        for(int i = 0 ; i < board[0].length ; i++ ) {
            res += (char)('A' + i)+ " " ;
            for( int j = 0 ; j < board[1].length ; j++ ) {
                String piece = board[i][j].getPieces() == null ? "   " : board[i][j].getPieces().toString();
                if(this.selected != null) {
                    //System.out.println(board[i][j].getPieces() + " " + board[i][j] + " IS IN ACCESIBLE " + this.selected.getPieces().getAccessibleCases(this).contains(board[i][j]));
                    //System.out.println(this.selected.getPieces().getAccessibleCases(this).contains(new BoardCase(6,4)));
                    if(this.selected == board[i][j]) {
                        String selectedChar = selected.getPieces().getClass().getSimpleName().charAt(0) + "";
                        selectedChar = this.selected.getPieces().getColor() == ColorPawn.White ? selectedChar.toLowerCase() : selectedChar.toUpperCase();
                        String tmpAnsi = getBoard()[i][j].getPieces().getColor() == ColorPawn.Black ? ANSI_FRONT_BLACK : "";
                        res += ANSI_GREEN_BACKGROUND + tmpAnsi + ( " " + selectedChar + " ") + ANSI_RESET;
                    } else if (this.selected.getPieces().getAccessibleCases(this).contains(board[i][j])){
                        if(getBoard()[i][j].getPieces() != null) {
                            Pieces p = getBoard()[i][j].getPieces();
                            String attackedChar = p.getClass().getSimpleName().charAt(0) + "";
                            attackedChar = this.selected.getPieces().getColor() == ColorPawn.Black ? attackedChar.toLowerCase() : attackedChar.toUpperCase();
                            String tmpAnsi = p.getColor() == ColorPawn.Black ? ANSI_FRONT_BLACK : "";
                            res += ANSI_RED_BACKGROUND + tmpAnsi + " " + attackedChar + " " + ANSI_RESET;
                        } else {
                            res += ANSI_RED_BACKGROUND + ANSI_CYAN + " . " + ANSI_RESET;
                        }

                    } else {
                        res += piece ;
                    }
                } else {
                    if(this.board[i][j].getPieces() != null) {
                        res += piece ;
                    } else {
                        res += "   ";
                    }
                }
            }
            res += "\n";
        }

        return res;
    }
}
