package com.company.pieces;

import com.company.Board;
import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public class King extends Pieces {

    private boolean hasMoved = false;

    public King(String color, int ligne, int colonne) {
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
        return new ArrayList<>();
    }


}
