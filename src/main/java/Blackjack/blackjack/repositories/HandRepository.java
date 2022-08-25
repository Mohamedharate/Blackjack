package Blackjack.blackjack.repositories;

import Blackjack.blackjack.domain.Hand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandRepository extends JpaRepository<Hand, Long> {
}
