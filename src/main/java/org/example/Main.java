package org.example;

import org.example.Blackjack.Game;

public class Main {
    public static void main(String[] args) {

        System.out.println(" \n ------------------ Velkommen til Mos Casino ------------------- \n ");

        System.out.println("Spillet starter......");

        Game blackjack = new Game();
        blackjack.startGame();

    }
}