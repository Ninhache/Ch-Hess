package com.company.pieces;

import com.company.Board;
import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public class Night extends Pieces {

    public Night(String color, int ligne, int colonne) {
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

        if(board.isOnBoard(this.getLigne() -2, this.getColonne()+1)) {
            if(board.getBoard()[this.getLigne() -2][this.getColonne() +1].isEmpty() || board.getBoard()[this.getLigne() -2][this.getColonne() +1].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() -2, this.getColonne()+1));
            }
        }

        if(board.isOnBoard(this.getLigne() -2, this.getColonne()-1)) {
            if(board.getBoard()[this.getLigne() -2][this.getColonne() -1].isEmpty() || board.getBoard()[this.getLigne() -2][this.getColonne() -1].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() -2, this.getColonne()-1));
            }
        }

        if(board.isOnBoard(this.getLigne() +2, this.getColonne()-1)) {
            if(board.getBoard()[this.getLigne() +2][this.getColonne() -1].isEmpty() || board.getBoard()[this.getLigne() +2][this.getColonne() -1].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() +2, this.getColonne()-1));
            }
        }

        if(board.isOnBoard(this.getLigne() +2, this.getColonne()+1)) {
            if(board.getBoard()[this.getLigne() +2][this.getColonne() +1].isEmpty() || board.getBoard()[this.getLigne() +2][this.getColonne() +1].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() +2, this.getColonne()+1));
            }
        }



        if(board.isOnBoard(this.getLigne() +1, this.getColonne()+2)) {
            if(board.getBoard()[this.getLigne() +1][this.getColonne() +2].isEmpty() || board.getBoard()[this.getLigne() +1][this.getColonne() +2].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() +1, this.getColonne()+2));
            }
        }

        if(board.isOnBoard(this.getLigne() -1, this.getColonne()+2)) {
            if(board.getBoard()[this.getLigne() -1][this.getColonne() +2].isEmpty() || board.getBoard()[this.getLigne() -1][this.getColonne() +2].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() -1, this.getColonne()+2));
            }
        }


        if(board.isOnBoard(this.getLigne() +1, this.getColonne()-2)) {
            if(board.getBoard()[this.getLigne() +1][this.getColonne() -2].isEmpty() || board.getBoard()[this.getLigne() +1][this.getColonne() -2].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() +1, this.getColonne()-2));
            }
        }

        if(board.isOnBoard(this.getLigne() -1, this.getColonne() -2)) {
            if(board.getBoard()[this.getLigne() -1][this.getColonne() -2].isEmpty() || board.getBoard()[this.getLigne() -1][this.getColonne() -2].getPieces().getColor() != this.color) {
                tmp.add(new BoardCase(this.getLigne() -1, this.getColonne()-2));
            }
        }

        return tmp;
    }


}
