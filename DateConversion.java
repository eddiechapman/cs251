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
		
		if (dateEntries.isEmpty()) {
			System.out.print(inputError);
		}
		else {
			String[] dateEntriesArray = dateEntries.split("and");
			
			for (int i = 0; i < dateEntriesArray.length; i++) {
				String dateStr = dateEntriesArray[i].trim();
				
				if (dateStr.isEmpty()) {
					System.out.print("\nDate " + (i + 1) + ": " + andError);
				} else if (dateStr.indexOf('-') != -1) {
					System.out.print("\nDate " + (i + 1) + ": ");
					parseAllNumbers(dateStr);
				} else if (dateStr.indexOf(',') != -1) {
					System.out.print("\nDate " + (i + 1) + ": ");
					parseMonthFirst(dateStr);
				} else { 
					System.out.print("\nDate " + (i + 1) + ": "); 
					parseDayFirst(dateStr);
				}
			}  // end for loop
		} // end else
		
		
		
		System.out.println("\n\nGoodbye!");
		
		stdIn.close();
		
	}  // end main


	public static void parseDayFirst(String dateStr) {

		int day = Integer.parseInt(dateStr.substring(0, dateStr.indexOf(" ")).trim());
		String month = dateStr.substring(dateStr.indexOf(" "), (dateStr.length() - 4)).trim();
		int year = Integer.parseInt(dateStr.substring((dateStr.length() - 4)).trim());
		
		if (isValidMonthAbbr(month) == false) {
			System.out.print(monthError);
		} else if (isValidMonthDay(day, monthToNumber(month)) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		} else {
			System.out.print(standardDateString(day, monthToNumber(month), year));
		}
	}


	public static void parseMonthFirst(String dateStr) {
		
		String month = dateStr.substring(0, dateStr.indexOf(" ")).trim();
		int year = Integer.parseInt(dateStr.substring(dateStr.indexOf(",") + 1).trim());
		int day = Integer.parseInt(dateStr.substring(dateStr.indexOf(" "), dateStr.indexOf(",")).trim());
		
		if (isValidMonthAbbr(month) == false) {
			System.out.print(monthError);
		} else if (isValidMonthDay(day, monthToNumber(month)) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		} else {
			System.out.print(standardDateString(day, monthToNumber(month), year));
		}

	} // end parseMonthFirst
	
	public static void parseAllNumbers(String dateStr) {
		
		if (dateStr.length() - dateStr.replace("-", "").length() > 2) {
			System.out.print(dashError);
		}
		
		int month = Integer.parseInt(dateStr.substring(0, dateStr.indexOf("-")).trim());
		int day = Integer.parseInt(dateStr.substring((dateStr.indexOf("-") + 1),  (dateStr.length()-5)).replace("-", "").trim());
		int year = Integer.parseInt(dateStr.substring((dateStr.length() - 5)).trim());
		
		if (isValidMonthDay(day, month) == false) {
			System.out.print(dayError);
		} else if (isValidYear(year) == false) {
			System.out.print(yearError);
		} else {
			System.out.print(standardDateString(day, month, year));
		}
		
	} // end parseAllNumber

	
	public static boolean isValidMonthDay(int day, int month) {
		
		if (day < 1) { return false; }
		
		switch (month) {
		  	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		  		return day <= 31 ? true : false;
	 		case 4: case 6: case 9: case 11:
	  			return day <= 30 ? true : false;
	  		case 2:
	 			return day <= 28 ? true : false;
	  		default: 
	  			return false;
	  	} // end switch
		
	} // end isValidDay

	
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


	public static boolean isValidYear(int year) {
	
		return year >= 1900 && year <= 2018 ? true : false ;

	} // end isValidYear

	
	public static String standardDateString(int d, int m, int y) {
		
		String month = fullNameMonths[m-1].substring(0,1).toUpperCase() 
				+ fullNameMonths[m-1].substring(1);
	
		return d + " " + month + " " + y;
	 
	} // end standardDateString
	
} // end DateConversion
