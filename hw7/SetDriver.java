import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetDriver
{
	public static void main(String [] args)
	{
		List<Integer> s1 = new ArrayList<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		
		List<Integer> s2 = new ArrayList<>();
		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		s2.add(8);
		
		List<Integer> s3 = new ArrayList<>();
		s3.add(6);
		s3.add(7);
		s3.add(8);
		
		List<Integer> s4 = new LinkedList<>();
		s4.add(1);
		s4.add(2);
		s4.add(3);
		s4.add(4);
		s4.add(5);
		
		List<Integer> s5 = new LinkedList<>();
		s5.add(2);
		s5.add(1);
		s5.add(3);

		System.out.println(Sets.isElement(2, s1));  	// true
		System.out.println(Sets.isSubset(s1, s2));		// false	
		System.out.println(Sets.isSuperSet(s3, s2));	// true
		System.out.println(Sets.equals(s1, s4));		// true
		
		System.out.println("\n\nUnion:");
		List<Integer> union = Sets.union(s3, s5);
		for (Integer element: union) 
		{
			System.out.print(element);
		}
		
		System.out.println("\n\nIntersection:");
		List<Integer> intersection = Sets.intersection(s1, s5);
		for (Integer element: intersection) 
		{
			System.out.print(element);
		}
		
		System.out.println("\n\nSubtract:");
		List<Integer> subtract = Sets.subtract(s2, s3);
		for (Integer element: subtract) 
		{
			System.out.print(element);
		}
		
		System.out.println("\n\nCartesian Product:");
		List<String> cartesianProduct = Sets.cartesianProduct(s1, s5);
		for (String element: cartesianProduct) 
		{
			System.out.print(element);
		}
		
		System.out.println("\n\nSort:");
		Sets.sort(s5);
		for (Integer element: s5) {
			System.out.print(element);
		}
		
		System.out.println("\n\nCompliment:");
		List<Integer> compliment = Sets.compliment(s3, 1, 9);
		for (Integer element: compliment) {
			System.out.print(element);
		}
	}
}