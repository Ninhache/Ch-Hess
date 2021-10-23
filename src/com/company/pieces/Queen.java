package com.company.pieces;

import com.company.Board;
import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public class Queen extends Pieces {

    public Queen(String color, int ligne, int colonne) {
        this.setLigne(ligne);
        this.setColonne(colonne);
        if(color.toLowerCase().equals("blanc")) {
            this.color = ColorPawn.White;
        } else if (color.toLowerCase().equals("noir")) {
            this.color = ColorPawn.Black;
        }
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public ColorPawn getColor() {
        return this.color;
    }
    @Override
    public ArrayList<BoardCase> getAccessibleCases(Board board) {
        ArrayList<BoardCase> tmp = new ArrayList<>();

        //bottom right
        for( int i = 1 ; board.isOnBoard(this.getLigne() + i, this.getColonne() + i); i++ ) {
            if(board.getBoard()[this.getLigne() + i][this.getColonne() + i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() + i, this.getColonne() + i));
            } else {
                if(board.getBoard()[this.getLigne() + i][this.getColonne() + i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() + i, this.getColonne() + i));
                break;
            }
        }

        //top right
        for( int i = 1 ; board.isOnBoard(this.getLigne() - i, this.getColonne() + i); i++ ) {
            if(board.getBoard()[this.getLigne() + i][this.getColonne() + i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() - i, this.getColonne() + i));
            } else {
                if(board.getBoard()[this.getLigne() - i][this.getColonne() + i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() - i, this.getColonne() + i));
                break;
            }
        }

        //top left
        for( int i = 1 ; board.isOnBoard(this.getLigne() - i, this.getColonne() - i); i++ ) {
            if(board.getBoard()[this.getLigne() - i][this.getColonne() - i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() - i, this.getColonne() - i));
            } else {
                if(board.getBoard()[this.getLigne() - i][this.getColonne() - i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() - i, this.getColonne() - i));
                break;
            }
        }

        //bottom left
        for( int i = 1 ; board.isOnBoard(this.getLigne() + i, this.getColonne() - i); i++ ) {
            if(board.getBoard()[this.getLigne() + i][this.getColonne() - i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() + i, this.getColonne() - i));
            } else {
                if(board.getBoard()[this.getLigne() + i][this.getColonne() - i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() + i, this.getColonne() - i));
                break;
            }
        }


        // RIGHT
        for( int i = 1 ; board.isOnBoard(this.getLigne(), this.getColonne() + i); i++ ) {
            if(board.getBoard()[this.getLigne()][this.getColonne() + i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne(), this.getColonne() + i));
            } else {
                if(board.getBoard()[this.getLigne()][this.getColonne() + i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne(), this.getColonne() + i));
                break;
            }
        }

        // LEFT
        for( int i = 1 ; board.isOnBoard(this.getLigne(), this.getColonne() - i); i++ ) {
            if(board.getBoard()[this.getLigne()][this.getColonne() - i].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne(), this.getColonne() - i));
            } else {
                if(board.getBoard()[this.getLigne()][this.getColonne() - i].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne(), this.getColonne() - i));
                break;
            }
        }

        // TOP
        for( int i = 1 ; board.isOnBoard(this.getLigne() - i, this.getColonne()); i++ ) {
            if(board.getBoard()[this.getLigne() - i][this.getColonne()].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() - i, this.getColonne()));
            } else {
                if(board.getBoard()[this.getLigne() - i][this.getColonne()].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() - i, this.getColonne()));
                break;
            }
        }

        // BOTTOM
        for( int i = 1 ; board.isOnBoard(this.getLigne() + i, this.getColonne()); i++ ) {
            if(board.getBoard()[this.getLigne() + i][this.getColonne()].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() + i, this.getColonne()));
            } else {
                if(board.getBoard()[this.getLigne() + i][this.getColonne()].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne() + i, this.getColonne()));
                break;
            }
        }

        return tmp;
    }


}
