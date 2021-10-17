package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        Scanner sc = new Scanner(System.in);

        b.initiateBoard("rnbqkbnr/pppppppp/--------/--------/--------/--------/PPPPPPPP/RNBQKBNR");


        b.setSelected("C2");


        System.out.println(b);

    }
}
