package Blackjack.blackjack.domain.Person;

import Blackjack.blackjack.domain.Deck;
import Blackjack.blackjack.domain.Hand;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(
			name = "name",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String name;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "hand_id", nullable = false)
	private Hand hand;

	public Person() {
		this.hand = new Hand();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void hit(Deck deck) {
		this.hand.takeCardFromDeck(deck);
	}

	public boolean hasBlackjack() {
		return this.getHand().getSum() == 21;
	}


	public void showCards() {
		System.out.println(this.name + " har følgende kort");
		System.out.println(this.hand + " Sum " + this.hand.getSum());
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person person)) return false;
		return id.equals(person.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", hand=" + hand +
				'}';
	}
}
