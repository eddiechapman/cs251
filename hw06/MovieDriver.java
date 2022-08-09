

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
		Movie wonderWoman = new Movie("wonder Woman",141,93);
		Movie goodfellas = new Movie("Goodfellas",146,96);

		myMovies.addMovie(crazyRichAsians);
		myMovies.addMovie(oceans8);
		myMovies.addMovie(happytimeMurders);
		myMovies.addMovie(fallout);
		myMovies.addMovie(slenderMan);
		myMovies.addMovie(bigSick);
		myMovies.addMovie(mile22);
		myMovies.addMovie(fallenKingdom);
		myMovies.addMovie(wonderWoman);
		myMovies.addMovie(goodfellas);

		System.out.println("Total movies: " + myMovies.getTotalMovies());
		myMovies.printOutMovieList();

		System.out.println();
		System.out.println("Total movies sorted by name: " + myMovies.getTotalMovies());
		myMovies.sortByName();
		myMovies.printOutMovieList();
		
		System.out.println();
		System.out.println("Total movies sorted by score: " + myMovies.getTotalMovies());
		myMovies.sortByTomatoScore();
		myMovies.printOutMovieList();
		
		System.out.println();
		System.out.println("Total movies sorted by length: " + myMovies.getTotalMovies());
		myMovies.sortByLength();
		myMovies.printOutMovieList();

	}

}
