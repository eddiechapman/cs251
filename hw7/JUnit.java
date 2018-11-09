
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JUnit {

	ArrayList<Integer> arr1;	//arr1 = {-3,-2,-1,0,1,2,3}
	ArrayList<Integer> arr2;	//arr2 = {0,2,4,6,8}
	ArrayList<Integer> arr3;	//arr3 = {}

	LinkedList<Integer> link1;	//link1 = {-4, -1, 5, 12}
	LinkedList<Integer> link2;	//link2 = {-20 - 20}
	LinkedList<Integer> link3;	//link3 = {}
	
	@Before
	public void setUp() {
		arr1 = new ArrayList<>();		//will contain {-3,-2,-1,0,1,2,3}
		for(int i =-3; i < 4; i++) {
			arr1.add(i);
		}

		arr2 = new ArrayList<>();		//will contain {0,2,4,6,8}
		for(int i = 0; i <= 8; i++) {
			if(i % 2 == 0)
				arr2.add(i);
		}
		
		arr3 = new ArrayList<>();		//empty set, so {}

		link1 = new LinkedList<>();		//will contain {-4, -1, 5, 12}
		link1.add(-4);
		link1.add(-1);
		link1.add(5);
		link1.add(12);

		link2 = new LinkedList<>();		//will contain {-20 to 20}
		for(int i = -20; i < 21; i++) {
			link2.add(i);
		}
		
		link3 = new LinkedList<>();		//empty set, {}

	}
	
	@After
	public void tearDown(){
		arr1 = null;
		arr2 = null;
		arr3 = null;

		link1 = null;
		link2 = null;
		link3 = null;
	}
	
	
	@Test
	public void testElements() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		assertTrue(Sets.isElement(2, arr1));
		assertTrue(Sets.isElement(8, arr2));
		assertTrue(Sets.isElement(-4, link1));
		assertTrue(Sets.isElement(20, link2));
		
		assertFalse(Sets.isElement(0, arr3));
		assertFalse(Sets.isElement(4, link3));
		assertFalse(Sets.isElement(6, arr1));
		assertFalse(Sets.isElement(21, link2));

	}
	
	@Test
	public void testSubSet() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		assertTrue(Sets.isSubset(link1, link2));
		assertTrue(Sets.isSubset(arr1, link2));
		assertTrue(Sets.isSubset(link3, arr1));
		assertTrue(Sets.isSubset(arr2, link2));
		
		assertFalse(Sets.isSubset(link2, arr1));
		assertFalse(Sets.isSubset(arr2, arr1));
		assertFalse(Sets.isSubset(arr1, link3));

	}
	
	@Test
	public void testSuperSet() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		assertTrue(Sets.isSuperSet(link2, arr1));
		assertTrue(Sets.isSuperSet(link2, arr2));
		assertTrue(Sets.isSuperSet(link2, arr3));
		assertTrue(Sets.isSuperSet(link2, link1));
		assertTrue(Sets.isSuperSet(link2, link3));
		
		assertFalse(Sets.isSuperSet(link3, arr1));
		assertFalse(Sets.isSuperSet(arr1, arr2));
		assertFalse(Sets.isSuperSet(arr2, link2));
	
	}

	@Test
	public void testUnion() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		List<Integer> empty = Sets.union(arr3, link3);		//union empty sets
		assertEquals(0,empty.size());
		
		List<Integer> combined = Sets.union(arr1,link3);	//union empty set with arr1
		assertEquals(7,combined.size());
		assertEquals(arr1,combined);
		
		combined = Sets.union(arr2,arr1);					//union arr2 with arr1
		assertEquals(10,combined.size());
		
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(-3);
		answer.add(-2);
		answer.add(-1);
		answer.add(-0);
		answer.add(1);
		answer.add(2);
		answer.add(3);
		answer.add(4);
		answer.add(6);
		answer.add(8);
		
		assertEquals(answer, combined);						//combined must be sorted for this test to pass
		
		combined = Sets.union(arr1, link2);					//union a subset with superset, will just be superset
		assertEquals(41,combined.size());
		assertEquals(combined, link2);
		
	}
	
	@Test
	public void testIntersection() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		List<Integer> empty = Sets.intersection(link2, link3);			//intersection of set with empty set
		assertEquals(0, empty.size());
		
		empty = Sets.intersection(arr2, link1);							//intersection of two disjoint sets
		assertEquals(0, empty.size());
		
		List<Integer> intersect = Sets.intersection(arr1, link1);		//intersection of two sets with some common elements
		List<Integer> asnwer = new ArrayList<>();
		asnwer.add(-1);
		assertEquals(1,intersect.size());
		assertEquals(intersect,asnwer);
		
		intersect = Sets.intersection(link1, link2);					//intersection of subset with superset
		assertEquals(4, intersect.size());
		assertEquals(intersect, link1);
		
	}

	@Test
	public void testSubtract() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr2 = {0,2,4,6,8}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		//link2 = {-20 - 20}
		//link3 = {}
		
		List<Integer> empty = Sets.subtract(link3, link2);				//subtract a set from empty set
		assertEquals(0, empty.size());
		
		List<Integer> subtract = Sets.subtract(arr1, arr3);				//subtract empty set from a set
		assertEquals(7, subtract.size());
		assertEquals(arr1,subtract);
		
		subtract = Sets.subtract(link1, arr2);							//subtract disjoint sets
		assertEquals(4,subtract.size());
		assertEquals(subtract,link1);
		
		subtract = Sets.subtract(arr2, arr1);							//subtract arr1 from arr2
		assertEquals(3,subtract.size());
		List<Integer> answer = new ArrayList<>();
		answer.add(4);
		answer.add(6);
		answer.add(8);
		assertEquals(answer,subtract);
		
	}
	
	@Test
	public void testCartesianProduct() {
		
		//arr1 = {-3,-2,-1,0,1,2,3}
		//arr3 = {}
		//link1 = {-4, -1, 5, 12}
		
		List<String> empty = Sets.cartesianProduct(arr1, arr3);			//cartesian product with empty set will return empty set
		List<String> answer = new ArrayList<>();
		answer.add("");													//basically a list with a lone empty string in it
		assertEquals(1,empty.size());
		assertEquals(answer, empty);
		
		List<Integer> smallList = new ArrayList<>();
		smallList.add(7);
		smallList.add(2);
		
		List<String> cartesian = Sets.cartesianProduct(link1, smallList);
		answer.clear();
		answer.add("(-4,2)");
		answer.add("(-4,7)");
		answer.add("(-1,2)");
		answer.add("(-1,7)");
		answer.add("(5,2)");
		answer.add("(5,7)");
		answer.add("(12,2)");
		answer.add("(12,7)");
		
		assertEquals(8, cartesian.size());
		assertEquals(answer, cartesian);
	}
	
	@Test
	public void testEquals() {
		
		//arr2 = {0,2,4,6,8}

		List<Integer> answer = new ArrayList<>();		//will contain {0,2,4,6,8}
		for(int i = 0; i <= 8; i++) {
			if(i % 2 == 0)
				answer.add(i);
		}
		
		assertTrue(Sets.equals(answer, arr2));			//compare similar sets
		assertTrue(Sets.equals(arr3, link3));			//compare two empty sets
		assertFalse(Sets.equals(arr1, link2));			//compare two different sets
		assertFalse(Sets.equals(arr3, link1));			//compare empty set with a set
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSorting() {
		
		List<Integer> testLink = new LinkedList<>();
		testLink.add(4);
		testLink.add(-5);
		testLink.add(14);
		testLink.add(35);
		testLink.add(-2);
		testLink.add(-144);
		testLink.add(0);
		
		Sets.sort(testLink);		//{-144, -5, -2, 0 ,4, 14, 35 }
		
		assertEquals(new Integer(-144), testLink.get(0));
		assertEquals(new Integer(-5), testLink.get(1));
		assertEquals(new Integer(-2), testLink.get(2));
		assertEquals(new Integer(0), testLink.get(3));
		assertEquals(new Integer(4), testLink.get(4));
		assertEquals(new Integer(14), testLink.get(5));
		assertEquals(new Integer(35), testLink.get(6));
		
	}
	
}
