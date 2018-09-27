package hw3;
import java.util.Scanner;

public class CardGame {

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};

	private boolean[] deck;
	private String[][] players;
	private int cardsDealt;
	private boolean hasDealtCards;
	
	// TODO: Should the deck be initialized at the top of the class or in the constructor?
	// TODO: Where does input validation go? The driver?
	public CardGame(int totalPlayers) 
	{
		if (totalPlayers > 1 && totalPlayers < 9) 
		{
			this.players = new String[totalPlayers][5]; 
		}
		
	} // end CardGame
	
	public int getTotalCardsDealt() {
		return;
	}
	
	// Shuffle the deck by setting all values to true.
	// TODO: Does this need to reset cardsDealt or hasDealtCards as well?
	public void resetDeck() 
	{
		for (int card = 0; card < deck.length; card ++) 
		{
			deck[card] = true;
		}
		
	} // end resetDeck
	
	public void dealHands() 
	{
		
		for (int p = 0; p < players.length; p++)
		{
			for (int c = 0; c < players[p].length; c++)
			{
				players[p][c] = dealCard(deck);
			}
		}

	} // end dealHands
	
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
