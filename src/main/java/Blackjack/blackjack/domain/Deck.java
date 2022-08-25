package Blackjack.blackjack.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Deck {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	// New deck of cards.


	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "deck_card",
			joinColumns = @JoinColumn(name = "deck_id", referencedColumnName = "id"))
	private List<Card> deckCards = new ArrayList<>();


	public void setDeckCards(List<Card> deckCards) {
		this.deckCards = deckCards;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Deck() {
		this.deckCards = generateDeck();
	}

	public List<Card> getDeckCards() {

		return deckCards;
	}

	// Generate a new deck of 52 card when creating object of Deck.
	public ArrayList<Card> generateDeck() {

		ArrayList<Card> deck = new ArrayList<>();

		for (CardSuitsEnum cardSuitsEnum : CardSuitsEnum.values()) {
			// Oppretter 13 kort av hver sort.

			// 9 kort fra 2-9.
			for (int j = 2; j <= 10; j++) {
				deck.add(new Card(cardSuitsEnum, j));
			}

			// 3 bildekort med verdi 10
			for (int k = 1; k <= 3; k++) {
				deck.add(new Card(cardSuitsEnum, 10));
			}

			// 1 Ess hver sort med default verdi 11. Dette endres etter hva som er best for spillerens hånd.
			deck.add(new Card(cardSuitsEnum, 11));
		}
		return deck;
	}


	// Shuffles the deck.
	public void shuffleCards() {
		Collections.shuffle(this.deckCards);
	}

	// Take the first card from the deck.
	public Card takeCard() {
		return deckCards.get(0);
	}

	// Remove the first card from the deck.
	public void removeCard() {
		deckCards.remove(0);
	}

	@Override
	public String toString() {
		return "Deck{" +
				"id=" + id +
				", deckCards=" + deckCards +
				'}';
	}
}

