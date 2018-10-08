/********************************************************************************
 * testing.java
 * Eddie Chapman
 * 
 * TODO: test description
 *******************************************************************************/

package hw5;

import static org.junit.Assert.*;


import org.junit.*;

public class testing {

	Pokemon a;
	Pokemon b;
	Pokemon c;
	Pokemon d;
	Pokemon e;
	Pokemon f;
	Pokemon g;
	Pokemon h;
	Pokemon i;
	Pokemon j;
	Pokemon k;

	@Before
	public void setUp() {
		a = new Pikachu(-10, -10, -5);
		b = new Charmander(-2, -5, -3);
		c = new Pikachu(10, 50, 2);
		d = new Pikachu(3, 5, 3);
		e = new Charmander(20, 4, 6);
		f = new Charmander(5, 0, 1);
		g = new Charmander(5, 0, 1);
		h = new Pikachu(1, 10, 10);
		i = new Charmander(10, 20, 5);
		j = new Pikachu(100, 8, 10);
		k = new Charmander(100, 7, 5);
	}

	@After
	public void tearDown() {
		a = null;
		b = null;
		c = null;
		d = null;
		e = null;
		f = null;
		g = null;
		h = null;
		i = null;
		j = null;
		k = null;
	}

	@Test
	public void TestConstructorsForPikachu() {

		assertEquals(true, a instanceof Pikachu);
		assertEquals(true, a instanceof Pokemon);
		assertEquals(false, a instanceof Charmander);
		assertEquals(Pikachu.class, a.getClass());

	}

	@Test
	public void TestConstructorsForCharmander() {

		assertEquals(true, b instanceof Charmander);
		assertEquals(true, b instanceof Pokemon);
		assertEquals(false, b instanceof Pikachu);
		assertEquals(Charmander.class, b.getClass());

	}

	@Test
	public void TestInitialFields1() {

		assertEquals(0, a.getHealth());
		assertEquals(0, a.getLevel());
		assertEquals("Pikachu", a.getName());
		assertEquals(0, a.getPower());

	}

	@Test
	public void TestInitialFields2() {

		assertEquals(0, b.getHealth());
		assertEquals(0, b.getPower());
		assertEquals(0, b.getLevel());
		assertEquals("Charmander", b.getName());

	}

	@Test
	public void TestInitialFields3() {

		assertEquals(10, c.getHealth());
		assertEquals(50, c.getPower());
		assertEquals(2, c.getLevel());
		assertEquals("Pikachu", c.getName());

	}

	@Test
	public void TestInitialFields4() {

		assertEquals(3, d.getHealth());
		assertEquals(5, d.getPower());
		assertEquals(3, d.getLevel());
		assertEquals("Pikachu", d.getName());
		;

	}

	
	@Test
	public void TestSetters1() {

		e.setPower(-2);
		assertEquals(4, e.getPower());

		e.setLevel(-10);
		assertEquals(6, e.getLevel());

		e.setHealth(-4);
		assertEquals(20,e.getHealth());
		
		d.specialAttack(e);
		assertEquals(15, e.getHealth());
		assertEquals(0, d.getPower());// d lost power since he attacked e
										
		assertEquals("Charmander", e.getName());
		;

	}

	@Test
	public void TestSetters2() {
		
		d.setPower(-1);
		assertEquals(5, d.getPower());

		d.setLevel(-6);
		assertEquals(3, d.getLevel());
		
		d.setHealth(-10);
		assertEquals(3,d.getHealth());
		
		f.setHealth(5);
		assertEquals(10,f.getHealth());

		f.specialAttack(d);
		assertEquals(0, d.getHealth());
		assertEquals(0, f.getPower());// f lost power since f attacked d 

		assertEquals("Pikachu", d.getName());

	}

	@Test
	public void TestIsDefeated() {
		
		//h = new Pikachu(1, 10, 10);
		//i = new Charmander(10, 20, 5);
		
		assertFalse(h.isDefeated());
		i.specialAttack(h);
		assertTrue(h.isDefeated());
		h.specialAttack(i);
		assertEquals(10, i.getHealth());//h is dead, so it can not attack and should not damage
		assertEquals(10, h.getPower());//h is dead, so h power should be the same
		h.physicalAttack(i);
		assertEquals(10, i.getHealth());//h can not attack
		i.specialAttack(h);
		assertEquals(15, i.getPower());//i can not attack something that is dead, so power should remain
		
	}
	
	
/*	j = new Pikachu(100, 8, 10);
	k = new Charmander(100, 7, 5);*/
	
	@Test
	public void TestAttacks() {
		j.specialAttack(k);
		assertEquals(94, k.getHealth());

		j.specialAttack(k);
		assertEquals(92, k.getHealth());
		
		j.specialAttack(k);
		assertEquals(89, k.getHealth());

		j.physicalAttack(k);
		assertEquals(86, k.getHealth());

		k.specialAttack(j);
		assertEquals(95, j.getHealth());
		
		k.specialAttack(j);
		assertEquals(93, j.getHealth());
		
		k.specialAttack(j);
		assertEquals(89, j.getHealth());

		k.physicalAttack(j);
		assertEquals(85, j.getHealth());
		
		assertEquals(0, j.getPower());
		assertEquals(0, k.getPower());
		
	}
	
	@Test
	public void TestEquals() {
		assertEquals(true, e.equals(e));
		assertEquals(false, e.equals(f));
		assertEquals(false, e.equals(null));
		assertEquals(false, c.equals(f));
		assertEquals(false, e.equals(new Integer(1)));// I am trying to pass an
														// object that is not of
														// type BossRoadTrip
		assertEquals(true, f.equals(g));

	}

	@Test
	public void TestMakePokemon() {

		Pokemon p1 = Driver.makePokemon("Pikachu", 10, 10, 2);

		Pokemon p2 = Driver.makePokemon("Charmander", 5, 7, 3);

		Pokemon p3 = Driver.makePokemon("Whatever", 5, 7, 3);

		assertEquals(Pikachu.class, p1.getClass());
		assertEquals(Charmander.class, p2.getClass());
		assertEquals(true, p3==null);

	}

	@Test
	public void Testexist() {

		Pokemon[] pokemons = { c, d, e };

		boolean arrayContainsC = Driver.contains(c, pokemons);
		boolean arrayContainsD = Driver.contains(d, pokemons);
		boolean arrayContainsE = Driver.contains(e, pokemons);
		boolean arrayContainsF = Driver.contains(f, pokemons);

		assertTrue(arrayContainsC);// check if the Driver.contains(c, pokemons)
									// returned true since c is in the array
		assertTrue(arrayContainsD);// check if the Driver.contains(d, pokemons)
									// returned true since d is in the array
		assertTrue(arrayContainsE);// check if the Driver.contains(e, pokemons)
									// returned true since e is in the array
		assertFalse(arrayContainsF);// check if the Driver.contains(f, pokemons)
									// returned false since f is not in the
									// array

	}

	@Test
	public void TestTostring() {
		String cPokemon = c.toString();
		String fPokemon = f.toString();

		int cName = cPokemon.indexOf("Pikachu");
		int cHealth = cPokemon.indexOf("10");
		int cPower = cPokemon.indexOf("50");
		int cLevel = cPokemon.indexOf("50");

		int fName = fPokemon.indexOf("Charmander");
		int fHealth = fPokemon.indexOf("5");
		int fPower = fPokemon.indexOf("0");
		int fLevel = fPokemon.indexOf("1");

		assertEquals(true, cName != -1);
		assertEquals(true, cHealth != -1);
		assertEquals(true, cPower != -1);
		assertEquals(true, cLevel != -1);

		assertEquals(true, fName != -1);
		assertEquals(true, fHealth != -1);
		assertEquals(true, fPower != -1);
		assertEquals(true, fLevel != -1);

	}

}
