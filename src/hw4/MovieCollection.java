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
	
	// Add the passed in Movie to your collection if there is space for it.
	// If the movie is added return true.  Else return false.

	public boolean addMovie(Movie movie)
	{
		if (movieCount > 9 || 				// No room for new movies
				findMovie(movie) != -1)		// Movie is already in collection
		{
			return false;
		}
		movies[movieCount] = movie;
		movieCount++;
		return true;
	} // end addMovie

	//***************************************************************************

	// Add a movie at the specified index if the index is valid.
	// Returns true if the movie was added, or else false.
	
	public boolean addMovieAt(Movie movie, int index)
	{
		if (index >= movies.length ||		// Index exceeds array boundaries
				index < 0 || 					// Index exceeds array boundaries
				movieCount > 9 || 			// No room for new movies
				findMovie(movie) != -1)		// Movie is already in collection
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
	} // end addMovieAt
	
	//***************************************************************************

	// Shift all movies to the right based on the index passed in.

	private void shiftCollectionRight(int index) 
	{
		for (int i=movieCount; i>index; i--)
		{
			movies[i] = movies[i-1];
		}

	}

	//***************************************************************************
	
	// Find location of the passed in Movie and return its location in the array.
	// If the movie is not there, return -1 as a value.

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
	} // end findMovie

	//***************************************************************************
	
	// Get the movie at the specified index and return it.
	// Return null for invalid index arguments.

	public Movie getMovieAt(int index) 
	{
		if (index >= movieCount || 	// Index exceeds filled portion of array
				index < 0)				// Index exceeds array boundaries
		{
			return null;
		}
		return movies[index];
	}

	//***************************************************************************
	
	// Remove the passed in Movie. 
	// Return true if the removal is successful, or false if not.

	public boolean removeMovie(Movie movie)
	{
		if (getMovieAt(findMovie(movie)) == null)	// Movie not present
		{
			return false;
		}
		shiftCollectionLeft(findMovie(movie));
		movieCount--;
		return true;
	} // end removeMovie

	//***************************************************************************
	
	// Remove the Movie at the specified index.
	// Returns the movie if present, or null if not.

	public Movie removeMovieAt(int index) 
	{
		Movie removedMovie = null;
		
		if (index >= movieCount || 	// Index exceeds filled portion of array
				index < 0)				// Index exceeds array boundaries
		{
			return null;
		}
		removedMovie = movies[index];
		shiftCollectionLeft(index);
		movieCount--;
		return removedMovie;
	} // end removeMovieAt

	//***************************************************************************
	
	// Move all array elements past the index position backwards.

	private void shiftCollectionLeft(int index)
	{
		for (int i=index; i<movieCount; i++)
		{
			// Final movie is made null rather than copied from next position
			if (i == (movieCount - 1))
			{
				movies[i] = null;
				break;
			}
			movies[i] = movies[i+1];
		}
	} // end shiftCollectionLeft

	//***************************************************************************
	
 	// Return the movie with the highest tomato score.
	// Returns null if there are no movies in the collection.

	public Movie findBestMovie()
	{
		Movie bestMovie = null;
		
		for (int i=0; i<movieCount; i++)
		{
			if (movies[i] == null)			
			{
				continue;	
			}
			else if (bestMovie == null ||  // Initialize bestMovie if necessary
					bestMovie.getTomatoScore() < movies[i].getTomatoScore())
			{
				bestMovie = movies[i];
			}
		}
		return bestMovie;
	} // end findBestMovie

	//***************************************************************************
	
	 // Print out all movies that are considered rotten in the array.

	public void moviesToAvoid()
	{
		int badMovieCount = 0;	// Count "fresh" movies during collection iteration
		
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
	
	// Print out all movies that are considered fresh in the array.

	public void moviesToWatch()
	{
		int goodMovieCount = 0;	// Count "rotten" movies during collection iteration
		
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
} // end class MovieCollection
