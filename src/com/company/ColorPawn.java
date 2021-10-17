package com.company;

public enum ColorPawn {

    White("Blanc"), Black("Noir");

    private String color;

    ColorPawn(String color) {
        this.color = color;
    }

    public ColorPawn getColor() {
        ColorPawn res = null;
        switch (this.color) {
            case "Blanc":
                res = ColorPawn.White;
                break;
            case "Noir":
                res = ColorPawn.Black;
                break;
        }
        return res;
    }
}
