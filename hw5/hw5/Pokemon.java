/********************************************************************************
 * Pokemon.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public abstract class Pokemon 
{
	protected String name;
	protected int health;
	protected int power;
	protected int level;
	
	//***************************************************************************
	
	public Pokemon(String name, int health, int power, int level)
	{
		this.name = name;
		this.health = health;
		this.power = power;
		this.level = level;
	}
	
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
		if (health > 0) 
		{
			this.health = health;
		}
	}
	
	public int getPower()
	{
		return power;
	}
	
	public void setPower(int power)
	{
		if (power > 0) 
		{
			this.power = power;
		}
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		if (level > 0)
		{
			this.level = level;	
		}
	}
	
	//***************************************************************************
	
	public boolean isDefeated()
	{
		return (health > 0) ? true : false;
	}
	
	//***************************************************************************
	
	protected void hurt(int damage)
	{
		if (damage < 0 || !isDefeated())
		{
			return;
		}
		if (damage >= health) 
		{
			health = 0;
		}
		health -= damage;
	} // end hurt
	
	//***************************************************************************
	
	public abstract void specialAttack(Pokemon target);
	
	public abstract void physicalAttack(Pokemon target);
	
} // end class Pokemon