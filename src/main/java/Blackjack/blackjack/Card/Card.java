package Blackjack.blackjack.Card;


public class Card {

    private final CardSuitsEnum cardSuit;
    private int value;

    public Card(CardSuitsEnum cardSuit, int value) {
        this.cardSuit = cardSuit;
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 1 || value > 11) {
            throw new IllegalArgumentException("The cards value must be between 1 and 11.");
        }
        this.value = value;
    }


    @Override
    public String toString() {
        return
                "[" + cardSuit + "(" + value + ")]";
    }

    public CardSuitsEnum getCardSuit() {
        return cardSuit;
    }


}

