package CS251_HW4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit {

	MovieCollection a;
	MovieCollection b;
	MovieCollection c;
	MovieCollection d;
	MovieCollection e;
	MovieCollection f;
	
	@Before
	public void setUp() {
		a = new MovieCollection();
		b = new MovieCollection();
		c = new MovieCollection();
		d = new MovieCollection();
		e = new MovieCollection();
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
	Movie wonderWoman = new Movie("wonder Woman",141,93);
	Movie goodfellas = new Movie("Goodfellas",146,96);
	Movie quietPlace = new Movie("A Quiet Place", 90, 95);
	
	@After
	public void tearDown(){
		a = null;
		b = null;
		c = null;
		d = null;
		e = null;
		f = null;
	}
	
	
	@Test
	public void testAddMovie() {
		assertEquals(true, a.addMovie(crazyRichAsians));
		assertEquals(false, a.addMovie(crazyRichAsians));
		assertEquals(true, a.addMovie(oceans8));
		assertEquals(true, a.addMovie(happytimeMurders));
		assertEquals(true, a.addMovie(fallout));
		
		assertEquals(4, a.getTotalMovies());
		
		assertEquals(true, a.addMovie(slenderMan));
		assertEquals(true, a.addMovie(bigSick));
		assertEquals(true, a.addMovie(mile22));
		assertEquals(false, a.addMovie(slenderMan));
		assertEquals(true, a.addMovie(fallenKingdom));
		assertEquals(true, a.addMovie(wonderWoman));
		assertEquals(true, a.addMovie(goodfellas));
		assertEquals(false, a.addMovie(quietPlace));
		
		assertEquals(10, a.getTotalMovies());

	}
	
	@Test
	public void testFindMovieAndGetMovieAt(){
		
		b.addMovie(crazyRichAsians);
		b.addMovie(oceans8);
		b.addMovie(happytimeMurders);
		b.addMovie(fallout);
		b.addMovie(slenderMan);
		b.addMovie(bigSick);
		b.addMovie(mile22);
		b.addMovie(fallenKingdom);
		b.addMovie(wonderWoman);
		b.addMovie(goodfellas);

		assertEquals(0, b.findMovie(crazyRichAsians));
		assertEquals(1, b.findMovie(oceans8));
		assertEquals(2, b.findMovie(happytimeMurders));
		assertEquals(3, b.findMovie(fallout));
		assertEquals(4, b.findMovie(slenderMan));
		assertEquals(5, b.findMovie(bigSick));
		assertEquals(6, b.findMovie(mile22));
		assertEquals(7, b.findMovie(fallenKingdom));
		assertEquals(8, b.findMovie(wonderWoman));
		assertEquals(9, b.findMovie(goodfellas));
		assertEquals(-1, b.findMovie(quietPlace));
		assertEquals(10, b.getTotalMovies());
		
		Movie tmpMovie = b.getMovieAt(1);
		assertTrue(oceans8.equals(tmpMovie));
		
		tmpMovie = b.getMovieAt(10);
		assertTrue(tmpMovie == null);
		
		tmpMovie = b.getMovieAt(6);
		assertTrue(mile22.equals(tmpMovie));
		
		tmpMovie = b.getMovieAt(-1);
		assertTrue(tmpMovie == null);
		
		
	}
	
	@Test
	public void testAddMovieAt(){
		
		c.addMovie(crazyRichAsians);
		c.addMovie(oceans8);
		c.addMovie(slenderMan);
		c.addMovie(goodfellas);
		
		assertFalse(c.addMovieAt(crazyRichAsians, 3));
		assertFalse(c.addMovieAt(bigSick, -1));
		assertFalse(c.addMovieAt(bigSick, 5));
		
		assertTrue(c.addMovieAt(happytimeMurders, 1));
		assertTrue(happytimeMurders.equals(c.getMovieAt(1)));
		
		assertTrue(c.addMovieAt(mile22, 1));
		assertTrue(mile22.equals(c.getMovieAt(1)));
		
		assertEquals(6,c.getTotalMovies());
		
		assertTrue(c.addMovieAt(wonderWoman, 1));
		assertTrue(wonderWoman.equals(c.getMovieAt(1)));
		
		assertTrue(c.addMovieAt(fallout, 0));
		assertTrue(fallout.equals(c.getMovieAt(0)));
		
		assertEquals(8,c.getTotalMovies());
		
		assertTrue(c.addMovieAt(bigSick, 6));
		assertTrue(bigSick.equals(c.getMovieAt(6)));
		
		assertTrue(c.addMovieAt(fallenKingdom, 9));
		assertTrue(fallenKingdom.equals(c.getMovieAt(9)));
		
		assertTrue(fallout.equals(c.getMovieAt(0)));
		assertTrue(crazyRichAsians.equals(c.getMovieAt(1)));
		assertTrue(wonderWoman.equals(c.getMovieAt(2)));
		assertTrue(mile22.equals(c.getMovieAt(3)));
		assertTrue(happytimeMurders.equals(c.getMovieAt(4)));
		assertTrue(oceans8.equals(c.getMovieAt(5)));
		assertTrue(bigSick.equals(c.getMovieAt(6)));
		assertTrue(slenderMan.equals(c.getMovieAt(7)));
		assertTrue(goodfellas.equals(c.getMovieAt(8)));
		assertTrue(fallenKingdom.equals(c.getMovieAt(9)));

		assertFalse(c.addMovieAt(bigSick, 5));
		assertFalse(c.addMovieAt(fallenKingdom, 5));

		
		assertEquals(10,c.getTotalMovies());

	}
	
	
	@Test
	public void testRemoveMovie(){
		
		d.addMovie(slenderMan);
		d.addMovie(bigSick);
		d.addMovie(mile22);
		d.addMovie(fallenKingdom);
		
		assertEquals(4,d.getTotalMovies());
		assertEquals(true, d.removeMovie(bigSick));
		assertEquals(3,d.getTotalMovies());
		assertEquals(false, d.removeMovie(bigSick));
		assertEquals(true, d.removeMovie(fallenKingdom));
		assertEquals(2, d.getTotalMovies());
		assertEquals(true, d.removeMovie(slenderMan));
		assertEquals(true, d.removeMovie(mile22));
		assertEquals(0, d.getTotalMovies());
		assertEquals(false, d.removeMovie(mile22));
		
	}
	
	@Test
	public void testRemoveMovieAT(){
		
		f.addMovie(slenderMan);
		f.addMovie(bigSick);
		f.addMovie(goodfellas);
		
		assertEquals(null, f.removeMovieAt(-1));
		assertEquals(null, f.removeMovieAt(3));
		assertTrue(slenderMan.equals(f.removeMovieAt(0)));
		assertTrue(goodfellas.equals(f.removeMovieAt(1)));
		assertTrue(bigSick.equals(f.removeMovieAt(0)));
		
		assertEquals(0,f.getTotalMovies());

		
	}
	
	@Test
	public void testFindBestMovie(){
		
		e.addMovie(crazyRichAsians);
		e.addMovie(oceans8);
		e.addMovie(happytimeMurders);
		
		assertEquals(3, e.getTotalMovies());
		assertTrue(crazyRichAsians.equals(e.findBestMovie()));
		
		e.addMovie(fallout);
		
		assertEquals(4, e.getTotalMovies());
		assertTrue(fallout.equals(e.findBestMovie()));
		
		e.addMovie(slenderMan);
		
		assertEquals(5, e.getTotalMovies());
		assertTrue(fallout.equals(e.findBestMovie()));
		
		e.addMovie(bigSick);
		
		assertEquals(6, e.getTotalMovies());
		assertTrue(bigSick.equals(e.findBestMovie()));
		
		e.removeMovie(bigSick);
		
		assertEquals(5, e.getTotalMovies());
		assertTrue(fallout.equals(e.findBestMovie()));

	}
	

}
