package org.example;

import org.example.Blackjack.Spill;

public class Main {
    public static void main(String[] args) {

        System.out.println(" \n ------------------ Velkommen til Mos Casino ------------------- \n ");

        System.out.println("Spillet starter......");

        Spill blackjack = new Spill();
        blackjack.startSpillet();

    }
}