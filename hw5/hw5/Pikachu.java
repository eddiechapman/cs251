/********************************************************************************
 * Pikachu.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

import hw4.Movie;

public class Pikachu extends Pokemon {

	private final static int thunderBolt = 6;
	private final static int swipe = 3;
	
	//***************************************************************************
	
	public Pikachu(int health, int power, int level)
	{
		super("Pikachu", health, power, level);
	}
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		return "Type: " + this.getClass() +
				"\nName: " + name +
				"\nLevel: " + level +
				"\nHealth: " + health +
				"\nPower: " + power;
	} // end toString
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		Pikachu pikachu = null;	// Temporary pikachu object for comparison
		
		if (other == this)
		{
			return true;
		}
		if (!(other instanceof Pikachu))
		{
			return false;
		}
		pikachu = (Pikachu) other;
		return pikachu.name.equals(this.name) && 
				pikachu.health == this.health &&
				pikachu.level == this.level &&
				pikachu.power == this.power;
	} // end equals
	
	//***************************************************************************
	
	@Override
	public void specialAttack(Pokemon target)
	{
		if (power >= thunderBolt)
		{
			target.hurt(thunderBolt);
			power -= thunderBolt;
			if (power > thunderBolt)	
			{
				power = 0;			// Deplete power when remainder is insufficient for another attack
			}
		}
		else if (power < thunderBolt) 	// Call physical attack instead when power is insufficient for thunderBolt
		{
			physicalAttack(target);
		}	
	} // end specialAttack
	
	//***************************************************************************
	
	@Override
	public void physicalAttack(Pokemon target)
	{
		target.hurt(swipe);
	}
} // end class Pikachu
