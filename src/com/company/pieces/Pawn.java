package com.company.pieces;

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
    public ArrayList<BoardCase> getAccessibleCases() {
        ArrayList<BoardCase> tmp = new ArrayList<>();

        int id = this.color == ColorPawn.White ? 1 : -1;

        tmp.add(new BoardCase(this.getLigne() + id, this.getColonne()));
        if(!this.hasMoved) {
            tmp.add(new BoardCase(this.getLigne() +id + id, this.getColonne()));
        }

        return tmp;
    }

    @Override
    public String toString() {

        char res = name().charAt(0);

        return this.getColor() == ColorPawn.White ? Character.toLowerCase(res) + "" : Character.toUpperCase(res) + "" ;
    }
}
