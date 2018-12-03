import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileIO {

	/**
	 * Open inFile for reading and outFile for writing.
	 * Print out each character 5 times if it is NOT a space, period, comma, question mark, or exclamation point.
	 * If it is any of these characters, it only gets printed once.
	 * See output example given.
	 * @param inFile
	 * @param outFile
	 */
	public static void stretch(String inFile, String outFile) {
		
		System.out.println("stretch opening files " + inFile + ", " + outFile);
		
		try (Scanner scr = new Scanner(new File(inFile)); PrintWriter pw = new PrintWriter(outFile)) {
			
			while (scr.hasNextLine()) {
				
				String stretched = "";
				
				for (char ch: scr.nextLine().toCharArray()) {
					if (" .,?!".indexOf(ch) == -1) {
						stretched += new String(new char[5]).replace('\0', ch);
					} else {
						stretched += ch;
					}
				}
				pw.println(stretched);
			}
			
		} catch(FileNotFoundException e) {
			System.out.print("error opening: " + outFile);
		}
		
		System.out.println("stretch finished");
		
	}

	/**
	 * Open inFile for reading and outFile for writing.
	 * inFile is supposed to contain only whole integers, but sometimes they don't.
	 * Read all numbers, sort them in increasing order, and write them to the output file.
	 * You will need to finish sortNumbers to help sort your numbers.
	 * If you a read a line that is not an int or is not a number, your program must not crash.
	 * Instead, ignore this line.
	 * See output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void sortNumbers(String inFile, String outFile) {
		
		System.out.println("sortNumbers opening files " + inFile + ", " + outFile);
		
		try (Scanner scr = new Scanner(new File(inFile)); PrintWriter pw = new PrintWriter(outFile)) {
			
			List<Integer> wholeNumbers = new ArrayList<>();
			
			while (scr.hasNextLine()) {
				try {
					wholeNumbers.add(Integer.parseInt(scr.nextLine()));
		        } catch (NumberFormatException exception) {
		        	continue;
		        }
			}
			
			sortNumbers(wholeNumbers);
			for (int wholeNumber: wholeNumbers) {
				pw.println(Integer.toString(wholeNumber));
			}
			
		} catch(FileNotFoundException e) {
			System.out.print("error opening: " + outFile);
		}
		
		System.out.println("sortNumbers finished");

	}

	/**
	 * Open inFile for reading and outFile for writing.
	 * This is a method that counts all occurrences of all words in a file.
	 * When done, output each word found and its count to the output file in sorted order.
	 * You will need to call sortWords to help sort your words at the end.
	 * After writing all words, give the total count of words for all words in the file.
	 * See output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void wordCount(String inFile, String outFile) {
		System.out.println("wordCount opening files " + inFile + ", " + outFile);
		
		try (Scanner scr = new Scanner(new File(inFile)); PrintWriter pw = new PrintWriter(outFile)) {
			
			Map<String, Integer> wordCount = new HashMap<>();
			
			while (scr.hasNextLine()) {
				
				String[] words = scr.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");;
				
				for (String word: words) {
					if (!wordCount.containsKey(word)) {
						wordCount.put(word, 1);
					} else {
						int count = wordCount.get(word);
						wordCount.put(word, count + 1);
					}
				}
			}
			
			List<String> uniqueTokens = new ArrayList<>(wordCount.keySet());
			sortWords(uniqueTokens);
			
			int totalWords = 0;
			for (String token: uniqueTokens) {
				totalWords += wordCount.get(token);
				pw.println(String.format("%s: %d", token, wordCount.get(token)));
			}
			pw.println(String.format("\nTotal words: %d", totalWords));
			
		} catch(FileNotFoundException e) {
			System.out.print("error opening: " + outFile);
		}
		
		System.out.println("wordCount finished");
	}
	
	

	/**
	 * Open inFile1 and inFile2 for reading and outFile for writing.
	 * The contents of inFile1 and inFile2 will contain a list of numbers and names in the following format.
	 * 
	 * <File>
	 * <id>:<name>
	 * <id>:<name>
	 * <id>:<name>
	 * and so on.
	 * 
	 * Assume the files are always in this format, and the ids are always sorted in increasing order.
	 * Assume each file does not contain duplicates with in their file.
	 * You do NOT need to verify the file is in the correct format.
	 * You do NOT need to sort anything, they should already be sorted.
	 * Perform the merge of the two lists and write out the contents to the output file.
	 * A merge is exactly the same as a union.  All <id>:<name> from each file should be merged into
	 * one file.  If a duplicate <id>:<name> occurs in both files, only one <id>:<name> is written to the output file.
	 * 
	 * Merge example
	 * 
	 * inFile1.txt				inFile2.txt
	 * 2:Nate					4:Alan
	 * 4:Alan					12:Chelsea
	 * 15:Kristin
	 * 18:Valory
	 * 
	 * mergeOutput.txt
	 * 2:Nate
	 * 4:Alan
	 * 12:Chelsea
	 * 15:Kristin
	 * 18:Valory
	 * 
	 * Also see output example given.
	 * 
	 * @param inFile
	 * @param outFile
	 */
	public static void mergeFileContents(String inFile1, String inFile2, String outFile) {
		System.out.println("merge opening file " + inFile1 + ", " + inFile2 + ", " + outFile);
		
		try (Scanner scr1 = new Scanner(new File(inFile1)); 
				Scanner scr2 = new Scanner(new File(inFile2));
				PrintWriter pw = new PrintWriter(outFile)) {
			
			Map<Integer, String> union = new HashMap<>();
			List<String> people = new ArrayList<>();
			
			while (scr1.hasNextLine()) {
				people.add(scr1.nextLine());
			}
			
			while (scr2.hasNextLine()) {
				people.add(scr2.nextLine());
			}
			
			for (String person: people) {
				String[] personInfo = person.split(":"); 
				union.put(Integer.parseInt(personInfo[0]), personInfo[1]);
			}
			
			for (int i=0; i<=Collections.max(union.keySet()); i++) {
				if (union.get(i) != null) {
					pw.println(String.format("%d:%s", i, union.get(i)));
				}
			}
			
		} catch(FileNotFoundException e) {
			System.out.print("error opening: " + outFile);
		}
		
		System.out.println("merge finished");
	}
	
	/**
	 * Sort list from smallest to largest numbers.
	 * @param list
	 */
	public static void sortNumbers(List<Integer> list) {
		
		Collections.sort(list);
		
	}

	/**
	 * Sort list alphabetically, meaning a - z
	 * @param list
	 */
	public static void sortWords(List<String> list) {
		
		Collections.sort(list);
		
	}

}
