package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Card;
import Blackjack.blackjack.domain.Deck;
import Blackjack.blackjack.domain.Hand;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandService {

	private final DeckService deckService;

	@Autowired
	public HandService(DeckService deckService) {
		this.deckService = deckService;
	}

	public Card getCard(Hand hand, int i) {
		return hand.getHandCards().get(i);
	}

	// Kan forbedres ved å sjekke om deck har flere kort igjen.
	public void takeCardFromDeck(@NotNull Deck deck, Hand hand) {
		Card card = deckService.takeCard(deck);
		hand.getHandCards().add(card);
		hand.setSum(hand.getSum());
		deckService.removeCard(deck);
	}


}
