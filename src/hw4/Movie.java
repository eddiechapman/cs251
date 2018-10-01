/********************************************************************************
 * Movie.java
 * Eddie Chapman
 * 
 * TODO: Insert description here
 *******************************************************************************/

package hw4;

public class Movie 
{
	private String name;
	private int minutes;
	private int tomatoScore;

	//***************************************************************************
	
	public Movie(String name, int minutes, int tomatoScore)
	{
		
	}
	
	//***************************************************************************
	
	public String getName()
	{
		return name;
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public int getTomatoScore()
	{
		return tomatoScore;
	}
	
	public void setTomatoScore(int Score)
	{
		tomatoScore = Score;
	}
	
	//***************************************************************************
	
	public boolean isFresh()
	{
		return false;
	}
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		return "";
	}
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		return false;
	}
	
}
