package org.example.Blackjack;

public class Dealer extends Person {
    public Dealer() {
        // Setter default navn "Dealer"
        super.setName("Dealer");
    }

    //Denne metoden viser det første kortet til dealeren.
    void showFirstHand() {
        System.out.println(this.getName() + " første kort/hand er: ");
        System.out.println(super.getHand().getCard(0) + " Antall kort er: (" + super.getHand().getQuantity() + ")");
    }
}
