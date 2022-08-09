/************************************************************
 * Eddie Chapman, Homework #2, CompSt 750
 * 
 * This program receives user input representing a list of dates. It parses them
 * based on format, validates their day, month, and year components, and prints
 * them in a standardized format.
 * 
 * I discussed this assignment with Mason Baran. We created a flowchart together
 * for the main() function. He also showed me how to count the number of dashes 
 * using .replace("-", "") and .length().
 * 
 **************************************************************/

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

	// Input validation errors
	private static String dashError = "ERROR: Too many dashes";
	private static String monthError = "ERROR: Invalid month string";
	private static String dayError = "ERROR: Invalid month or day number";
	private static String inputError = "ERROR: Empty input line";
	private static String yearError = "ERROR: Invalid Year -- too low or high";
	private static String andError = "ERROR: No date entered";
	
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);

		System.out.println("Welcome to the CS251 Date Converter!\n");

		System.out.print("Enter line of dates:");
		String dateEntries = stdIn.nextLine();
		
		
		if (dateEntries.isEmpty()) {		// Error for entering blank input line
			System.out.print(inputError);
		} else {
			String[] dateEntriesArray = dateEntries.split("and");
			
			for (int i = 0; i < dateEntriesArray.length; i++) {
				
				String dateStr = dateEntriesArray[i].trim();
				
				// Error for starting input line with "and"
				if (dateStr.isEmpty()) {	
					System.out.print("\nDate " + (i + 1) + ": " + andError);
				// All numbers format	
				} else if (dateStr.indexOf('-') != -1) {  		
					System.out.print("\nDate " + (i + 1) + ": ");
					parseAllNumbers(dateStr);
				// Month first format
				} else if (dateStr.indexOf(',') != -1) {
					System.out.print("\nDate " + (i + 1) + ": ");
					parseMonthFirst(dateStr);
				// Day first format
				} else { 
					System.out.print("\nDate " + (i + 1) + ": "); 
					parseDayFirst(dateStr);
				}
			}  // end for loop
		} // end else
		
		System.out.println("\n\nGoodbye!");
		
		stdIn.close();
		
	}  // end main

	
	/*
	 * Given a date string in the "day first" format, identify and validate the day, 
	 * month, and year, and print them in a standardized format. 
	 * 
	 * Date components are extracted via string subsetting. The position of the first whitespace
	 * is used to separate the "day" from "month". "Year" is separated using the assumption that a 
	 * valid entry will always occupy the final four index positions of the dateStr argument.
	 */
	public static void parseDayFirst(String dateStr) {

		// Date component extraction
		int day = Integer.parseInt(dateStr.substring(0, dateStr.indexOf(" ")).trim());
		String month = dateStr.substring(dateStr.indexOf(" "), (dateStr.length() - 4)).trim();
		int year = Integer.parseInt(dateStr.substring((dateStr.length() - 4)).trim());
		
		// Date component validation
		if (isValidMonthAbbr(month) == false) {
			System.out.print(monthError);
		} else if (isValidMonthDay(day, monthToNumber(month)) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		// Standard date formatting
		} else {
			System.out.print(standardDateString(day, monthToNumber(month), year));
		}
	}

	
	/*
	 * Given a date string in the "month first" format, identify and validate the day, 
	 * month, and year, and print them in a standardized format. 
	 * 
	 * Date components are extracted via string subsetting. The position of the first whitespace
	 * and first comma character are used to demarcate the three date components.
	 */
	public static void parseMonthFirst(String dateStr) {
		
		// Date component extraction
		String month = dateStr.substring(0, dateStr.indexOf(" ")).trim();
		int year = Integer.parseInt(dateStr.substring(dateStr.indexOf(",") + 1).trim());
		int day = Integer.parseInt(dateStr.substring(dateStr.indexOf(" "), dateStr.indexOf(",")).trim());
		
		// Date component validation
		if (isValidMonthAbbr(month) == false) {
			System.out.print(monthError);
		} else if (isValidMonthDay(day, monthToNumber(month)) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		// Standard date formatting
		} else {
			System.out.print(standardDateString(day, monthToNumber(month), year));
		}

	} // end parseMonthFirst
	
	
	/*
	 * Given a date string in the "all numbers" format, identify and validate the day, 
	 * month, and year, and print them in a standardized format. 
	 * 
	 * Date components are extracted via string subsetting. The position of the first 
	 * dash character is used to separate the "month" and "day" values. "Year" is 
	 * separated using the assumption that a valid entry will always occupy the final 
	 * four index positions of the dateStr argument.
	 * 
	 * To prevent errors during date component extraction, dateStr argument is first
	 * validated for a correct number of dashes (2) by comparing the length of dateStr 
	 * with and without dash characters. 
	 */
	public static void parseAllNumbers(String dateStr) {
		
		// Validating that dateStr does not contain more than 2 dashes
		if (dateStr.length() - dateStr.replace("-", "").length() > 2) {
			System.out.print(dashError);
		}
		
		// Date component extraction
		int month = Integer.parseInt(dateStr.substring(0, dateStr.indexOf("-")).trim());
		int day = Integer.parseInt(dateStr.substring((dateStr.indexOf("-") + 1),  (dateStr.length()-5)).replace("-", "").trim());
		int year = Integer.parseInt(dateStr.substring((dateStr.length() - 5)).trim());
		
		// Validating date components
		if (isValidMonthDay(day, month) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		// Standard date formatting
		} else {
			System.out.print(standardDateString(day, month, year));
		}
		
	} // end parseAllNumber

	
	/*
	 * Validate that the "day" value is legal given it's associated "month" value.
	 * 
	 * First, check that "day" and/or "month" value are not 0 or negative values. 
	 * Then, check that "day" is not greater than largest day of each that month.
	 */
	public static boolean isValidMonthDay(int day, int month) {
		
		// Validate that day or month are not 0 or negative values.
		if (day < 1 || month < 1) { return false; }
		
		// Validate that day is less than or equal to maximum day allowed for that month.
		switch (month) {
		  	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		  		return day <= 31 ? true : false;
	 		case 4: case 6: case 9: case 11:
	  			return day <= 30 ? true : false;
	  		case 2:
	 			return day <= 28 ? true : false;
	  		default: 
	  			return false;	// An unlikely condition given preliminary validation
	  	} // end switch
		
	} // end isValidDay

	
	/*
	 * Given a string representing a month, return the month number it is associated
	 * with. Return 0 if none match. 
	 * 
	 * monthStr argument is converted to lowercase and subset by the first three characters.
	 * Then, each month in the global abbrMonths array is compared to monthStr for equality. 
	 * The index of the loop (+1) is used as the month number if a match is found.
	 */
	public static int monthToNumber(String monthStr) {

		String lowerCaseMonthStr = monthStr.toLowerCase().substring(0, 3);

		int mNumber = 0;

		for (int i = 0; i < abbrMonths.length; i++) {
			if (abbrMonths[i].equals(lowerCaseMonthStr)) {
				mNumber = i + 1;
				break;
			}
		}

		return mNumber;

	} // end monthToNumber


	/*
	 * Validate that a string representing an abbreviated month is a correct abbreviation.
	 * 
	 * First, ensure that the string is at least three letters long. Then iterate through 
	 * global array of legal month abbreviations and look for a matching comparison. Break
	 * the loop if match is found. If no match is found, return false (invalid).
	 */
	public static boolean isValidMonthAbbr(String str) {
		
		if (str.length() < 3) { return false; }
		
		for (String month: abbrMonths) {
			if (month.equalsIgnoreCase(str.substring(0, 3)) == true) {
				return true ; 
			} else { 
				continue; 
			}
		} // end for loop
		
		return false;
		
	} // end isValidMonthAbbr

	
	/*
	 * Validate a number representing a calendar year by ensuring that it is 
	 * greater or equal to 1900 and less than or equal to 2018. 
	 */
	public static boolean isValidYear(int year) {
	
		return year >= 1900 && year <= 2018 ? true : false ;

	} // end isValidYear

	
	/*
	 * Print a standardized date format using integers representing the year,
	 * month and date.
	 * 
	 * Month (m) integer is converted to a string by using the m int as a index (+1)
	 * to the fullNameMonths global array. It is then converted to title case by 
	 * removing and capitalizing the first letter before reattaching.
	 * 
	 * The standardized date is then concatenated using the new month string and the
	 * day (d) and year (y) arguments and returned.
	 */
	public static String standardDateString(int d, int m, int y) {
		
		String month = fullNameMonths[m-1].substring(0,1).toUpperCase() 
				+ fullNameMonths[m-1].substring(1);
	
		return d + " " + month + " " + y;
	 
	} // end standardDateString
	
} // end DateConversion