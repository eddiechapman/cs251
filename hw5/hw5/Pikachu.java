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
			
			else if (power >= thunderBolt) {
				target.hurt(thunderBolt);
				power -= thunderBolt;
			}
			
			else if (power < thunderBolt) {
				target.hurt(power);
				power = 0;
			}
			
		} // end if
		
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
			
		target.hurt(swipe);	
		
	}
	
} // end class Pikachu
