package org.example.Blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    @DisplayName("Dealer can be created successfully!")
    void createDealerWithDefaultNameAndEmptyHand(){
        Dealer dealer = new Dealer();
        Assertions.assertEquals("Dealer", dealer.getName());
        Assertions.assertEquals(0, dealer.getHand().getQuantity());
    }

    @Test
    @DisplayName("Dealers name can be changed successfully!")
    void DealerNameCanBeChanged(){
        Dealer dealer = new Dealer();
        dealer.setName("NAME");
        Assertions.assertEquals("NAME", dealer.getName());
    }

    @Test
    @DisplayName("Dealer can hit the deck successfully!")
    void DealerCanHitTheDeck(){
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        dealer.hit(deck);
        Assertions.assertEquals(1, dealer.getHand().getQuantity());
    }




}