package Blackjack.blackjack.domain.Person;

import Blackjack.blackjack.domain.Hand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
	@SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
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
