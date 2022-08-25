package Blackjack.blackjack.controllers;

import Blackjack.blackjack.domain.Game;
import Blackjack.blackjack.repositories.GameRepository;
import Blackjack.blackjack.services.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class GameController {

	private final GameService gameService;
	private final GameRepository gameRepository;

	ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	@Autowired
	public GameController(GameService gameService, GameRepository gameRepository) {
		this.gameService = gameService;
		this.gameRepository = gameRepository;
	}

	@GetMapping(value = "api/v1/game/startGame/{playersName}")
	public String startNewGame(@PathVariable String playersName) throws JsonProcessingException {
		Game game = gameService.startGame(playersName);
		Game g = gameRepository.save(game);
		try {
			return mapper.writeValueAsString(g);
		}
		// Catch block to handle exceptions
		catch (IOException e) {
			// Display exception along with line number
			// using printStackTrace() method
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("api/v1/game/{gameId}")

	public String getGame(@PathVariable Long gameId) {
		Optional<Game> g = gameRepository.findById(gameId);

		if (g.isPresent()) {
			try {
				return mapper.writeValueAsString(g.get());
			}
			// Catch block to handle exceptions
			catch (IOException e) {
				// Display exception along with line number
				// using printStackTrace() method

				//TODO: server error
				e.printStackTrace();
			}
		}
		//TODO: return not found
		return null;
	}

	@GetMapping("api/v1/game/hit/{gameId}")
	public String playerHit(@PathVariable Long gameId) {
		Optional<Game> game = gameRepository.findById(gameId);
		if (game.isPresent()) {
			Game g = game.get();
			Game afterHit = gameService.hit(g);
			g = afterHit;
			gameRepository.save(g);

			//TODO: update the game in the database.

			try {
				return mapper.writeValueAsString(afterHit);
			}
			// Catch block to handle exceptions
			catch (IOException e) {
				// Display exception along with line number
				// using printStackTrace() method
				//TODO: server error
				e.printStackTrace();
			}
		}
		//TODO: return not found
		return null;
	}

	@GetMapping("api/v1/game/stand/{gameId}")
	public String playerStand(@PathVariable Long gameId) {
		Optional<Game> game = gameRepository.findById(gameId);

		if (game.isPresent()) {
			Game g = game.get();
			Game gameResult = gameService.dealerMustHitIfUnder17(g);
			gameRepository.save(gameResult);

			//TODO: evaluate the game and return the result.

			try {
				return mapper.writeValueAsString(gameResult);
			}
			// Catch block to handle exceptions
			catch (IOException e) {
				// Display exception along with line number
				// using printStackTrace() method
				//TODO: server error
				e.printStackTrace();
			}
		}
		//TODO: return not found
		return null;
	}
}
