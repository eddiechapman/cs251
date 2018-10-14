/********************************************************************************
 * Driver.java
 * Eddie Chapman
 * 
 * Creates pokemon based on user-input and simulates a battle between them.
 *******************************************************************************/

package hw5;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		Pokemon[] arrOfPokemons = new Pokemon[4];
		Scanner stdIn = new Scanner(System.in);
		
		for (int i=0; i<arrOfPokemons.length; i++) {
			
			while (true) {
				
				System.out.println("Enter the name, health, power, and level for Pokemon #" + (i + 1));
				
				String name = stdIn.next();
				int health = stdIn.nextInt();
				int power = stdIn.nextInt();
				int level = stdIn.nextInt();
				
				Pokemon pokemon = makePokemon(name, health, power, level);
				
				if (pokemon == null) {
					System.out.println("I couldn't make a pokemon from those values. Try again?");
				} 
				else if (contains(pokemon, arrOfPokemons)) {
					System.out.println("Sorry, that pokemon already exists. Try a different pokemon?");
				} 
				else {
					arrOfPokemons[i] = pokemon;
					break;
				}
				
			} // end while
			
		} // end for
		
		System.out.println();
		System.out.println("Pokemons before playing");
		print(arrOfPokemons);
		System.out.println();
		
		for(int i=0; i<3; i++) {
			play(arrOfPokemons, stdIn, i);
		}
		
		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
		
	} // end main
	
	//***************************************************************************
	
	/**
	 * Print the pokemon in the arrOfPokemons array.
	 * 
	 * @param arrOfPokemons		an array containing pokemon
	 */
	private static void print(Pokemon[] arrOfPokemons) {

		for (int index=0; index<arrOfPokemons.length; index++) {
			System.out.printf("%d: %s\n", index, arrOfPokemons[index].toString());
		}
	
	}
	
	//***************************************************************************
	
	/**
	 * Simulate a battle between pokemon chosen by the user.
	 * 
	 * @param arrOfPokemons		an array containing pokemon
	 * @param stdIn				a scanner object for user input
	 * @param numberOfPlay		
	 */
	private static void play(Pokemon[] arrOfPokemons, Scanner stdIn, int numberOfPlay) {
		
		int firstPokemon = 0;
		int secondPokemon = 0;
		
		do {
			System.out.printf("# %d Please enter the pokemons you want to play 0 to 3: ", numberOfPlay);
			firstPokemon = stdIn.nextInt();
			secondPokemon = stdIn.nextInt();
		} while (firstPokemon < 0 
				|| firstPokemon > 4 
				|| secondPokemon < 0 
				|| secondPokemon > 4);
		
		arrOfPokemons[firstPokemon].specialAttack(arrOfPokemons[secondPokemon]);

		//think of this part as a counterattack
		arrOfPokemons[secondPokemon].physicalAttack(arrOfPokemons[firstPokemon]);
		
	} // end Play
	
	//***************************************************************************

	/**
	 * Creates a pokemon based on name passed to method.
	 * 
	 * @param name		the name of the pokemon to be created. Not case-sensitive.
	 * @param health	the health of the pokemon to be created
	 * @param power		the power of the pokemon to be created
	 * @param level		the level of the pokemon to be created
	 * @return Pokemon	either pikachu or charmander depending on user input
	 */
	static Pokemon makePokemon(String name, int health, int power, int level) {
		
		Pokemon pokemon = null;
		
		switch (name.toLowerCase()) {
			case "charmander":
				return pokemon = new Charmander(health, power, level);
			case "pikachu":
				return pokemon = new Pikachu(health, power, level);
			default:
				return pokemon;
		} // end switch
		
	} // end makePokemon
	
	//***************************************************************************

	/**
	 * Determines if a pokemon is already present in an array.
	 * This method does not compare array values that are null.
	 * 
	 * @param pok				the pokemon that is or is not present in the array
	 * @param arrOfPokemons		an array of pokemon that may contain pokemon pok
	 * @return boolean			true if the pokemon is present, false if not.
	 */
	protected static boolean contains(Pokemon pok, Pokemon[] arrOfPokemons) {
		
		for (Pokemon p: arrOfPokemons) {
			if ((p != null) && p.equals(pok)) {
				return true;
			}
		}
		
		return false;
		
	} // end contains
	
} // end Driver
