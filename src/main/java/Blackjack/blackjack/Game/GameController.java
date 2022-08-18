package Blackjack.blackjack.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService =  gameService;
    }

    @GetMapping("api/v1/game/startGame/{playersName}")
    public String startNewGame(@PathVariable String playersName){
        return gameService.startGame(playersName);
    }

    @GetMapping("api/v1/game/hit/{gameId}")
    public String playerHit(@PathVariable int gameId){
        return gameService.hit(gameId);
    }

    @GetMapping("api/v1/game/stand/{gameId}")
    public String playerStand(@PathVariable int gameId){
        return gameService.dealerMustHitIfUnder17(gameId);
    }

}
