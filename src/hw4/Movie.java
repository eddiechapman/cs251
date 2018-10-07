/********************************************************************************
 * Movie.java
 * Eddie Chapman
 * 
 * This class represents an individual movie.
 *******************************************************************************/

package hw4;

public class Movie 
{
	private String name;		// The movie's name
	private int minutes;		// The movie's duration in minutes
	private int tomatoScore;	// The movie's Rotten Tomato "freshness rating"

	//***************************************************************************
	
	public Movie(String name, int minutes, int tomatoScore)
	{
		this.name = name;
		this.minutes = minutes;
		this.tomatoScore = tomatoScore;
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
		if (Score >= 0 && Score <= 100)	// Score must be between 0-100
		{
			tomatoScore = Score;
		}
	}
	
	//***************************************************************************
	
	// Determine if a movie is well-reviewed based on it's tomato score
	
	public boolean isFresh()
	{
		return 60 <= getTomatoScore();
	}
	
	//***************************************************************************
	
	// Convert an amount of minutes to a more readable string with hours and minutes
	
	private String minutesToHours(int minutes) 
	{
		String hrs = Integer.toString(minutes / 60);
		String min = Integer.toString(minutes % 60);
		
		return hrs + "hrs" + " " + min + "min";
	}
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		return "Name: " + name + "\n\t" +
				"Length: " + minutesToHours(minutes);
	}
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		Movie movie = null;	// Temporary movie object for comparison
		
		if (other == this)
		{
			return true;
		}
		if (!(other instanceof Movie))
		{
			return false;
		}
		movie = (Movie) other;
		return movie.name.equals(this.name) && 
				movie.minutes == this.minutes;
	} // end equals
} // end class Movie
