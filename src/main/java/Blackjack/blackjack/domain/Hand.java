package Blackjack.blackjack.domain;


import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "hand_card",
			joinColumns = @JoinColumn(name = "hand_id", referencedColumnName = "id"))
	private List<Card> handCards = new ArrayList<>();


	private int sum;

	public Hand() {
		handCards = new ArrayList<>();
	}


	// Henter summen av kortene.
	public int getSum() {
		int sum = 0;
		int acesCount = 0;

		for (Card card : handCards) {
			if (card.getValue() == 11)
				acesCount++;
			sum += card.getValue();
		}

		if (sum > 21 && acesCount > 0) {
			while (acesCount > 0 && sum > 21) {
				acesCount--;
				sum -= 10;
			}
		}
		return sum;
	}

	public Card getCard(int i) {
		return handCards.get(i);
	}

	// Kan forbedres ved å sjekke om deck har flere kort igjen.
	public void takeCardFromDeck(@NotNull Deck deck) {
		Card card = deck.takeCard();
		handCards.add(card);
		setSum(getSum());
		deck.removeCard();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Card> getHandCards() {
		return handCards;
	}

	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}

	@Override
	public String toString() {
		return "Hand{" +
				"id=" + id +
				", handCards=" + handCards +
				'}';
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
