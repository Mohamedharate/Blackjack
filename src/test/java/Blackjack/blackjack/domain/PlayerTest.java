package Blackjack.blackjack.domain;

import Blackjack.blackjack.domain.Person.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {


	@Test
	@DisplayName("Player name can be changed successfully!")
	void PlayerNameCanBeChanged() {
		Player player = new Player();
		player.setName("NAME");
		Assertions.assertEquals("NAME", player.getName());
	}
	/*

	@Test
	@DisplayName("Player can hit the deck successfully!")
	void PlayerCanHitTheDeck() {
		Deck deck = new Deck();
		Player player = new Player();
		player.hit(deck);
		Assertions.assertEquals(1, player.getHand().getHandCards().size());
	}

	 */
}
