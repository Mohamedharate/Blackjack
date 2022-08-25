package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameService {

	HashMap<Integer, Game> blackjackGames = new HashMap<>();
	ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public Game startGame(String playersName) {

		Game game = new Game();
		game.getPlayer().setName(playersName);

		// Shuffle the deck
		game.getDeck().shuffleCards();

		// Give dealer and player two cards each
		playerAndDealerGetsTwoCardsEach(game);

		// Show the dealer's first hand
		System.out.println(game.getDealer().showFirstHand());

		// Show players cards
		game.getPlayer().showCards();

		// Checks if the dealer or the player has blackjack. Push if both have Blackjack
		isBlackjack(game);
		return game;
	}

	public Game hit(Game game) {

		game.getPlayer().hit(game.getDeck());

		if (game.getPlayer().getHand().getSum() > 21) {
			game.setWinner(game.getDealer());
		}
		return game;
	}

	public void playerAndDealerGetsTwoCardsEach(Game game) {
		for (int i = 0; i < 2; i++) {
			game.getPlayer().getHand().takeCardFromDeck(game.getDeck());
			game.getDealer().getHand().takeCardFromDeck(game.getDeck());
		}
	}

	public Game dealerMustHitIfUnder17(Game game) {

		while (game.getDealer().getHand().getSum() < 17) {
			game.getDealer().hit(game.getDeck());
		}
		evaluateTheGame(game);
		return game;
	}

	private void evaluateTheGame(Game game) {
		// If the user gets over 21 after hit, the user loose.
		if (game.getPlayer().getHand().getSum() > 21) {
			game.setWinner(game.getDealer());
		} else if (game.getDealer().getHand().getSum() > 21) {
			game.setWinner(game.getPlayer());
		} else if (game.getDealer().getHand().getSum() > game.getPlayer().getHand().getSum()) {
			game.setWinner(game.getDealer());
		} else if (game.getPlayer().getHand().getSum() > game.getDealer().getHand().getSum()) {
			game.setWinner(game.getPlayer());
		} else {
			game.setPush(true);
		}
	}

	private void isBlackjack(Game game) {
		if (game.getDealer().hasBlackjack()) {
			if (game.getPlayer().hasBlackjack()) {
				game.setPush(true);
			} else {
				game.setWinner(game.getDealer());
			}
		} else if (game.getPlayer().hasBlackjack()) {
			game.setWinner(game.getPlayer());
		}
	}
}
