package com.company.pieces;

import com.company.Board;
import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public class Pawn extends Pieces {

    private boolean hasMoved = false;

    public Pawn(String color, int ligne, int colonne) {
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

        int id = this.color == ColorPawn.White ? 1 : -1;

        //if(board.getBoard()[this.getLigne() + id][this.getColonne()])
        if(board.isOnBoard(this.getLigne() +id, this.getColonne())) {
            if(board.getBoard()[this.getLigne() +id][this.getColonne()].isEmpty()) {
                tmp.add(new BoardCase(this.getLigne() + id, this.getColonne()));
                if(!this.hasMoved) {
                    if(board.isOnBoard(this.getLigne() +id + id, this.getColonne())) { // < useless security
                        if(board.getBoard()[this.getLigne() +id +id][this.getColonne()].isEmpty()) {
                            tmp.add(new BoardCase(this.getLigne() +id + id, this.getColonne()));
                        }
                    }
                }
            }
        }



        if(this.color == ColorPawn.White) {
            if(board.isOnBoard(this.getLigne()+1, this.getColonne()-1)) if(!board.getBoard()[this.getLigne()+1][this.getColonne()-1].isEmpty()) if(board.getBoard()[this.getLigne()+1][this.getColonne()-1].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne()+1, this.getColonne()-1));
            if(board.isOnBoard(this.getLigne()+1, this.getColonne()+1)) if(!board.getBoard()[this.getLigne()+1][this.getColonne()+1].isEmpty()) if(board.getBoard()[this.getLigne()+1][this.getColonne()+1].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne()+1, this.getColonne()+1));
        } else {
            if(board.isOnBoard(this.getLigne()-1, this.getColonne()-1)) if(!board.getBoard()[this.getLigne()-1][this.getColonne()-1].isEmpty()) if(board.getBoard()[this.getLigne()-1][this.getColonne()-1].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne()-1, this.getColonne()-1));
            if(board.isOnBoard(this.getLigne()-1, this.getColonne()+1)) if(!board.getBoard()[this.getLigne()-1][this.getColonne()+1].isEmpty()) if(board.getBoard()[this.getLigne()-1][this.getColonne()+1].getPieces().getColor() != this.getColor()) tmp.add(new BoardCase(this.getLigne()-1, this.getColonne()+1));
        }


        return tmp;
    }


}
