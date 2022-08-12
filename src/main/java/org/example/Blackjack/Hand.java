package org.example.Blackjack;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Kort> hand;

    public Hand(){
        hand = new ArrayList<Kort>();
    }

    public int getValue(){
        int sum = 0;
        int antallEss = 0;

        for (Kort k : hand) {
            if (k.getVerdi() == 11)
                antallEss++;
            sum += k.getVerdi();
        }

        if (sum > 21 && antallEss > 0){
            while(antallEss > 0 && sum > 21){
                antallEss --;
                sum -= 10;
            }
        }
        return sum;
    }

    public Kort getCard(int i){
        return hand.get(i);
    }
    public void takeCardFromDeck(Dekk dekk){
        hand.add(dekk.takeCard());
    }

    @Override
    public String toString() {
        return hand.toString();

    }
}
