package Blackjack.blackjack.domain;

import Blackjack.blackjack.domain.Person.Dealer.Dealer;
import Blackjack.blackjack.domain.Person.Person;
import Blackjack.blackjack.domain.Person.player.Player;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Game {

	public Game() {
		setPlayer(new Player());
		setDealer(new Dealer());
		setDeck(new Deck());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
	@SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "dealer_id", nullable = false)
	private Dealer dealer;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "deck_id", nullable = false)
	private Deck deck;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "winner_id", nullable = true)
	private Person winner;

	private boolean push = false;


	public Person getWinner() {
		return winner;
	}

	public Long getGame_id() {
		return getId();
	}


	public boolean isPush() {
		return push;
	}


	@Override
	public String toString() {
		return "Game{" +
				"id=" + id +
				", player=" + player +
				", dealer=" + dealer +
				", deck=" + deck +
				", winner=" + winner +
				", push=" + push +
				'}';
	}
}