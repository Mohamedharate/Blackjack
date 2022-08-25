package Blackjack.blackjack.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	public Card() {
	}

	public Card(CardSuitsEnum cardSuit, int value) {
		this.cardSuit = cardSuit;
		setValue(value);
	}


	@Enumerated(EnumType.ORDINAL)
	private CardSuitsEnum cardSuit;
	private int value;

	@ManyToMany(mappedBy = "deckCards")
	private List<Deck> deck;

	@ManyToMany(mappedBy = "handCards")
	private List<Hand> hand;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value < 1 || value > 11) {
			throw new IllegalArgumentException("The cards value must be between 1 and 11.");
		}
		this.value = value;
	}

	@Override
	public String toString() {
		return
				"[" + cardSuit + "(" + value + ")]";
	}

	public CardSuitsEnum getCardSuit() {
		return cardSuit;
	}


}

