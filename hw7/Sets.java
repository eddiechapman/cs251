import java.util.ArrayList;
import java.util.List;

public class Sets {

	/**
	 * Check if passed in Integer is part of passed in List.
	 * 
	 * @param i
	 * @param list
	 * @return booelan
	 */
	public static boolean isElement(Integer i, List<Integer> list) {
		return list.contains(i);
	}
	
	/**
	 * Check if list1 is a subset of list2.
	 * Subset means all elements in list1 must be in list2.
	 * If so return true, else return false.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSubset(List<Integer> list1, List<Integer> list2) {
		for (Integer element: list1) {
			if (!list2.contains(element)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if list1 is a super set of list2.
	 * Super set means all elements in list2 must be in list1.
	 * Return true if so, false otherwise.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean isSuperSet(List<Integer> list1, List<Integer> list2) {
		for (Integer element: list2) {
			if (!list1.contains(element)) {
				return false;
			}
		}
		return true;
	}
	
	
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
		union.addAll(list1);
		union.addAll(list2);
		sort(union);
		
		for (Integer element: union) 
		{
			if (union.indexOf(element) != union.lastIndexOf(element)) 
			{
				union.remove(element);
			}
		}
		
		return union;
	}
	
	/**
	 * Perform intersection of list1 and list2.
	 * Intersection means to only include an element if it is in both Lists.
	 * This method will return a new interesected List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Integer> intersection(List<Integer> list1,List<Integer> list2){
		//TODO
	}
	
	/**
	 * Perform subtract of sets.  list1 - list2.
	 * The result will be a List that contains all elements in list1 minus any elements that also occur in list2.
	 * This method will return a new subtracted List that is sorted from smallest to largest.
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Integer> subtract(List<Integer> list1, List<Integer> list2){
		//TODO
	}
	
	/**
	 * Two lists are equal if all the elements in list1 occur in list2, and all elements in list2 occur in list1.
	 * Order does matter here.
	 * 
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	public static boolean equals(List<Integer> list1, List<Integer> list2) {
		//TODO
	}
	
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
	public static List<String> cartesianProduct(List<Integer> list1, List<Integer> list2){
		//TODO
	}
	
	
	/**
	 * Sort the list passed in from smallest to the largest.
	 * Notice, there is no return type, so this sorts the List in place.
	 * 
	 * @param list
	 */
	public static void sort(List<Integer> list) {
		Integer selection;
		int sortedIndex;
		
		for (int unSortedIndex=1; unSortedIndex<list.size(); unSortedIndex++) 
		{
			selection = list.get(unSortedIndex);
			
			for (sortedIndex=unSortedIndex; (sortedIndex>0) && (selection<list.get(sortedIndex-1)); sortedIndex--) 
			{
				list.add(sortedIndex, list.get(sortedIndex-1));
			}
			list.add(sortedIndex, selection);
		}
	}
	
}
