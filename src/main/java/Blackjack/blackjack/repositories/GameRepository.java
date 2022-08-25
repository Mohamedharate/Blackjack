package Blackjack.blackjack.repositories;

import Blackjack.blackjack.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

