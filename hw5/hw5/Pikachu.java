/********************************************************************************
 * Pikachu.java
 * Eddie Chapman
 * 
 * A class representing the Pikachu type of Pokemon.
 *******************************************************************************/

package hw5;

public class Pikachu extends Pokemon {
	
	private final static int thunderBolt = 6;	// pikachu's special attack damage
	private final static int swipe = 3;			// pikachu's physical attack damage
	
	//***************************************************************************
	
	public Pikachu(int health, int power, int level) {
		super("Pikachu", health, power, level);
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
		if (!(other instanceof Pikachu)) {
			return false;
		}
		Pikachu p = (Pikachu) other;
		return p.name.equals(this.name) 
				&& p.health == this.health
				&& p.level == this.level
				&& p.power == this.power;
	} // end equals
	
	//***************************************************************************
	
	/**
	 * Deal major damage to an enemy pokemon and consume energy in the process.
	 * 
	 * After dealing damage, this pokemon's power is reduced by the same amount. 
	 * If reducing this pokemon's power would result in a negative value, physical 
	 * attack is used instead. If the remaining power is insufficient for a future 
	 * attack, power is set to 0. 
	 * 
	 * @param target	an enemy pokemon that receives damage from the attack.
	 */
	@Override
	public void specialAttack(Pokemon target) {
		if (power < thunderBolt) {
			physicalAttack(target);
			return;
		}
		target.hurt(thunderBolt);
		power -= thunderBolt;
		if (power < thunderBolt) {
			power = 0;
		}
	} // end specialAttack
	
	//***************************************************************************
	
	/**
	 * Deal damage to an enemy pokemon without consuming any power.
	 * 
	 * @param target	an enemy pokemon that receives damage from the attack.
	 */
	@Override
	public void physicalAttack(Pokemon target) {
		target.hurt(swipe);
	}
} // end class Pikachu
