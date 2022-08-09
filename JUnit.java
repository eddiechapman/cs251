
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JUnit {

	MovieCollection f;
	
	@Before
	public void setUp() {
		f = new MovieCollection();
	}

	Movie crazyRichAsians = new Movie("Crazy Rich Asians",120,93);
	Movie oceans8 = new Movie("Oceans 8",110,68);
	Movie happytimeMurders = new Movie("The Happytime Murders",91,22);
	Movie fallout = new Movie("Mission Impossible: Fallout",147,97);
	Movie slenderMan = new Movie("Slender man",93,7);
	Movie bigSick = new Movie("The Big Sick",119,98);
	Movie mile22 = new Movie("Mile 22",90,22);
	Movie fallenKingdom = new Movie("Jurassic World: Fallen Kingdom",129,49);
	Movie wonderWoman = new Movie("Wonder Woman",141,93);
	Movie goodfellas = new Movie("Goodfellas",146,96);
	Movie quietPlace = new Movie("A Quiet Place", 90, 95);
	
	@After
	public void tearDown(){
		f = null;
	}
	
	@Test
	public void testSorting() {

		f.addMovie(bigSick);
		f.addMovie(fallout);
		f.addMovie(oceans8);
		f.addMovie(quietPlace);
		f.addMovie(wonderWoman);
		
		f.sortByLength();
		
		assertEquals(0, f.findMovie(quietPlace));
		assertEquals(1, f.findMovie(oceans8));
		assertEquals(2, f.findMovie(bigSick));
		assertEquals(3, f.findMovie(wonderWoman));
		assertEquals(4, f.findMovie(fallout));
		
		f.sortByName();

		assertEquals(0, f.findMovie(quietPlace));
		assertEquals(1, f.findMovie(fallout));
		assertEquals(2, f.findMovie(oceans8));
		assertEquals(3, f.findMovie(bigSick));
		assertEquals(4, f.findMovie(wonderWoman));
		
		f.addMovie(goodfellas);
		f.addMovie(slenderMan);
		
		f.sortByTomatoScore();

		assertEquals(0, f.findMovie(bigSick));
		assertEquals(1, f.findMovie(fallout));
		assertEquals(2, f.findMovie(goodfellas));		
		assertEquals(3, f.findMovie(quietPlace));
		assertEquals(4, f.findMovie(wonderWoman));
		assertEquals(5, f.findMovie(oceans8));
		assertEquals(6, f.findMovie(slenderMan));
		
	}

}
