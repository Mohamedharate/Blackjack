package org.example.Blackjack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;


class CardTest {

    @Test
    @DisplayName("Tests if card can be created successfully!")
    public void shouldCreateCard(){
        Card card = new Card(CardSuitsEnum.KLØVER, 3);
        Assertions.assertEquals(card.getCardSuit().toString(), "KLØVER");
        Assertions.assertEquals(3, card.getValue());
    }

    @Test
    @DisplayName("Tests if card cannot be created with unvalid vlaue")
    public void createCardShouldFail(){
        try {
            new Card(CardSuitsEnum.HJERTER, -12);
            Assertions.fail("Should have thrown an error - (value = -12)");
        }
        catch (IllegalArgumentException e){
            // Everything is ok
        }
        try {
            new Card(CardSuitsEnum.HJERTER, 13);
            Assertions.fail("Should have thrown an error - (value = 13)");
        }
        catch (IllegalArgumentException e){
            // Everything is ok
        }

    }


}