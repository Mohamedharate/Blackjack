package org.example.Blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void PlayerAndDealerGetsTwoCardEach(){
        Game game = new Game();

        game.playerAndDealerGetsTwoCardsEach();

        Assertions.assertEquals(2, game.getDealer().getHand().getQuantity());
        Assertions.assertEquals(2, game.getPlayer().getHand().getQuantity());
    }


    @Test
    public void isBlackjack(){
        Game game = new Game();

        Card card_11 = new Card(CardSuitsEnum.KLØVER, 11);
        Card card_10 = new Card(CardSuitsEnum.KLØVER, 10);

        game.getDeck().getDeck().set(1, card_11);
        game.getDeck().getDeck().set(3, card_10);

        game.playerAndDealerGetsTwoCardsEach();
        Assertions.assertTrue(game.isBlackjack());

    }

    @Test
    public void dealerMustHitU17(){

        Game game = new Game();

        Card card_10 = new Card(CardSuitsEnum.KLØVER, 10);
        Card card_6 = new Card(CardSuitsEnum.KLØVER, 6);

        game.getDeck().getDeck().set(1, card_10);
        game.getDeck().getDeck().set(3, card_6);

        game.playerAndDealerGetsTwoCardsEach();

        game.dealerMustHitIfUnder17();

        Assertions.assertTrue(game.getDealer().getHand().getSum() > 17);
    }

    @Test
    public void evaluateGamePush(){

        Game game = new Game();

        Card card_2_K = new Card(CardSuitsEnum.KLØVER, 2);
        Card card_2_H = new Card(CardSuitsEnum.HJERTER, 2);
        Card card_2_S = new Card(CardSuitsEnum.SPAR, 2);
        Card card_2_R = new Card(CardSuitsEnum.RUTER, 2);

        game.getDeck().getDeck().set(0, card_2_K);
        game.getDeck().getDeck().set(1, card_2_R);
        game.getDeck().getDeck().set(2, card_2_H);
        game.getDeck().getDeck().set(3, card_2_S);

        game.playerAndDealerGetsTwoCardsEach();

        Assertions.assertEquals("Push", game.evaluateTheGame());
    }

    @Test
    public void evaluateGameDealerWins(){

        Game game = new Game();

        Card card_11 = new Card(CardSuitsEnum.KLØVER, 11);
        Card card_10 = new Card(CardSuitsEnum.KLØVER, 10);
        Card card_9 = new Card(CardSuitsEnum.KLØVER, 9);
        Card card_8 = new Card(CardSuitsEnum.KLØVER, 8);

        game.getDeck().getDeck().set(1, card_11);
        game.getDeck().getDeck().set(3, card_10);
        game.getDeck().getDeck().set(0, card_9);
        game.getDeck().getDeck().set(2, card_8);

        game.playerAndDealerGetsTwoCardsEach();

        Assertions.assertEquals(game.getPlayer().getName() + " taper.", game.evaluateTheGame());
    }

    @Test
    public void evaluateGameDealerLoose(){

        Game game = new Game();

        Card card_11 = new Card(CardSuitsEnum.KLØVER, 11);
        Card card_10 = new Card(CardSuitsEnum.KLØVER, 10);
        Card card_9 = new Card(CardSuitsEnum.KLØVER, 9);
        Card card_8 = new Card(CardSuitsEnum.KLØVER, 8);

        game.getDeck().getDeck().set(0, card_11);
        game.getDeck().getDeck().set(1, card_10);
        game.getDeck().getDeck().set(2, card_9);
        game.getDeck().getDeck().set(3, card_8);

        game.playerAndDealerGetsTwoCardsEach();

        Assertions.assertEquals(game.getPlayer().getName() + " vinner!", game.evaluateTheGame());
    }

    @Test
    public void evaluateDealerBusts(){
        Game game = new Game();


        Card card_10_K = new Card(CardSuitsEnum.KLØVER, 10);
        Card card_10_H = new Card(CardSuitsEnum.HJERTER, 10);


        game.getDeck().getDeck().set(1, card_10_H);
        game.getDeck().getDeck().set(3, card_10_K);


        game.playerAndDealerGetsTwoCardsEach();

        game.getDealer().hit(game.getDeck());
        game.getDealer().hit(game.getDeck());



        Assertions.assertEquals(game.getDealer().getName() + " busts", game.evaluateTheGame());
    }
    /*

     @Test
     public void playerHasOver21(){
         Game game = new Game();

         Card card_11 = new Card(CardSuitsEnum.KLØVER, 1);
         Card card_10 = new Card(CardSuitsEnum.KLØVER, 10);

         game.getDeck().getDeck().set(0, card_11);
         game.getDeck().getDeck().set(2, card_10);

         game.playerAndDealerGetsTwoCardsEach();

         game.playerHasOver21();

         Assertions.assertTrue(game.getPlayer().getHand().getSum() >= 20);
     }

    */


}