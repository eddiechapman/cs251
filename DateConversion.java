package cs251_HW2;
import java.util.Scanner;

public class DateConversion {

	//Static variable you can use throughout this class
	//contains the months in shorter form
	private static String[] abbrMonths = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep",
			"oct", "nov", "dec" };

	//Another static variable you can use, except these contain the months fully spelled out
	private static String[] fullNameMonths = { "january", "february", "march", "april", "may", "june", "july", "august", "september",
			"october", "november", "december" };

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);


		System.out.println("Welcome to the CS251 Date Converter!\n");

		System.out.print("Enter line of dates:");
		String dateEntries = stdIn.nextLine();

		// Split dateEntries into array of dateString
		// For each dateString in array:
		//		if it looks like dateFirst:
		//			parseDayFirst(dateEntries)
		//		if it looks like monthFirst:
		//			parseMonthFirst(dateEntries)
		//		if it looks like allNumbers:
		//			parseAllNumbers(dateEntries)
		
		// the parsing methods will either print the date or an error
		
		System.out.println("\nGoodbye!");

		stdIn.close();
	}

	
	public static void parseDayFirst(String dateStr) {

	/*	break dateStr into compontent parts
	 * 	check if isValidMonthAbbr
	 * 	convert month to int with monthToNumber
	 * 	check if isValidMonthDay
	 * 	check if isValid Year
	 * 	print standardDateString 
	 */

	}
	

	public static void parseMonthFirst(String dateStr) {

		/*	break dateStr into compontent parts
		 * 	check if isValidMonthAbbr
		 * 	convert month to int with monthToNumber
		 * 	check if isValidMonthDay
		 * 	check if isValid Year
		 * 	print standardDateString 
		 */

	}
	
	public static void parseAllNumbers(String dateStr) {

		/*	break dateStr into compontent parts
		 * 	check if isValidMonthDay
		 * 	check if isValid Year
		 * 	print standardDateString 
		 */

	}

	
	public static boolean isValidMonthDay(int day, int month) {

		/*
		 * Use switch to pick a month
		 * The conditions within each month list the legal range of days
		 */
	}

	
	public static int monthToNumber(String monthStr) {

		String lowerCaseMonthStr = monthStr.toLowerCase().substring(0, 3);

		int mNumber = 0;

		for(int i = 0; i < abbrMonths.length; i++){
			if(abbrMonths[i].equals(lowerCaseMonthStr)){
				mNumber = i + 1;
				break;
			}
		}

		return mNumber;

	}


	public static boolean isValidMonthAbbr(String str) {

		//TODO
		
	}


	public static boolean isValidYear(int year) {
		//TODO
	}

	
	public static String standardDateString(int d, int m, int y) {
		
		//TODO
		
	}
}