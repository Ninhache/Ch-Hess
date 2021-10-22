package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        Scanner sc = new Scanner(System.in);

        b.initiateBoard("rnbqkbnr/pppppppp/--------/--------/----r---/--------/PPPPPPPP/RNBQKBNR");
        //b.initiateBoard("--------/--------/----p---/--------/---qq---/--------/--------/--------");

        b.setSelected("E4");

        System.out.println(b);

    }
}
