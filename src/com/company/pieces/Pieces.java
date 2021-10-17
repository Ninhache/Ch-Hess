package com.company.pieces;

import com.company.ColorPawn;

public abstract class Pieces {

    protected ColorPawn color;

    public abstract String name();

    public abstract ColorPawn getColor();

    public abstract int[] accessibleCases();

}
