/********************************************************************************
 * Pikachu.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public class Pikachu extends Pokemon {

	private final int thunderBolt = 6;
	private final int swipe = 3;
	
	//***************************************************************************
	
	public Pikachu(int health, int power, int level)
	{
		//TODO
	} // end Pikachu
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		//TODO
	} // end toString
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		//TODO
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
		else if (power < thunderBolt) 	// Call physical attack instead when power is insufficient for fireBall
		{
			physicalAttack(target);
		}	
	} // end specialAttack
	
	//***************************************************************************
	
	@Override
	public void physicalAttack(Pokemon target)
	{
		//TODO
	} // end physicalAttack
} // end class Pikachu
