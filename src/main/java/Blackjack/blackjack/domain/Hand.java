package Blackjack.blackjack.domain;


import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
public class Hand {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hand_sequence")
	@SequenceGenerator(name = "hand_sequence", sequenceName = "hand_sequence", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;


	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "hand_card",
			joinColumns = @JoinColumn(name = "hand_id", referencedColumnName = "id"))
	private List<Card> handCards = new ArrayList<>();

	@Column(name = "sum", nullable = false)
	private int sum;

	public Hand() {
		handCards = new ArrayList<>();
	}


	public List<Card> getHandCards() {
		return handCards;
	}

	// Henter summen av kortene.
	public int calculateSum() {
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

	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Hand{" +
				"id=" + id +
				", handCards=" + handCards +
				'}';
	}

	public int getSum() {
		return calculateSum();
	}
}
