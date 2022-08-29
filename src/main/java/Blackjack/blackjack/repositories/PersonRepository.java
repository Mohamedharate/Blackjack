package Blackjack.blackjack.repositories;


import Blackjack.blackjack.domain.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
