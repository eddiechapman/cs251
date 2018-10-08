/********************************************************************************
 * Charmander.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public class Charmander extends Pokemon {

	private final static int fireBall = 5;
	private final static int bite = 4;
	
	//***************************************************************************
	
	public Charmander(int health, int power, int level)
	{
		super("Charmander", health, power, level);
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
		Charmander charmander = null;	// Temporary charmander object for comparison
		
		if (other == this)
		{
			return true;
		}
		if (!(other instanceof Charmander))
		{
			return false;
		}
		charmander = (Charmander) other;
		return charmander.name.equals(this.name) && 
				charmander.health == this.health && 
				charmander.level == this.level &&
				charmander.power == this.power;
	} // end equals
	
	//***************************************************************************
	
	@Override
	public void specialAttack(Pokemon target)
	{
		if (power >= fireBall)
		{
			target.hurt(fireBall);
			power -= fireBall;
			if (power > fireBall)	
			{
				power = 0;			// Deplete power when remainder is insufficient for another attack
			}
		}
		else if (power < fireBall) 	// Call physical attack instead when power is insufficient for fireBall
		{
			physicalAttack(target);
		}	
	} // end specialAttack
	
	//***************************************************************************
	
	@Override
	public void physicalAttack(Pokemon target)
	{
		target.hurt(bite);
	}
} // end class Pikachu
