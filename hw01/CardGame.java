import java.util.Scanner;

public class CardGame {

	
	//class level variables you may use to convert numbers from 0-51 to a card.
	public static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static final String[] cardSuits = {"D","H","C","S"};

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		
		//Your deck of cards.
		//True means the card is still in the deck, false means it has been dealt
		boolean[] deck = new boolean[52];  
		
		//A 2D array that holds Strings.
		//The first perameter will determine the number of players.
		//The second perameter will determine how many cards they will hold.  It should always be 5.
		String[][] players;
		
		//boolean variable used to determine if the user would like to play again.
		boolean playAgain;

		do{

			players = playerPrompt(scr);		//create and store the 2D array
			resetDeck(deck);					//reset the deck so all cards are present
			dealHands(players, deck);			//deal out cards to each player
			displayHands(players);				//show each players hands
			playAgain = playerRePrompt(scr);	//see if the player wishes to play again


		} while (playAgain);

		System.out.println("Thank you, goodbye");
		scr.close();
	}

	
	/**
	 * Ask the user how many players they want to play.
	 * Make sure the number entered is between 2 and 8.
	 * A player can only hold 5 cards at a time.
	 * Return a new 2D String containing the total players and the amount of cards they can hold.
	 * ie. new String[totalPlayers][5];
	 * 
	 * @param Scanner scr
	 * @return String[][]
	 */
	public static String[][] playerPrompt (Scanner scr){
		
		//TODO

	}

	
	/**
	 * Ask the player if they want to play again.
	 * Return true if they want to play again, false otherwise.
	 * The only way to quit is by entering "no".
	 * 
	 * @param Scanner scr
	 * @return boolean
	 */

	public static boolean playerRePrompt (Scanner scr){
		
		//TODO

	}

	
	/**
	 * Reset the deck for the next round.
	 * Think of this as collecting all the cards.
	 * A card is in the deck if it's value is true.
	 * 
	 * @param boolean [] deck
	 */
	public static void resetDeck(boolean[] deck){
		
		//TODO

	}

	
	/**
	 * Deal out the cards to each player.
	 * The 2D String array called players will hold the card values.
	 * See the assignment description for a visual of how this will work.
	 * You will need to call dealCard and use a double for loop to fill the 2D String array.
	 * 
	 * @param players
	 * @param deck
	 */
	public static void dealHands(String[][] players, boolean[] deck){
		
		//TODO

	}

	
	/**
	 * Deal one card from the deck.
	 * Use the boolean array to tell if a card has been dealt yet.
	 * You will need to call convertCard to convert the index of an available card to it's correct card representation.
	 * You will need to use a random number generator to simulate an actual shuffled deck.
	 * Remember, Math.random() returns a number from 0 to .99999....
	 * 
	 * @param deck
	 * @return String
	 */
	public static String dealCard(boolean[] deck){
		
		//TODO

	}

	
	/**
	 * Given a number between 0 and 51, convert that number to the correct format.
	 * It is up to you how each card is converted, just make sure that each number is mapped to a unique card.
	 * Just make sure a mapping is 1 to 1, meaning if 4 converts to "4C", it will always convert to "4C"
	 * Also make sure it is possible for each card to be dealt.
	 * 
	 * I have provided two arrays at the top, cardNumbers and cardSuits you may use if you wish.
	 * There is clever way to convert a number using modulus and division, and this method can be done in one line.
	 * 
	 * @param card
	 * @return String representing a card in correct format
	 */
	public static String convertCard(int card){
		
		//TODO
		
	}


	/**
	 * Display all the players hands to the console.
	 * You will need a double for loop.
	 * 
	 * @param players
	 */
	public static void displayHands(String[][] players){

		//TODO
		
	}


}
