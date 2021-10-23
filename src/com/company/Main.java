package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        Scanner sc = new Scanner(System.in);

        b.initiateBoard("rnbqkbnr/pppppppp/--------/--------/----r---/--------/PPPPPPPP/RNBQKBNR");
        //b.initiateBoard("--------/--------/----p---/--------/---qq---/--------/--------/--------");

        b.setSelected("E4");

        System.out.println(b.getSelected().getPieces().getAccessibleCases(b));
        //System.out.println(b.getBoard()[6][4]);
        System.out.println(b.getBoard()[6][4] + " ==> " + b.getSelected().getPieces().getAccessibleCases(b).contains(b.getBoard()[6][4]));
        //System.out.println(b.getSelected().getPieces().getAccessibleCases(b).contains());

        System.out.println(b);

    }
}
