/********************************************************************************
 * MovieCollection.java
 * Eddie Chapman
 * 
 * This class maintains a collection of movie objects.
 *******************************************************************************/

package hw4;

public class MovieCollection 
{
	private Movie[] movies;			// Stores the individual movies
	private int movieCount = 0;		// Current number of movies in the collection

	//***************************************************************************
	
	public MovieCollection()
	{
		movies = new Movie[10];		// Maximum 10 movies per collection
	}

	//***************************************************************************
	
	public int getTotalMovies()
	{
		return movieCount;
	}

	//***************************************************************************
	
	/**
	 * Add the passed in Movie to your collection if there is space for it.
	 * If the movie is added return true.  Else return false.
	 * 
	 * @param movie
	 * @return boolean
	 */
	public boolean addMovie(Movie movie)
	{
		if (movieCount > 9 || findMovie(movie) != -1)
		{
			return false;
		}
		movies[movieCount] = movie;
		movieCount++;
		return true;
	}

	//***************************************************************************
	
	/**
	 * Add a movie at the specifed index if the index is valid.
	 * Return true if movie was added, false otherwise.
	 * 
	 * @param movie
	 * @param index
	 * @return boolean
	 */
	public boolean addMovieAt(Movie movie, int index)
	{
		if (index >= movies.length ||	// Cannot add movie past boundaries of collection
			index < 0 ||					// Cannot add movie at negative index position 
			movieCount > 9 || 			// Movie collection is capped at 10 movies
			findMovie(movie) != -1)		// Movie cannot already be in collection
		{
			return false;
		}
		else
		{
			shiftCollectionRight(index);
			movies[index] = movie;
			movieCount++;
			return true;
		}
	}
	
	//***************************************************************************
	
	/**
	 * Shift all movies to the right based on the index passed in.
	 * 
	 * @param index
	 */
	private void shiftCollectionRight(int index) 
	{
		for (int i=movieCount; i>index; i--)
		{
			movies[i] = movies[i-1];
		}

	}

	//***************************************************************************
	
	/**
	 * Find location of the passed in Movie and return its location in the array.
	 * If the movie is not there, return -1 as a value.
	 * 
	 * @param movie
	 * @return int
	 */
	public int findMovie(Movie movie)
	{
		for (int i=0; i<movieCount; i++)
		{
			if (movies[i].equals(movie))
			{
				return i;
			}
		}
		return -1;
	}

	//***************************************************************************
	
	/**
	 * Get the movie at the specified index and return it.
	 * If the index passed in is invalid, return null.
	 * 
	 * @param index
	 * @return Movie
	 */
	public Movie getMovieAt(int index) 
	{
		if (index >= movieCount || index < 0)
		{
			return null;
		}
		return movies[index];
	}

	//***************************************************************************
	
	/**
	 * Remove the passed in Movie if it is there.
	 * This method returns true if the movie is removed, false otherwise.
	 * 
	 * @param movie
	 * @return boolean
	 */
	public boolean removeMovie(Movie movie)
	{
		if (getMovieAt(findMovie(movie)) == null)
		{
			return false;
		}
		shiftCollectionLeft(findMovie(movie));
		movieCount--;
		return true;
	}

	//***************************************************************************
	
	/**
	 * Remove the Movie at the specified index.
	 * Return the Movie that was at this location, or null if an invalid index was used.
	 * 
	 * @param index
	 * @return Movie
	 */
	public Movie removeMovieAt(int index) 
	{
		if (index >= movieCount || index < 0)
		{
			return null;
		}
		Movie removedMovie = movies[index];
		shiftCollectionLeft(index);
		movieCount--;
		return removedMovie;
		
	}

	//***************************************************************************
	
	/**
	 * Move all elements after the index one location backwards in the array.
	 * 
	 * @param index
	 */
	private void shiftCollectionLeft(int index)
	{
		for (int i=index; i<movieCount; i++)
		{
			if (i == (movieCount - 1))  // Prevent index error in full array
			{
				movies[i] = null;
				break;
			}
			movies[i] = movies[i+1];
		}
	}

	//***************************************************************************
	
	/**
	 * Find the best movie according to Rotten Tomato score and return it.
	 * If the array is empty, meaning there are no movies, it returns null.
	 * 
	 * @return Movie or null
	 */
	public Movie findBestMovie()
	{
		Movie bestMovie = null;
		for (int i=0; i<movieCount; i++)
		{
			
			if (movies[i] == null)
			{
				continue;	// Skip null movies
			}
			else if (bestMovie == null || // Initialize bestMovie
					bestMovie.getTomatoScore() < movies[i].getTomatoScore())
			{
				bestMovie = movies[i];
			}
		}
		return bestMovie;
	}

	//***************************************************************************
	
	 // Print out all movies that are considered rotten in the array.

	public void moviesToAvoid()
	{
		int badMovieCount = 0;
		System.out.println("\nMovies to avoid:");
		for (int i=0; i<movieCount; i++)
		{
			if (!(movies[i].isFresh()))
			{
				badMovieCount++;
				System.out.println("Movie " + badMovieCount + ":");
				System.out.println(movies[i].toString());
				System.out.println("Tomato Rating: Rotten");
			}
		}
	} // end moviesToAvoid

	//***************************************************************************
	
	// Print out all movies that are considered fresh in the array

	public void moviesToWatch()
	{
		int goodMovieCount = 1;
		System.out.println("\nMovies to watch:");
		for (int i=0; i<movieCount; i++)
		{
			if (movies[i].isFresh())
			{
				goodMovieCount++;
				System.out.println("Movie " + goodMovieCount + ":");
				System.out.println(movies[i].toString());
				System.out.println("Tomato Rating: Fresh");
			}
		}
	} // end moviesToWatch

	//***************************************************************************

	// Print out all movies in the array.

	public void printOutMovieList()
	{
		System.out.println("\nAll of my movies:");
		for (int i=0; i<movieCount; i++)
		{
			System.out.println("Movie" + (i + 1) + ": " + movies[i].getName());
		}
	}

}
