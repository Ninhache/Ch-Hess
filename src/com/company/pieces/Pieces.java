package com.company.pieces;

import com.company.Board;
import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public abstract class Pieces {

    private final String ANSI_BG_BLACK = "\u001b[40m";
    private final String ANSI_BG_WHITE = "\u001b[47m";
    private final String ANSI_FRONT_BLACK =  "\u001b[30m";
    private final String ANSI_FRONT_WHITE =  "\u001b[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    private int ligne, colonne;

    protected ColorPawn color;
    protected BoardCase[] accessibleCases;
    protected BoardCase position;



    public abstract String name();

    public abstract ColorPawn getColor();

    public abstract ArrayList<BoardCase> getAccessibleCases(Board board);

    public int getColonne() {
        return this.colonne;
    }

    public int getLigne() {
        return this.ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public String toString() {
        char res = name().charAt(0);
        return this.getColor() == ColorPawn.White ? ANSI_BG_WHITE + ANSI_FRONT_BLACK + " " +  Character.toLowerCase(res) + " " + ANSI_RESET : ANSI_BG_BLACK + ANSI_FRONT_WHITE + " " + Character.toUpperCase(res) + " " + ANSI_RESET ;
    }
}
