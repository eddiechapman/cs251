package CS251_HW4;

public class MovieCollection {

	//TODO
	//Instance Variables

	/**
	 * Constructor.
	 * You are only allowed to hold 10 movies. 
	 * Initialize the array.
	 */
	public MovieCollection(){

		//TODO

	}


	/**
	 * Return the total number of movies.
	 * @return int
	 */
	public int getTotalMovies(){
		
		//TODO
		
	}


	/**
	 * Add the passed in Movie to your collection if there is space for it.
	 * You are not allowed duplicate copies of a movie in the array.
	 * Make sure to check movieCount to make sure it can be added.
	 * If the movie is added return true.  Else return false.
	 * 
	 * @param movie
	 * @return boolean
	 */
	public boolean addMovie(Movie movie){
		
		//TODO
		
	}


	/**
	 * Add a movie at the specifed index if the index is valid.
	 * You must verify the index.  Remember, no duplicate movies are allowed.
	 * You will need to shift all your movies to the right to make room for the new movie.
	 * Return true if movie was added, false otherwise.
	 * 
	 * @param movie
	 * @param index
	 * @return boolean
	 */
	public boolean addMovieAt(Movie movie, int index){

		//TODO
		
	}

	/**
	 * Shift all movies to the right based on the index passed in.
	 * This will create 'space' for a new movie to be added.
	 * Should only be called by addMovieAt().
	 * Private methods of a class are considered helper methods.
	 * 
	 * @param index
	 */
	private void shiftCollectionRight(int index) {
		
		//TODO
		
	}

	/**
	 * Find location of the passed in Movie and return its location in the array.
	 * This means a value from [0, movieCount) could be returned if it is in the array.
	 * If the movie is not there, return -1 as a value.
	 * To compare movies, you only need to compare the name and runtime.
	 * Remember, you can use methods in Movie class to easily compare two movies now.
	 * 
	 * @param movie
	 * @return boolean
	 */
	public int findMovie(Movie movie){
		
		//TODO
		
	}


	/**
	 * Get the movie at the specified index and return it.
	 * If the index passed in is invalid, return null.
	 * No shifting required.
	 * 
	 * @param index
	 * @return Movie
	 */
	public Movie getMovieAt(int index) {

		//TODO

	}


	/**
	 * Remove the passed in Movie if it is there.
	 * If the movie is there, you will need to "shift" the array backwards one location to "remove" the movie.
	 * Remember, no null spaces are allowed in the array.
	 * You will need to call shiftCollectionLeft if you remove a movie.
	 * This method returns true if the movie is removed, false otherwise.
	 * 
	 * @param movie
	 * @return boolean
	 */
	public boolean removeMovie(Movie movie){
		
		//TODO
		
	}


	/**
	 * Remove the Movie at the specified index.
	 * Make sure the index is a valid index.
	 * You will need to call shiftCollectionLeft to remove the movie.
	 * Return the Movie that was at this location, or null if an invalid index was used.
	 * 
	 * @param index
	 * @return Movie
	 */
	public Movie removeMovieAt(int index) {

		//TODO

	}

	/**
	 * Move all elements after the index one location backwards in the array.
	 * This method is meant to be called by removeMovie() and removeMovieAt() and is private.
	 * Private methods of a class are considered helper methods.
	 * The parameter index is meant to be the location of the element to be removed.
	 * 
	 * @param index
	 */
	private void shiftCollectionLeft(int index){
		
		//TODO
		
	}

	/**
	 * Find the best movie according to Rotten Tomato score and return it.
	 * If the array is empty, meaning there are no movies, it returns null.
	 * 
	 * @return Movie or null
	 */
	public Movie findBestMovie(){
		
		//TODO
		
	}

	/**
	 * Print out all movies that are considered rotten in the array.
	 * Remember you can use methods in the Movie class to determine this.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void moviesToAvoid(){
		
		//TODO
		
	}


	/**
	 * Print out all movies that are considered fresh in the array.
	 * Remember you can use methods in the Movie class to determine this.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void moviesToWatch(){

		//TODO
		
	}

	/**
	 * Print out all movies in the array.
	 * You only need to print out the name of the movie, nothing more.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void printOutMovieList(){
		
		//TODO
		
	}

}
