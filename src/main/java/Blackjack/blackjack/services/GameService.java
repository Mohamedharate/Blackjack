package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	private final HandService handService;
	private final PersonService personService;
	private final DeckService deckService;

	ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	@Autowired
	public GameService(HandService handService, PersonService personService, DeckService deckService) {
		this.handService = handService;
		this.personService = personService;
		this.deckService = deckService;
	}

	public Game startGame(String playersName) {

		Game game = new Game();

		game.getPlayer().setName(playersName);

		// Shuffle the deck
		deckService.shuffleCards(game.getDeck());

		// Give dealer and player two cards each
		playerAndDealerGetsTwoCardsEach(game);

		// Checks if the dealer or the player has blackjack. Push if both have Blackjack
		isBlackjack(game);

		return game;
	}

	public Game hit(Game game) {
		personService.hit(game.getDeck(), game.getPlayer());
		if (game.getPlayer().getHand().getSum() > 21) {
			game.setWinner(game.getDealer());
		}
		return game;
	}

	public void playerAndDealerGetsTwoCardsEach(Game game) {
		for (int i = 0; i < 2; i++) {
			handService.takeCardFromDeck(game.getDeck(), game.getPlayer().getHand());
			handService.takeCardFromDeck(game.getDeck(), game.getDealer().getHand());
		}
	}

	public Game dealerMustHitIfUnder17(Game game) {
		while (game.getDealer().getHand().getSum() < 17) {
			personService.hit(game.getDeck(), game.getPlayer());
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

	public boolean isBlackjack(Game game) {
		if (personService.hasBlackjack(game.getDealer())) {
			if (personService.hasBlackjack(game.getPlayer())) {
				game.setPush(true);
				return true;
			} else {
				game.setWinner(game.getDealer());
			}
		} else if (personService.hasBlackjack(game.getPlayer())) {
			game.setWinner(game.getPlayer());
			return true;
		}
		return false;
	}
}
