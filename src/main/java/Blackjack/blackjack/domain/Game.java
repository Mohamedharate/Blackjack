package Blackjack.blackjack.domain;

import Blackjack.blackjack.domain.Person.Dealer.Dealer;
import Blackjack.blackjack.domain.Person.Person;
import Blackjack.blackjack.domain.Person.player.Player;

import javax.persistence.*;

@Entity
public class Game {

	public Game() {
		setPlayer(new Player());
		setDealer(new Dealer());
		setDeck(new Deck());
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", nullable = false)
	private Long game_id;

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

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void setWinner(Person winner) {
		this.winner = winner;
	}

	public Person getWinner() {
		return winner;
	}

	public Long getGame_id() {
		return game_id;
	}


	public Long getId() {
		return game_id;
	}

	public void setId(long game_id) {
		this.game_id = game_id;
	}

	public Player getPlayer() {
		return player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Deck getDeck() {
		return deck;
	}


	public boolean isPush() {
		return push;
	}

	public void setPush(boolean push) {
		this.push = push;
	}

	@Override
	public String toString() {
		return "Game{" +
				"game_id=" + game_id +
				", player=" + player +
				", dealer=" + dealer +
				", deck=" + deck +
				", winner=" + winner +
				", push=" + push +
				'}';
	}
}