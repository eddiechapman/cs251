
public class MovieCollection {


	/**
	 * An array that holds your movies.  You are only allowed to hold 10 movies.
	 */
	private Movie[] movies;


	/**
	 * movieCount tells the total movies in your array and what index to add the next movie to.
	 */
	private int movieCount;


	/**
	 * Constructor.
	 * You are only allowed to hold 10 movies. 
	 * Initialize the array.
	 */
	public MovieCollection(){
		movies = new Movie[10];
		movieCount = 0;
	}


	/**
	 * Return the total number of movies.
	 * @return int
	 */
	public int getTotalMovies(){
		return movieCount;
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
		if(movieCount < movies.length && findMovie(movie) == -1){
			movies[movieCount++] = movie;
			return true;
		}
		return false;
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

		if(index >= 0 && index <= movieCount && movieCount < 10 && findMovie(movie) == -1){
			shiftCollectionRight(index);
			movies[index] = movie;
			movieCount++;
			return true;
		}
		return false;
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
		for(int i = movieCount; i > index; i--){
			movies[i] = movies[i-1];
		}
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
		for(int i = 0; i < movieCount; i++){
			if(movies[i].equals(movie)){
				return i;
			}
		}
		return -1;
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
		
		if(index >= movieCount || index < 0) {
			return null;
		}
		
		return movies[index];
		
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
		int index = findMovie(movie);
		if(index != -1){
			shiftCollectionLeft(index);
			return true;
		}
		return false;
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

		if(index >= movieCount || index < 0) {
			return null;
		}

		Movie movieToReturn = movies[index];
		shiftCollectionLeft(index);
		return movieToReturn;
		
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
		for(int i = index; i < movieCount-1; i++){
			movies[i] = movies[i+1];
		}
		--movieCount;
	}

	/**
	 * Find the best movie according to Rotten Tomato score and return it.
	 * If the array is empty, meaning there are no movies, it returns null.
	 * 
	 * @return Movie or null
	 */
	public Movie findBestMovie() {
		if (movieCount == 0){
			return null;
		} else {
			Movie favorite = movies[0];
			for(int i = 0; i < movieCount; i++) {
				if (favorite.getTomatoScore() < movies[i].getTomatoScore()) {
					favorite = movies[i];
				}
			}
			return favorite;
		}
	}

	/**
	 * Print out all movies that are considered rotten in the array.
	 * Remember you can use methods in the Movie class to determine this.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void moviesToAvoid(){
		int counter = 1;
		System.out.println("Movies to avoid: ");
		for(int i = 0; i < movieCount; i++){
			if(!movies[i].isFresh()){
				System.out.println("Movie " + counter++ + ": ");
				System.out.println(movies[i]);
				System.out.println();
			}
		}
	}


	/**
	 * Print out all movies that are considered fresh in the array.
	 * Remember you can use methods in the Movie class to determine this.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void moviesToWatch(){
		int counter = 1;
		System.out.println("Movies to watch: ");
		for(int i = 0; i < movieCount; i++){
			if(movies[i].isFresh()){
				System.out.println("Movie " + counter++ + ": ");
				System.out.println(movies[i]);
				System.out.println();
			}
		}
	}

	/**
	 * Print out all movies in the array.
	 * You only need to print out the name of the movie, nothing more.
	 * Refer to driver and handout for output format.
	 * 
	 */
	public void printOutMovieList(){
		System.out.println("All of my movies: ");
		for(int i = 0; i < movieCount; i++){
			System.out.println("Movie " + (i+1) + ": " + movies[i].getName());
		}
		System.out.println();
	}


	
	/**
	 * Sort movies by name going from A-Z.
	 * You may use any method you like to compare Strings to help sort.
	 * Use Selection Sort for this method.
	 */
	public void sortByName() 
	{
		int n = movieCount;
		int min;
		Movie temp;
		
		for (int i=0; i<n-1; i++) {
			min = i;
			for (int j=i+1; j<n; j++) {
				if (movies[j].compareTitle(movies[min]) < 0) {
					min = j;
				}
			}
			temp = movies[min];
			movies[min] = movies[i];
			movies[i] = temp;
		}
	} // end sortByName

	
	/**
	 * Sort movies by tomato score from best to worst.
	 * Use Insertion Sort for this method.
	 */
	public void sortByTomatoScore() {

		Movie movieToInsert;
		int j;
		
		for (int i=1; i<movieCount; i++) {
			movieToInsert = movies[i];
			for (j=i; (j>0) && (movieToInsert.getTomatoScore()>movies[j-1].getTomatoScore()); j--) {
				movies[j] = movies[j-1];
			}
			movies[j] = movieToInsert;
		}
	} // end sortByTomatoScore
	
	
	/**
	 * Sort movies by runtime, ie their length, from shortest to longest.
	 * Use either sorting method for this method.
	 */
	public void sortByLength() {

		Movie movieToInsert;
		int j;
		
		for (int i=1; i<movieCount; i++) {
			movieToInsert = movies[i];
			for (j=i; (j>0) && (movieToInsert.getMinutes()<movies[j-1].getMinutes()); j--) {
				movies[j] = movies[j-1];
			}
			movies[j] = movieToInsert;
		}
		
	} // end sortByLength
	
}
