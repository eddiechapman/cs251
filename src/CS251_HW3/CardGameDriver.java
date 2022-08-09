package CS251_HW3;

public class CardGameDriver {

	public static void main(String[] args) {

		CardGame game1 = new CardGame(4);
		CardGame game2 = new CardGame(7);
		CardGame game3 = new CardGame(3);
		
		
		
		game1.dealHands();
		
		game1.addPlayers(2);
		game1.dealHands(); // prints error because hands have already been dealt
		
		game2.addPlayers(1);
		System.out.println(game2.getTotalCardsDealt()); // should print 5 
		game2.displayHands();
		game3.dealHands();
		
		
		System.out.println(game1.getTotalCardsDealt()); // should print 20 
		
		game1.displayHands();
		game3.displayHands();
		
		game3.resetDeck();
		game3.dealHands();
		//game3.displayHands();
		
		
		//Will not add players because hands have been shown
		if(game3.addPlayers(4)) {
			System.out.print("Game " + game3.cardGameCount + " has added " + game3.playersToAdd + " players.\n");
		}
		else {
			System.out.println("The cards have already been shown, or you "
					+ "have entered an incorrect number of players to add. \nNo Players Added");
		}
		game3.displayHands();
		
		
		

	}
;
}
