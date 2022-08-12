package org.example.Blackjack;

public class Spill {
    private final Spiller spiller;
    private final Dealer dealer;
    private final Dekk dekk;

    public Spill() {

        this.spiller = new Spiller();
        this.dealer = new Dealer();
        this.dekk = new Dekk();

        dekk.stokkKortStokk();
    }

    public void startSpillet(){

        dekk.genererKortstokk();
        dekk.stokkKortStokk();
        for (int i = 0; i < 2; i++){

            System.out.println("Deler ut kort til spiller...");
            spiller.getHand().takeCardFromDeck(dekk);

            System.out.println("Deler ut kort til dealer...");
            dealer.getHand().takeCardFromDeck(dekk);
        }

        dealer.visForsteHand();
        spiller.visKort();

        if (dealer.harBlackjack()){
            dealer.visKort();

            if (spiller.harBlackjack()){
                spiller.visKort();
                System.out.println("Push");
            }
            else {
                System.out.println("Dealer vinner");
                dealer.visKort();
            }
        }
        if (spiller.harBlackjack()){
            System.out.println("spiller vinner");
        }
        spiller.velg(dekk);

        if(spiller.getHand().getValue() > 21){
            System.out.println("Spiller har over 21. (Tap)");
            return;
        }

        dealer.visKort();

        while(dealer.getHand().getValue() < 17){
            dealer.hit(dekk);
        }

        if(dealer.getHand().getValue()>21){
            System.out.println("Dealer busts");
            return;
        }
        else if(dealer.getHand().getValue() > spiller.getHand().getValue()){
            System.out.println("Spiller taper.");
            return;
        }
        else if(spiller.getHand().getValue() > dealer.getHand().getValue()){
            System.out.println("Spiller vinner");
            return;
        }
        else{
            System.out.println("Push.");
        }
    }
}

