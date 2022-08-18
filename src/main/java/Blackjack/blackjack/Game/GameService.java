package Blackjack.blackjack.Game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;

@Service
public class GameService {

    HashMap<Integer, Game> blackjackGames = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public String startGame(String playersName) {

        Game game = new Game();
        game.setId(blackjackGames.size() + 1);

        blackjackGames.put(blackjackGames.size() + 1, game);

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
        try {
            return mapper.writeValueAsString(game);
        }
        // Catch block to handle exceptions
        catch (IOException e) {
            // Display exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        return playersName;
    }

    public String hit(int gameId){

        Game game = blackjackGames.get(gameId);

        game.getPlayer().hit(game.getDeck());

        if (game.getPlayer().getHand().getSum() > 21){
            game.setVinner(game.getDealer().getName());
        }
        try {
            return mapper.writeValueAsString(game);
        }
        // Catch block to handle exceptions
        catch (IOException e) {
            // Display exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return " NULLLLLL ";
    }

    public void playerAndDealerGetsTwoCardsEach(Game game) {
        for (int i = 0; i < 2; i++) {
            game.getPlayer().getHand().takeCardFromDeck(game.getDeck());
            game.getDealer().getHand().takeCardFromDeck(game.getDeck());
        }
    }

    public String dealerMustHitIfUnder17(int gameId) {

        Game game = blackjackGames.get(gameId);

        while (game.getDealer().getHand().getSum() < 17) {
            game.getDealer().hit(game.getDeck());
        }
        evaluateTheGame(game);
        try {
            return mapper.writeValueAsString(game);
        }
        // Catch block to handle exceptions
        catch (IOException e) {
            // Display exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return " NULLLLLL ";
    }

    private void evaluateTheGame(Game game) {
        // If the user gets over 21 after hit, the user loose.
        if (game.getPlayer().getHand().getSum() > 21){
            game.setVinner(game.getDealer().getName());
        }
        else if (game.getDealer().getHand().getSum() > 21) {
            game.setVinner(game.getPlayer().getName());
        } else if (game.getDealer().getHand().getSum() > game.getPlayer().getHand().getSum()) {
            game.setVinner(game.getDealer().getName());
        } else if (game.getPlayer().getHand().getSum() > game.getDealer().getHand().getSum()) {
            game.setVinner(game.getPlayer().getName());
        } else {
            game.setVinner(Result.PUSH.toString());
        }
    }

    private void isBlackjack(Game game) {
        if (game.getDealer().hasBlackjack()) {
            if (game.getPlayer().hasBlackjack()) {
                game.setVinner(Result.PUSH.toString());

            } else {
                game.setVinner(game.getDealer().getName());
            }
        } else if (game.getPlayer().hasBlackjack()) {
            game.setVinner(game.getPlayer().getName());
        }
    }
}
