package org.example.Blackjack;

public class Dealer extends Person{
    public Dealer() {
        super.setNavn("Dealer");
    }
    void visForsteHand(){
        System.out.println("Dealerens første kort er: ");
        System.out.println(super.getHand().getCard(0));
    }
}
