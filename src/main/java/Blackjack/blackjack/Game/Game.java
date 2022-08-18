package Blackjack.blackjack.Game;

import Blackjack.blackjack.Deck.Deck;
import Blackjack.blackjack.Person.Dealer.Dealer;
import Blackjack.blackjack.Person.Person;
import Blackjack.blackjack.Person.player.Player;

public class Game {
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }



    private int id;
    private Player player;
    private Dealer dealer;

    public void setVinner(String vinner) {
        this.vinner = vinner;
    }

    public String getVinner() {
        return vinner;
    }

    private String vinner;

     private Deck deck;

    public Game() {
        setPlayer(new Player());
        setDealer(new Dealer());
        setDeck(new Deck());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Game{" +
                "player=" + player +
                ", dealer=" + dealer +
                ", vinner='" + vinner + '\'' +
                ", deck=" + deck +
                '}';
    }
}