package Blackjack.blackjack.domain;

import Blackjack.blackjack.domain.Person.Dealer.Dealer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {


	@Test
	@DisplayName("Dealer can be created successfully!")
	void createDealerWithDefaultNameAndEmptyHand() {
		Dealer dealer = new Dealer();
		Assertions.assertEquals("Dealer", dealer.getName());
		Assertions.assertEquals(0, dealer.getHand().getHandCards().size());
	}

	@Test
	@DisplayName("Dealers name can be changed successfully!")
	void DealerNameCanBeChanged() {
		Dealer dealer = new Dealer();
		dealer.setName("NAME");
		Assertions.assertEquals("NAME", dealer.getName());
	}

	/*
	@Test
	@DisplayName("Dealer can hit the deck successfully!")
	void DealerCanHitTheDeck() {

		Deck deck = new Deck();
		Dealer dealer = new Dealer();
		personService.hit(deck, dealer);
		Assertions.assertEquals(1, dealer.getHand().getHandCards().size());
	}


	 */

}
