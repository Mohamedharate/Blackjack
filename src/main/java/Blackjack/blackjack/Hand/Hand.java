package Blackjack.blackjack.Hand;


import Blackjack.blackjack.Card.Card;
import Blackjack.blackjack.Deck.Deck;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    // Henter summen av kortene.
    public int getSum() {
        int sum = 0;
        int acesCount = 0;

        for (Card card : hand) {
            if (card.getValue() == 11)
                acesCount++;
            sum += card.getValue();
        }

        if (sum > 21 && acesCount > 0) {
            while (acesCount > 0 && sum > 21) {
                acesCount--;
                sum -= 10;
            }
        }
        return sum;
    }


    public Card getCard(int i) {
        return hand.get(i);
    }

    // Kan forbedres ved å sjekke om deck har flere kort igjen.
    public void takeCardFromDeck(@NotNull Deck deck) {
        hand.add(deck.takeCard());
        deck.removeCard();
    }

    public int getQuantity() {
        return hand.size();
    }

    @Override
    public String toString() {
        return hand.toString();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
