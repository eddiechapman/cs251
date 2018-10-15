/********************************************************************************
f * Charmander.java
 * Eddie Chapman
 * 
 * A class representing the Charmander type of Pokemon.
 *******************************************************************************/

package hw5;

public class Charmander extends Pokemon {

	private final static int fireBall = 5;	// Charmander's special attack damage
	private final static int bite = 4;		// Charmander's physical attack damage
	
	//***************************************************************************
	
	public Charmander(int health, int power, int level) {
		
		super("Charmander", health, power, level);
		
	}
	
	//***************************************************************************
	
	/**
	 * Displays this pokemon's attributes in string format.
	 * 
	 * @return 	a summary of the pokemon's name, level, health, and power.
	 */
	@Override
	public String toString() {
		
		return "Name: " + name
				+ "\nLevel: " + level
				+ "\nHealth: " + health
				+ "\nPower: " + power;
		
	} // end toString 
	
	//***************************************************************************
	
	/**
	 * Determine if another object shares the same class and parameter values as 
	 * this pokemon.
	 * 
	 * @param other		an object to compare for equality against this pokemon.	
	 * @return			true if object is equal to this pokemon, false otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		
		if (other == this) {
			return true;
		}
		
		if (!(other instanceof Charmander)) {
			return false;
		}
		
		Charmander c = (Charmander) other;
		
		return c.name.equals(this.name) 
				&& c.health == this.health
				&& c.level == this.level
				&& c.power == this.power;
		
	} // end equals
	
	//***************************************************************************
	
	/**
	 * Expend power to inflict damage to an enemy pokemon. 
	 * 
	 * If the pokemon has insufficient power to perform the full attack, 
	 * the target is dealt damage equal to the pokemon's remaining power.
	 * 
	 * If the pokemon has no power, its physical attack is called instead.
	 * 
	 * If either pokemon is defeated, nothing happens.
	 * 
	 * @param target	an enemy pokemon that receives damage from the attack.
	 */
	@Override
	public void specialAttack(Pokemon target) {
		
		if (!this.isDefeated() && !target.isDefeated()) {
			
			if (power <= 0) {
				physicalAttack(target);
			}
			
			else if (power >= fireBall) {
				target.hurt(fireBall);
				power -= fireBall;
			}
			
			else if (power < fireBall) {
				target.hurt(power);
				power = 0;
			}
			
		}
		
	} // end specialAttack
	
	//***************************************************************************
	
	/**
	 * Deal damage to an enemy pokemon without consuming any power.
	 * Will have no effect if either this pokemon or the target is defeated.
	 * 
	 * @param target	an enemy pokemon that receives damage from the attack.
	 */
	@Override
	public void physicalAttack(Pokemon target) {
		
		if (this.isDefeated() || target.isDefeated()) {
			return;
		}
		
		target.hurt(bite);
		
	}
} // end class Pikachu
