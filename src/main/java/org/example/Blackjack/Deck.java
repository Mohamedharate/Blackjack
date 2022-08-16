package org.example.Blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {


    // New deck of cards.
    private final ArrayList<Card> deck;

    public Deck() {
        this.deck = generateDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    // Generate a new deck of 52 card when creating object of Deck.
    public ArrayList<Card> generateDeck() {

        ArrayList<Card> deck = new ArrayList<>();

        for (CardSuitsEnum cardSuitsEnum : CardSuitsEnum.values()) {
            // Oppretter 13 kort av hver sort.

            // 9 kort fra 2-9.
            for (int j = 2; j <= 10; j++) {
                deck.add(new Card(cardSuitsEnum, j));
            }

            // 3 bildekort med verdi 10
            for (int k = 1; k <= 3; k++) {
                deck.add(new Card(cardSuitsEnum, 10));
            }

            // 1 Ess hver sort med default verdi 11. Dette endres etter hva som er best for spillerens hånd.
            deck.add(new Card(cardSuitsEnum, 11));
        }
        return deck;
    }


    // Shuffles the deck.
    public void shuffleCards() {
        Collections.shuffle(this.deck);
    }

    // Take the first card from the deck.
    public Card takeCard() {
        return deck.get(0);
    }

    // Remove the first card from the deck.
    public void removeCard() {
        deck.remove(0);
    }
}
