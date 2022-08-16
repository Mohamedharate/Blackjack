package org.example.Blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @DisplayName("Deck can be created correctly!")
    public void deckCanBeCreated(){
        Deck deck = new Deck();
        assertEquals(52, deck.generateDeck().size());
    }

    @Test
    public void isGeneratedCorrectly(){
        Deck deck = new Deck();
        assertEquals(13, deck.getDeck().stream().filter(card -> card.getCardSuit().toString().equals("KLØVER")).count());
        assertEquals(13, deck.getDeck().stream().filter(card -> card.getCardSuit().toString().equals("HJERTER")).count());
        assertEquals(13, deck.getDeck().stream().filter(card -> card.getCardSuit().toString().equals("SPAR")).count());
        assertEquals(13, deck.getDeck().stream().filter(card -> card.getCardSuit().toString().equals("RUTER")).count());
    }

    @Test
    public void testTakeCard(){
        Deck deck = new Deck();
        Card card = deck.getDeck().get(0);
        Assertions.assertEquals(deck.takeCard(), card);
    }


    @Test
    public void testRemoveCard(){
        Deck deck = new Deck();
        Card card_1 = deck.getDeck().get(1);
        deck.removeCard();
        Assertions.assertEquals(card_1, deck.takeCard());
    }

}