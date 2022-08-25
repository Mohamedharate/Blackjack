package Blackjack.blackjack.repositories;

import Blackjack.blackjack.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
