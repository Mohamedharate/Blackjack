package Blackjack.blackjack.Person;

import Blackjack.blackjack.Card.Card;
import Blackjack.blackjack.Deck.Deck;
import Blackjack.blackjack.Hand.Hand;

import java.util.List;

public abstract class Person {
    private String name;
    private Hand hand;



    public Person() {
        this.name = "";
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand hit(Deck deck) {
        this.hand.takeCardFromDeck(deck);
        return this.hand;
    }

    public boolean hasBlackjack() {
        return this.getHand().getSum() == 21;
    }

    public void showCards() {
        System.out.println(this.name + " har følgende kort");
        System.out.println(this.hand + " Sum " + this.hand.getSum());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }

}
