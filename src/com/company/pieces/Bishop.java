package com.company.pieces;

import com.company.ColorPawn;

public class Bishop extends Pieces {

    public Bishop(String color) {
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
    public int[] accessibleCases() {
        return new int[0];
    }

    @Override
    public String toString() {

        char res = name().charAt(0);

        return this.getColor() == ColorPawn.White ? Character.toLowerCase(res) + "" : Character.toUpperCase(res) + "" ;
    }
}
