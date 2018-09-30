package CS251_HW3;


public class CardGame {

	private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] cardSuits = {"D","H","C","S"};

	//TODO
	private boolean deck[];
	private String[][] players;
	private int cardsDealt;
	private boolean hasDealtCards;
	private boolean hasShownHands;
	// public variables that can be accessed within the driver 
	public int playersToAdd;
	public int cardGameCount;
	public static int cardStaticCount;
	
	
	public CardGame(int totalPlayers){
		if(totalPlayers >= 2 && totalPlayers <= 8) {
			players = new String [totalPlayers][5];
		}
		else{
			players = new String[2][5];	
		}
		cardsDealt = 0;
		deck = new boolean[52];
		hasDealtCards = false;
		hasShownHands = false;
		cardStaticCount++;
		cardGameCount = cardStaticCount;
	}
		
	
	public int getTotalCardsDealt() {
		return cardsDealt;
	
	}
	public void resetDeck() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = true;
		}
		;
		cardsDealt = 0;
		hasDealtCards = false;
		hasShownHands = false;
	}
	public void dealHands() {
		if(hasDealtCards == true) {
			System.out.println("The Cards have already been dealt! Please reshuffle the deck and try again");
		}
		else {
			hasDealtCards = true;
			for (int i = 0; i < players.length; i++) {
				for (int n = 0; n < players[i].length; n++) {
					players[i][n] = dealCard();

				}

			}
		}
		
		
		
	}
	public String dealCard() {
		int pos;
		do {
			pos = (int) (Math.random() * 52);
		}

		while (deck[pos] = false);
		deck[pos] = false;
		cardsDealt++;

		return convertCard(pos);
		
	}
	public String convertCard(int card) {
		String playersCard = cardNumbers[card % 13] + " of " + cardSuits[card % 4];
		return playersCard;
		
	}
	public void displayHands() {
		
		// a check for null is made to ensure the hands have been dealt
		if(players[0][0] != null) {
			hasShownHands = true;
			System.out.println("Game " + cardGameCount + " hands");
			for(int i= 0; i< players.length; i++) {
				System.out.println("Player " + (i+1) + "'s" + " cards:");
				for(int n = 0; n < players[i].length; n++) {
					System.out.print(players[i][n] +"\t");



				}
				System.out.println();
				
			
			}
		}
		else {
			System.out.println("You must deal hands out to the players");	
	}
	}
	
	public boolean addPlayers(int playersToAdd) {
		this. playersToAdd = playersToAdd;
		int newPlayers = players.length + playersToAdd;
		int startIndex = players.length;
		System.out.println("attempting to add more players...");
		//this copies the existing players array to a new temporary array after
		// checking  that the hands have not been shown and a valid input has been made.
		
		
		if(newPlayers <= 8 && newPlayers > players.length && hasShownHands == false){ 
			String playArray[][] = new String [newPlayers][5];
			for (int p = 0; p < players.length; p++) {
				for(int c = 0; c < players[p].length; c++) {
					playArray[p][c] = players[p][c]; 
					
				}
			}
			// this uses the startIndex variable to append the new players added 
			for(int p = 0; p < playersToAdd; p++) {
				for(int c = 0; c < 5; c++) {
					playArray[startIndex][c] = dealCard();
					
				}
				startIndex++;
			}
			
			players = playArray;
			
			return true;
		}
		
		else {
			
			
			return false;
		}
		
	}
	
	
	
} // end class

