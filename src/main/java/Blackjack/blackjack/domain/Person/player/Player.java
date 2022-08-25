package Blackjack.blackjack.domain.Person.player;


import Blackjack.blackjack.domain.Person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Player")
public class Player extends Person {
	public Player() {
	}


    /*
    public void choose(Deck deck) {

        int choice = 0;
        boolean getNum = true;

        while (getNum) {
            try {
                System.out.println("Velg en av følgende: ");
                for (int i = 1; i <= Choices.values().length;i++){
                    System.out.println("Velg " + i + " for " +Choices.values()[i-1]);
                }
                choice = input.nextInt();
                getNum = false;

            } catch (Exception e) {
                System.out.println("Ugyldig valg.");
                input.next();
            }
        }
        if (choice == 1) {
            this.hit(deck);

            if (this.getHand().getSum() <= 20)
                this.choose(deck);

        } else {
            System.out.println(this.getName() + " velger stand.");
        }
    }
*/
}
