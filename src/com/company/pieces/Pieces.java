package com.company.pieces;

import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public abstract class Pieces {

    private int ligne, colonne;

    protected ColorPawn color;
    protected BoardCase[] accessibleCases;
    protected BoardCase position;

    public abstract String name();

    public abstract ColorPawn getColor();

    public abstract ArrayList<BoardCase> getAccessibleCases();

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }
}
