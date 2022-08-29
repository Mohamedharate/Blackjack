package Blackjack.blackjack.domain.Person.player;


import Blackjack.blackjack.domain.Person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Player")
public class Player extends Person {
	public Player() {
	}
}
