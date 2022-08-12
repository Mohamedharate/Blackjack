package org.example.Blackjack;

public abstract class Person {
    private String navn;
    private Hand hand;

    public Person() {
        this.navn = "";
        this.hand = new Hand();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public void hit(Dekk dekk){
        this.hand.takeCardFromDeck(dekk);
        System.out.println(this.navn + " tar et kort");
        this.visKort();
    }
    public boolean harBlackjack(){
        return this.getHand().getValue() == 21;
    }

    public void visKort(){
        System.out.println(this.navn + " har følgende kort");
        System.out.println(this.hand + " Sum " + this.hand.getValue());
    }

}
