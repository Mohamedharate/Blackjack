package Blackjack.blackjack.repositories;

import Blackjack.blackjack.domain.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepositrory extends JpaRepository<Deck, Integer> {
}
