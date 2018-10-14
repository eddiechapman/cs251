/********************************************************************************
 * Pokemon.java
 * Eddie Chapman
 * 
 * Abstract template shared by all Pokemon.
 *******************************************************************************/

package hw5;

public abstract class Pokemon {
	
	protected String name;	
	protected int health;
	protected int power;
	protected int level;
	
	//***************************************************************************
	
	public Pokemon(String name, int health, int power, int level) {
		
		this.name = name;
		this.health = health;
		this.power = power;
		this.level = level;
		
	}
	
	//***************************************************************************
	
	public String getName() {
		
		return name;
		
	}
	
	public int getHealth() {
		
		return health;
		
	}
	
	public void setHealth(int health) {
		
		if (health >= 0) {
			this.health = health;
		}
		
	}
	
	public int getPower() {
		
		return power;
		
	}
	
	public void setPower(int power) {
		
		if (power >= 0) {
			this.power = power;
		}
		
	}
	
	public int getLevel() {
		
		return level;
		
	}
	
	public void setLevel(int level) {
		
		if (level >= 0) {
			this.level = level;	
		}
		
	}
	
	//***************************************************************************
	
	/**
	 * Determine if a pokemon is defeated. A pokemon with 0 health is defeated.
	 * 
	 * @return whether the pokemon is defeated or not defeated
	 */
	public boolean isDefeated() {
		
		return (health > 0) ? true : false;
		
	}
	
	//***************************************************************************
	
	/**
	 * Reduce the pokemon's health by the strength of an incoming attack.
	 * Defeated pokemon cannot be damaged. If health will be reduced below 0, 
	 * it is set to 0.
	 * 
	 * @param the strength of an incoming attack. Cannot be a negative value.
	 */
	protected void hurt(int damage) {
		
		if (damage < 0 || !isDefeated()) {
			return;
		}
		
		if (damage >= health) {
			health = 0;
		}
		
		health -= damage;
		
	} // end hurt
	
	//***************************************************************************
	
	public abstract void specialAttack(Pokemon target);
	
	public abstract void physicalAttack(Pokemon target);
	
} // end class Pokemon