package Blackjack.blackjack.services;

import Blackjack.blackjack.domain.Person.Dealer.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

	private final HandService handService;

	@Autowired
	public DealerService(HandService handService) {
		this.handService = handService;
	}

	//Denne metoden viser det første kortet til dealeren.
	public String showFirstHand(Dealer dealer) {
		return handService.getCard(dealer.getHand(), 0).toString();
	}
}
