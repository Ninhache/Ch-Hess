package com.company;

import com.company.pieces.Pieces;

import java.util.Objects;

public class BoardCase {

    private final int ligne, colonne;

    private Pieces pieces;

    public BoardCase(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public void setPieces(Pieces pieces) {
        this.pieces = pieces;
    }

    public Pieces getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "["+ this.ligne + ";"+ this.colonne +"]";
    }

    public boolean isEmpty() {
        return this.pieces == null;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        BoardCase boardCase = (BoardCase) o;
        if(this.colonne != boardCase.colonne) return false;
        if(this.ligne != boardCase.ligne) return false;
        return true;
    }

}
