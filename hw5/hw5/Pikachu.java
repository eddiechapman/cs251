/********************************************************************************
 * Pikachu.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public class Pikachu extends Pokemon 
{
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
		return "Name: " + name +
				"\nLevel: " + level +
				"\nHealth: " + health +
				"\nPower: " + power;
	} // end toString
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (!(other instanceof Pikachu))
		{
			return false;
		}
		Pikachu p = (Pikachu) other;
		return p.name.equals(this.name) && 
				p.health == this.health &&
				p.level == this.level &&
				p.power == this.power;
	} // end equals
	
	//***************************************************************************
	
	@Override
	public void specialAttack(Pokemon target)
	{
		// Call physical attack instead when power is insufficient for thunderBolt
		if (power < thunderBolt) 
		{
			physicalAttack(target);
			return;
		}
		
		target.hurt(thunderBolt);
		power -= thunderBolt;
		
		// Deplete power when remainder is insufficient for another attack
		if (power < thunderBolt) 
		{
			power = 0;
		}
	} // end specialAttack
	
	//***************************************************************************
	
	@Override
	public void physicalAttack(Pokemon target)
	{
		target.hurt(swipe);
	}
} // end class Pikachu
