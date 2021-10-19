package com.company.pieces;

import com.company.BoardCase;
import com.company.ColorPawn;

import java.util.ArrayList;

public class King extends Pieces {

    private boolean hasMoved = false;

    public King(String color) {
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
        return new ArrayList<>();
    }

    @Override
    public String toString() {

        char res = name().charAt(0);

        return this.getColor() == ColorPawn.White ? Character.toLowerCase(res) + "" : Character.toUpperCase(res) + "" ;
    }
}
