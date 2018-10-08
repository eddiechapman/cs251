/********************************************************************************
 * Pokemon.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public abstract class Pokemon {
	
	protected String name;
	protected int health;
	protected int power;
	protected int level;
	
	//***************************************************************************
	
	public Pokemon(String name, int health, int power, int level)
	{
		//TODO
	} // end Pokemon
	
	//***************************************************************************
	
	public String getName()
	{
		return name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getPower()
	{
		return power;
	}
	
	public void setPower(int power)
	{
		this.power = power;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	//***************************************************************************
	
	public boolean isDefeated()
	{
		//TODO
	} // end isDefeated
	
	//***************************************************************************
	
	protected void hurt(int damage)
	{
		//TODO
	} // end hurt
} // end class Pokemon