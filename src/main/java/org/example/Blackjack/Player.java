package org.example.Blackjack;

import java.util.Scanner;

// Kan utvides til å ha alle mulige valg i ekte balckjack.
enum Choices{
    HIT,
    STAND
}

public class Player extends Person {
    Scanner input = new Scanner(System.in);

    public Player() {
        super.setName("Player");
    }

    public void choose(Deck deck) {

        int choice = 0;
        boolean getNum = true;

        while (getNum) {
            try {
                System.out.println("Velg en av følgende: ");
                for (int i = 1; i <= Choices.values().length;i++){
                    System.out.println("Velg " + i + " for " +Choices.values()[i-1]);
                }
                choice = input.nextInt();
                getNum = false;

            } catch (Exception e) {
                System.out.println("Ugyldig valg.");
                input.next();
            }
        }
        if (choice == 1) {
            this.hit(deck);

            if (this.getHand().getSum() <= 20)
                this.choose(deck);

        } else {
            System.out.println(this.getName() + " velger stand.");
        }
    }
}
