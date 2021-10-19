package com.company;

import com.company.pieces.Pieces;

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
        return (this.pieces == null ? " " : this.pieces.toString());
    }
}
