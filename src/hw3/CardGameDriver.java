package hw3;

public class CardGameDriver {

	public static void main(String[] args) {

		CardGame game1 = new CardGame(3);  // Instantiating CardGame object
		game1.resetDeck();
		System.out.println("Total cards dealt: " + game1.getTotalCardsDealt());
		game1.dealHands();
		System.out.println("Total cards dealt: " + game1.getTotalCardsDealt());
		game1.displayHands();
		
		CardGame game2 = new CardGame(3);
		game2.resetDeck();
		System.out.println("Total cards dealt: " + game2.getTotalCardsDealt());
		game2.dealHands();
		System.out.println("Total cards dealt: " + game2.getTotalCardsDealt());
		System.out.println("\nAttempting to add more players.");
		if (game2.addPlayers(3)) 
		{
			game2.addPlayers(3);
		}
		else
		{
			System.out.println("Cannot add more players. Please reshuffle.");
		}
		System.out.println("Total cards dealt: " + game2.getTotalCardsDealt());
		game2.displayHands();
		
		CardGame game3 = new CardGame(3);
		game3.resetDeck();
		System.out.println("Total cards dealt: " + game3.getTotalCardsDealt());
		game3.dealHands();
		System.out.println("Total cards dealt: " + game3.getTotalCardsDealt());
		game3.addPlayers(6);
		game3.dealHands();
		System.out.println("Total cards dealt: " + game3.getTotalCardsDealt());
		game3.displayHands();
		

	}

}
