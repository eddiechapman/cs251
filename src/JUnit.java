import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit {
	
	String inFile1, outFile1;
	PrintWriter pw1;
	
	
	@Before
	public void setUp() throws Exception {
		inFile1 = "NumbersTest1.txt";
		outFile1 = "NumbersResult1.txt";		
	}
	
	@After
	
	public void tearDown() {
		inFile1 = null;
		outFile1 = null;


	}
	
	
	@Test
	public void sortNumbers1() {
		
		FileIO.sortNumbers(inFile1, outFile1);
		
		int x = 1;
		try(Scanner scr = new Scanner(new File(outFile1))) {
			while(scr.hasNextLine()) {
				if(x == 2) {
					try {
						assertTrue(Integer.parseInt(scr.nextLine()) == 0);
			        } catch (NumberFormatException exception) {
			        	System.out.print("Error performing test.");
			        }
				}
				scr.nextLine();
				x++;
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error opening" + inFile1);
		}
	}
		

}
