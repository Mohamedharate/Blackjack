package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Deck;
import Blackjack.blackjack.domain.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final HandService handService;

	@Autowired
	public PersonService(HandService handService) {
		this.handService = handService;
	}

	public boolean hasBlackjack(Person person) {
		return person.getHand().getSum() == 21;
	}

	public void hit(Deck deck, Person person) {
		handService.takeCardFromDeck(deck, person.getHand());
	}

}
