package org.example.Blackjack;

enum Result{
    WIN,
    LOSE,
    PUSH
}
public class Game {
    private final Player player;
    private final Dealer dealer;

    private final Deck deck;

    public Game() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck();
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void startGame() {

        // Shuffle the deck
        deck.shuffleCards();

        // Give dealer and player two cards each
        playerAndDealerGetsTwoCardsEach();

        // Show the dealer's first hand
        dealer.showFirstHand();

        // Show players cards
        player.showCards();

        // Checks if the dealer or the player has blackjack. Push if both have Blackjack
        if (isBlackjack())
            return;

        // The user must make a decision.
        player.choose(deck);

        // If the user gets over 21 after hit, the user loose.
        if (isOver21Player())
            return;

        // Show dealer's cards.
        dealer.showCards();

        // If the dealer's hand is under 17, the dealer must hit.
        dealerMustHitIfUnder17();

        // Check who is the winner.
        System.out.println(evaluateTheGame());
    }


    public void playerAndDealerGetsTwoCardsEach() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Deler ut kort til " + player.getName() + "...");
            player.getHand().takeCardFromDeck(deck);

            System.out.println("Deler ut kort til " + dealer.getName() + "...");
            dealer.getHand().takeCardFromDeck(deck);
        }
    }

    public void dealerMustHitIfUnder17() {
        while (dealer.getHand().getSum() < 17) {
            dealer.hit(deck);
        }
    }

    public boolean isOver21Player() {
        if (player.getHand().getSum() > 21) {
            System.out.println(Result.LOSE + " - " + this.player.getName() + " har over 21 kort.");
            return true;
        }
        return false;
    }

    public String evaluateTheGame() {
        if (dealer.getHand().getSum() > 21) {
            return  Result.WIN + " - " + this.dealer.getName() + " busts";
        } else if (dealer.getHand().getSum() > player.getHand().getSum()) {
            return Result.LOSE + " - " + this.dealer.getName() + " er nærmere 21 enn " + this.player.getName();
        } else if (player.getHand().getSum() > dealer.getHand().getSum()) {
            return Result.WIN + " - " + this.player.getName() + " er nærmere 21 enn " + this.dealer.getName();
        } else {
            return Result.PUSH.toString();
        }
    }

    public boolean isBlackjack() {

        if (dealer.hasBlackjack()) {
            dealer.showCards();
            if (player.hasBlackjack()) {
                player.showCards();
                System.out.println(Result.PUSH);
            } else {
                System.out.println( Result.LOSE + " - " + dealer.getName() + " har Blackjack");
                dealer.showCards();
            }
            return true;
        } else if (player.hasBlackjack()) {
            dealer.showCards();
            System.out.println( Result.WIN + " - " + player.getName() + " har Blackjack");
            return true;
        }
        return false;
    }
}

