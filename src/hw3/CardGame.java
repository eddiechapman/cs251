package hw3;
import java.util.Random;

public class CardGame 
{

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};

	private boolean[] deck;
	private String[][] players;
	private int cardsDealt;
	private boolean hasDealtCards;
	private boolean hasShownHands;
	
	// TODO: Should the deck be initialized at the top of the class or in the constructor?
	// TODO: Where does input validation go? The driver?
	public CardGame(int totalPlayers) 
	{
		
		if (totalPlayers > 1 && totalPlayers < 9) 
		{
			players = new String[totalPlayers][5];
		}
		else 
		{
			players = new String[2][5];
		}
		
		deck = new boolean[52];
		cardsDealt = 0;	
		hasDealtCards = false;
		hasShownHands = false;
		
	} // end CardGame
	
	
	public int getTotalCardsDealt() 
	{
		return cardsDealt;
	} 
	
	
	/*
	 *  Shuffle the deck by setting all values to true.
	 */
	public void resetDeck() 
	{
		for (int card = 0; card < deck.length; card ++) 
		{
			deck[card] = true;
		}
		
		cardsDealt = 0;
		hasDealtCards = false;
		
	} // end resetDeck
	
	
	/*
	 * Deal out cards to each player in the game.
	 */
	public void dealHands() 
	{
		if (hasDealtCards == true) 
		{
			System.out.print("ERROR: Cards have already been dealt. Please reshuffle and try again.");	
		}
		else 
		{
			hasDealtCards = true;
			
			for (int p = 0; p < players.length; p++)
			{
				for (int c = 0; c < players[p].length; c++)
				{
					players[p][c] = dealCard();
				}
			}
		}	

	} // end dealHands
	
	
	/*
	 * Deal one card from the deck.
	 * 
	 * Select a card in the deck using a randomly generated integer.
	 * Repeat until a card selected that has not been dealt this round.
	 * Mark the card as dealt. Return the number and suit of the card
	 * using convertCard(). 
	 */
	private String dealCard() 
	{
		Random r = new Random();
		
		int card = 0;
		
		do 
		{
			card = r.nextInt(52);
		} 
		while (deck[card] == false);
		
		deck[card] = false;
		cardsDealt++;
		
		return convertCard(card);

	} // end dealCard
	
	
	/**
	 * Match the "card" index position to a uniquely paired card number and suit.
	 * 
	 * @param card
	 * @return String representing the number and suit of the card
	 */
	private String convertCard(int card) 
	{
		return cardNumbers[card % 13] + "|" + cardSuits[card % 4];
	}
	
	
	// TODO: Documentation
	public boolean addPlayers(int playersToAdd) 
	{
		int newPlayerCount = playersToAdd + players.length;
		String[][] newPlayers = new String[newPlayerCount][5];
		
		if (newPlayerCount > 8 || newPlayerCount < players.length)
		{
			
			return false;
		}
		else
		{	
			for (int p = 0; p < players.length; p++) 
			{
				for (int c = 0; c < players[p].length; c++) 
				{
					newPlayers[p][c] = players[p][c];
				}
			}
			for (int p = 0; p < newPlayers.length; p++) 
			{
				for (int c = 0; c < newPlayers[p].length; c++)
				{
					if (newPlayers[p][c] != "") 
					{
						newPlayers[p][c] = dealCard();
					}
				}
			}
			players = newPlayers;
			return true;
		}
	
	} // end addPlayers
	

	
	public void displayHands() 
	{
		hasShownHands = true;
		
		for (int p = 0; p < players.length; p++) 
		{
			System.out.print("Player " + (p + 1) + ":\t");
			
			for (int c = 0; c < players[p].length; c++) 
			{
				System.out.print(players[p][c] + "\t"); 
			}
			System.out.println();
		}
		System.out.println();
		
	} // end displayHands
	
	
} // end CardGame
