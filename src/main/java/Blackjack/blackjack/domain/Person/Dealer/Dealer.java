package Blackjack.blackjack.domain.Person.Dealer;

import Blackjack.blackjack.domain.Person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dealer")
public class Dealer extends Person {
	public Dealer() {
		// Setter default navn "Dealer"
		super.setName("Dealer");
	}


	//Denne metoden viser det første kortet til dealeren.
	public String showFirstHand() {
		return this.getHand().getCard(0).toString();
        /*

        System.out.println(this.getName() + " første kort/hand er: ");
        System.out.println(super.getHand().getCard(0) + " Antall kort er: (" + super.getHand().getQuantity() + ")");

         */
	}
}