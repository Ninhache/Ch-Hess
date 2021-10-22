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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCase boardCase = (BoardCase) o;
        return ligne == boardCase.ligne && colonne == boardCase.colonne && Objects.equals(pieces, boardCase.pieces);
    }

}
