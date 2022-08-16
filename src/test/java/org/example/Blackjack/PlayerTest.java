package org.example.Blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Player can be created successfully!")
    void createPlayerWithDefaultNameAndEmptyHand(){
        Player player = new Player();
        Assertions.assertEquals("Player", player.getName());
        Assertions.assertEquals(0 , player.getHand().getQuantity());
    }

    @Test
    @DisplayName("Player name can be changed successfully!")
    void PlayerNameCanBeChanged(){
        Player player = new Player();
        player.setName("NAME");
        Assertions.assertEquals("NAME", player.getName());
    }

    @Test
    @DisplayName("Player can hit the deck successfully!")
    void PlayerCanHitTheDeck(){
        Deck deck = new Deck();
        Player player = new Player();
        player.hit(deck);
        Assertions.assertEquals(1 , player.getHand().getQuantity());
    }





}