package hw3;
import java.util.Scanner;

public class CardGame {

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};

	private boolean[] deck;
	private String[][] players;
	private int cardsDealt;
	private boolean hasDealtCards;
	
	
	public CardGame(int totalPlayers) {
		// Should the deck be initialized at the top of the class or in the constructor?
		// Where does input validation go? The driver?
		if (totalPlayers > 1 && totalPlayers < 9) 
		{
			this.players = new String[totalPlayers][5]; 
		}
		
	}
	
	public int getTotalCardsDealt() {
		return;
	}
	
	// Shuffle the deck by setting all values to true.
	public void resetDeck() {
		
		// Does this need to reset cardsDealt or hasDealtCards as well?
		
		for (int card = 0; card < deck.length; card ++) 
		{
			deck[card] = true;
		}
		
	} // end resetDeck
	
	public void dealHands() {
		return;
	}
	
	private String dealCard() {
		return;
	}
	
	private String convertCard(int card) {
		return;
	}
	
	public void addPlayers(int playersToAdd) {
		return;
	}
	
	public void displayHands() {
		return;
	}
	
}
