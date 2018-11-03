import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		
		System.out.println("Starting Program and initializiing arrays.");
		
		//IF your computer takes a very long time to create the arrays, you may decrease the size a little
		int size = 100000000;
		
		int[] unsortedArray = new int[size];
		int[] sortedArray = new int[size];

		for(int i = 0; i < unsortedArray.length; i++) {
			unsortedArray[i] = i;
			sortedArray[i] = i;
		}
		
		System.out.println("Starting to randomize. This may take several seconds.");
		randomize(unsortedArray);
		
		String input = "";
		long start, totalTime;
		int val, index;
		
		while(!input.equals("quit")) {
			
			System.out.print("Please enter a number to search for (between 0 and " + (size-1) + "): ");
			
			input = scr.nextLine();
			
			if(input.equals("quit")) {
				continue;
			}
			
			val = Integer.parseInt(input);
			
			start = System.nanoTime();
			index = linearSearch(val , unsortedArray);
			totalTime = System.nanoTime() - start;
			displayResults(val,index,totalTime, "linear unsorted");
			
			start = System.nanoTime();
			index = linearSearch(val , sortedArray);
			totalTime = System.nanoTime() - start;
			displayResults(val,index,totalTime, "linear sorted");
			
			start = System.nanoTime();
			index = binarySearch(val , sortedArray);
			totalTime = System.nanoTime() - start;
			displayResults(val,index,totalTime, "binary search");
			
			System.out.println();
			
		}
		
		scr.close();
		System.out.println("Goodbye.");
		
	}
	
	public static void displayResults(int val, int index, long totalTime, String searchStyle) {
		
		if(searchStyle.equals("linear unsorted")) {
			System.out.println("\nLinear Unsorted Search Results:");
		} else if (searchStyle.equals("linear sorted")) {
			System.out.println("\nLinear Sorted Search Results:");
		} else {
			System.out.println("\nBinary Search Results:");
		}
		
		if(index == -1) {
			System.out.println("The number <" + val +"> was not found.  It took " + totalTime + " to search.");
		} else {
			System.out.println("The number <" + val +"> was found at index <" + index +  ">.  It took " + totalTime + " nano seconds to search.");
		}
	}
	
	/**
	 * Randomly select two different indices in the array and swap them.
	 * If your array size is n, perform n/2 swaps.
	 * 
	 * @param array
	 */
	public static void randomize(int[] array) {
		
		//TODO
		
	}
	
	/**
	 * Search the array for the passed in val using a sequential search.
	 * Return the location of val when found.
	 * If it isn't found return -1.
	 * 
	 * @param val
	 * @param array
	 * @return index or -1
	 */
	public static int linearSearch(int val, int[] array) {
		
		//TODO
		
	}
	
	/**
	 * Search the array for the passed in val using binary search.
	 * Return the location of val when found.
	 * If it isn't found return -1.
	 * 
	 * @param val
	 * @param array
	 * @return
	 */
	public static int binarySearch(int val, int[] array) {
		
		//TODO
		
	}

}
