package Blackjack.blackjack.domain.Person.Dealer;

import Blackjack.blackjack.domain.Person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dealer")
public class Dealer extends Person {
	public Dealer() {
		super.setName("Dealer");
	}
}