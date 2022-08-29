package Blackjack.blackjack.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deck_sequence")
	@SequenceGenerator(name = "deck_sequence", sequenceName = "deck_sequence", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "deck_card",
			joinColumns = @JoinColumn(name = "deck_id", referencedColumnName = "id"))
	private List<Card> deckCards = new ArrayList<>();


	public Deck() {
		this.deckCards = generateDeck();
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

	@Override
	public String toString() {
		return "Deck{" +
				"id=" + id +
				", deckCards=" + deckCards +
				'}';
	}
}

