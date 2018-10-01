package CS251_HW4;


public class MovieDriver {

	public static void main(String [] args){

		MovieCollection myMovies = new MovieCollection();

		Movie crazyRichAsians = new Movie("Crazy Rich Asians",120,93);
		Movie oceans8 = new Movie("Oceans 8",110,68);
		Movie happytimeMurders = new Movie("The Happytime Murders",91,22);
		Movie fallout = new Movie("Mission Impossible: Fallout ",147,97);
		Movie slenderMan = new Movie("Slender man",93,7);
		Movie bigSick = new Movie("The Big Sick",119,98);
		Movie mile22 = new Movie("Mile 22",90,22);
		Movie fallenKingdom = new Movie("Jurassic World: Fallen Kingdom",129,49);
		Movie wonderWoman = new Movie("Wonder Woman",141,93);
		Movie goodfellas = new Movie("Goodfellas",146,96);
		Movie quietPlace = new Movie("A Quiet Place", 90, 95);

		myMovies.addMovie(crazyRichAsians);
		myMovies.addMovie(oceans8);
		myMovies.addMovie(happytimeMurders);
		myMovies.addMovie(fallout);
		myMovies.addMovie(slenderMan);
		myMovies.addMovie(bigSick);
		myMovies.addMovie(mile22);


		System.out.println("Total movies: " + myMovies.getTotalMovies());
		myMovies.printOutMovieList();

		System.out.println("Can I add the " + bigSick.getName() + " again?");
		if(myMovies.addMovie(bigSick)){
			System.out.println("It was added.");
		} else {
			System.out.println("No, it is already in your collection.");
		}
		System.out.println();

		System.out.println("Is " + quietPlace.getName() + " in my collection?");
		if(myMovies.findMovie(quietPlace) == -1){
			System.out.println("It is not there.");
		} else {
			System.out.println("It is there.");
		}

		System.out.println();

		System.out.println("Time to remove " + oceans8.getName() + ".");
		if(myMovies.removeMovie(oceans8)){
			System.out.println(oceans8.getName() + " was removed.");
		} else {
			System.out.println(oceans8.getName() + " was not removed.");
		}

		System.out.println();

		System.out.println("Can I remove " + oceans8.getName() + " again?");
		if(myMovies.removeMovie(oceans8)){
			System.out.println("The movie was removed.");
		} else {
			System.out.println("Nope, it was already removed.");
		}

		System.out.println();
		myMovies.printOutMovieList();

		System.out.println("Time to add " + fallenKingdom.getName() + " at the end of collection,\n"
				+ wonderWoman.getName() + " at the beginning,\n"
				+ goodfellas.getName() + " at slot 8, and\n"
				+ "and finally" + quietPlace.getName() + " at the end.");

		myMovies.addMovie(fallenKingdom);
		myMovies.addMovieAt(wonderWoman,0);
		myMovies.addMovieAt(goodfellas, 7);
		myMovies.addMovie(quietPlace);


		System.out.println();
		myMovies.printOutMovieList();

		myMovies.moviesToAvoid();

		System.out.println();
		myMovies.moviesToWatch();

		System.out.println();
		System.out.println("The Best Movie is?");
		System.out.println(myMovies.findBestMovie().getName());

		System.out.println("\nTime to remove the best movie.");
		Movie removedMovieAt = myMovies.removeMovieAt(myMovies.findMovie(myMovies.findBestMovie()));

		if(bigSick.equals(removedMovieAt)) {
			System.out.println("Success, it was removed correctly.");
			myMovies.printOutMovieList();
		} else {
			System.out.println("Nope, wrong movie or no movie was removed.");
		}
		
		System.out.println();

		System.out.println("Can I remove a movie at impossible indexes?");

		if(myMovies.removeMovieAt(-1) == null) {
			System.out.println("Nope, negative indexes do not work.");
		} else {
			System.out.println("Hmmm, something isn't right here. It should be null.");
		}

		if(myMovies.removeMovieAt(10) == null) {
			System.out.println("Nope, index is too large.");
		} else {
			System.out.println("Hmmm, something isn't right here. It should be null.");
		}

	}

}
