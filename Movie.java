

public class Movie {

	private String name;
	private int minutes;
	private int tomatoScore;

	public Movie(String name, int minutes){
		this(name, minutes, 0);
	}

	public Movie(String name, int minutes, int tomatoScore){

		this.name = name;
		this.minutes = minutes;
		this.tomatoScore = tomatoScore;

	}

	public int getMinutes(){
		return this.minutes;
	}

	public String getName(){
		return this.name;
	}

	public int getTomatoScore(){
		return this.tomatoScore;
	}

	public void setTomatoScore(int score){
		if(score >= 0 && score <= 100){
			this.tomatoScore = score;
		}
	}

	public boolean isFresh(){
		return this.tomatoScore >= 60;
	}
	

	private String convertMinutes(){
		return "" + (this.minutes/60) + "hrs " + (this.minutes%60) + "min";
	}
	
	
	public int compareTitle(Movie movie) {
		return this.getName().compareTo(movie.getName());
	}
	
	@Override
	public boolean equals(Object other){
		if (other instanceof Movie){
			Movie tmp = (Movie)other;
			return tmp.name.equals(this.name) && tmp.minutes == this.minutes && tmp.tomatoScore == this.tomatoScore;
		}
		return false;
	}

	@Override
	public String toString(){
		return "Name: " + this.name + "\nLength : " + convertMinutes() + 
				"\nTomato Rating : " + (isFresh() ? "Fresh" : "Rotten");
	}

}
