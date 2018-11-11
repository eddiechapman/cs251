import java.util.ArrayList;
import java.util.List;

public class Sets 
{
	
	/**
	 * Check if passed in Integer is part of passed in List.
	 * 
	 * @param i
	 * @param list
	 * @return booelan
	 */
	public static boolean isElement(Integer i, List<Integer> list) 
	{
		return list.contains(i);
	} 
	
	//***************************************************************************
	
	/**
	 * Check if list1 is a subset of list2.
	 * Subset means all elements in list1 must be in list2.
	 * If so return true, else return false.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSubset(List<Integer> list1, List<Integer> list2) 
	{
		for (Integer element: list1) 
		{
			if (!list2.contains(element)) 
			{
				return false;
			}
		}
		
		return true;
		
	} // end isSubset
	
	//***************************************************************************
	
	/**
	 * Check if list1 is a super set of list2.
	 * Super set means all elements in list2 must be in list1.
	 * Return true if so, false otherwise.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSuperSet(List<Integer> list1, List<Integer> list2) 
	{
		for (Integer element: list2) 
		{
			if (!list1.contains(element)) 
			{
				return false;
			}
		}
		
		return true;
		
	} // end isSuperSet
	
	//***************************************************************************
	
	/**
	 * Perform the union of list1 and list2.
	 * Union means take all elements from each List and combine them into one List.
	 * If duplicate elements, only include one of the element.
	 * For example, if 3 occurred in both Lists, the resulting List will only contain one 3.
	 * This method will return a new combined List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Integer> union(List<Integer> list1, List<Integer> list2) 
	{
		List<Integer> union = new ArrayList<>();

		for (Integer element: list1) 
		{
			if (!union.contains(element))
			{
				union.add(element);
			}
		}
		
		for (Integer element: list2) 
		{
			if (!union.contains(element))
			{
				union.add(element);
			}
		}
		
		sort(union);

		return union;
		
	} // end union
	
	//***************************************************************************
	
	/**
	 * Perform intersection of list1 and list2.
	 * Intersection means to only include an element if it is in both Lists.
	 * This method will return a new interesected List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Integer> intersection(List<Integer> list1,List<Integer> list2) 
	{
		List<Integer> intersection = new ArrayList<>();
		
		for (Integer element: list1) 
		{
			if (list2.contains(element)) 
			{
				intersection.add(element);
			}
		}
		
		sort(intersection);
		
		return intersection;
		
	} // end intersection
	
	//***************************************************************************
	
	/**
	 * Perform subtract of sets.  list1 - list2.
	 * The result will be a List that contains all elements in list1 minus any elements that also occur in list2.
	 * This method will return a new subtracted List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Integer> subtract(List<Integer> list1, List<Integer> list2) 
	{
		List<Integer> subtract = new ArrayList<>();
		
		for (Integer element: list1) 
		{
			if (!list2.contains(element)) 
			{
				subtract.add(element);
			}
		}
		
		sort(subtract);
		
		return subtract;
		
	} // end subtract
	
	//***************************************************************************
	
	/**
	 * Two lists are equal if all the elements in list1 occur in list2, and all elements in list2 occur in list1.
	 * Order does matter here. 
	 * 
	 * Student comment: the example in the assignment instructions seems to imply that order does not matter,
	 * so I added a boolean flag that will accommodate both cases. 
	 * 
	 * 
	 * @param list1
	 * @param list2
	 * @param orderMatters
	 * @return boolean
	 */
	public static boolean equals(List<Integer> list1, List<Integer> list2, boolean orderMatters) 
	{
		if (list1.size() != list2.size()) 
		{
            return false;
		}
		
		if (orderMatters == true) 
		{
			return list1.equals(list2);
		}
		
		for(Integer element: list1)
        {
            if (!list2.contains(element))
            {
                return false;
            }
        }
		
		return true;
		
	} // end equals
	
	//***************************************************************************
	
	/**
	 * Perform the cartesian product of two lists.
	 * This method will store the result as a List that holds strings since Java does not allow Tuples.
	 * Both lists must be sorted before performing the cartesian product.
	 * Elements in list1 should be the first element in each product.
	 * If the either list is empty, return a empty List.
	 * 
	 * See handout for example.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<String> cartesianProduct(List<Integer> list1, List<Integer> list2) 
	{
		List<String> cartesianProduct = new ArrayList<>();
		sort(list1);
		sort(list2);
		
		for (Integer outerElement: list1) 
		{
			for (Integer innerElement: list2)
			{
				cartesianProduct.add("(" + outerElement.toString() + "," + innerElement.toString() + ")");
			}
		}
		
		return cartesianProduct;
		
	} // end cartesianProduct
	
	//***************************************************************************
	
	/**
	 * Sort the list passed in from smallest to the largest.
	 * Notice, there is no return type, so this sorts the List in place.
	 * 
	 * @param list
	 */
	public static void sort(List<Integer> list) 
	{
		// Move forward through the unsorted portion of the list
		for (int i=0; i<list.size(); i++) 
		{
			// Select the first unsorted element
			Integer selection = i;
			
			// Move backward through the sorted portion until the selection is in place
			for (int j=i; j<list.size(); j++) 
			{
				// ...shifting each sorted element one spot forward to make room for selection
				if (list.get(j) < list.get(selection)) 
				{
                    selection = j;
				}
			}
			Integer max = list.get(selection);
            list.set(selection, list.get(i));
            list.set(i, max);
			
		}
		
	} // end sort
	
	//***************************************************************************
	
	/**
	 * Find the compliment set of a list within a specified range.
	 * 
	 * @param list
	 * @param lowerBound
	 * @param uppderBound
	 * @return
	 */
	public static List<Integer> compliment(List<Integer> list, int lowerBound, int upperBound)
	{
		List<Integer> compliment = new ArrayList<>();
		
		for (Integer i=lowerBound; i<=upperBound; i++)
		{
			if (!list.contains(i)) 
			{
				compliment.add(i);
			}
		}
		
		return compliment;
		
	} // end compliment

	
} // end class Sets
