package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Card;
import Blackjack.blackjack.domain.Deck;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DeckService {
	// Take the first card from the deck.
	public Card takeCard(Deck deck) {
		return deck.getDeckCards().get(0);
	}

	// Remove the first card from the deck.
	public void removeCard(Deck deck) {
		deck.getDeckCards().remove(0);
	}


	// Shuffles the deck.
	public void shuffleCards(Deck deck) {
		Collections.shuffle(deck.getDeckCards());
	}


}
