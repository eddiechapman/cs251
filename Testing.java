package cs251_HW2;
import org.junit.*;
import static org.junit.Assert.*;



public class Testing {

    
    @Test 
    public void test_isValidMonthAbbreviation1(){
    	
		assertEquals(false,DateConversion.isValidMonthAbbr("Ja"));
		assertEquals(false,DateConversion.isValidMonthAbbr("J"));
		assertEquals(false,DateConversion.isValidMonthAbbr("Fe"));
		assertEquals(false,DateConversion.isValidMonthAbbr("Au"));
		assertEquals(false,DateConversion.isValidMonthAbbr("se"));
		assertEquals(false,DateConversion.isValidMonthAbbr("dea"));
		assertEquals(false,DateConversion.isValidMonthAbbr("merch"));
    }
    @Test 
    public void test_isValidMonthAbbreviation2(){
    	assertEquals(true,DateConversion.isValidMonthAbbr("Jan"));
		assertEquals(true,DateConversion.isValidMonthAbbr("jan"));
		assertEquals(true,DateConversion.isValidMonthAbbr("Januar"));
		assertEquals(true,DateConversion.isValidMonthAbbr("Febr"));
		assertEquals(true,DateConversion.isValidMonthAbbr("February"));
		assertEquals(true,DateConversion.isValidMonthAbbr("Sept"));
		assertEquals(true,DateConversion.isValidMonthAbbr("september"));
		assertEquals(true,DateConversion.isValidMonthAbbr("augu"));
		
    }
    @Test 
    public void test_isValidMonthDay1(){
    	assertEquals(false,DateConversion.isValidMonthDay(0, 10));
    	assertEquals(false,DateConversion.isValidMonthDay(1, 13));
    	assertEquals(false,DateConversion.isValidMonthDay(31, 2));
    	assertEquals(false,DateConversion.isValidMonthDay(33, 3));
    	assertEquals(false,DateConversion.isValidMonthDay(31, 4));
    	assertEquals(false,DateConversion.isValidMonthDay(31, 11));
    	// Student test contributions
    	assertEquals(false,DateConversion.isValidMonthDay(-1, 1)); // Negative day is invalid
    	assertEquals(false,DateConversion.isValidMonthDay(1, -1)); // Negative month is invalid
    	assertEquals(false,DateConversion.isValidMonthDay(-3, -5)); // Negative day and month is invalid
    }
   
    @Test 
    public void test_isValidMonthDay2(){
    	assertEquals(true,DateConversion.isValidMonthDay(1, 10));
    	assertEquals(true,DateConversion.isValidMonthDay(1, 12));
    	assertEquals(true,DateConversion.isValidMonthDay(28, 2));
    	assertEquals(true,DateConversion.isValidMonthDay(1, 2));
    	assertEquals(true,DateConversion.isValidMonthDay(30, 4));
    	assertEquals(true,DateConversion.isValidMonthDay(30, 11));
    	assertEquals(true,DateConversion.isValidMonthDay(5, 12));
    	assertEquals(true,DateConversion.isValidMonthDay(1, 1));
    }
  
    @Test 
    public void test_isValidYear1(){
    	assertEquals(false,DateConversion.isValidYear(1100));
    	assertEquals(false,DateConversion.isValidYear(1880));
    	assertEquals(false,DateConversion.isValidYear(1200));
    	assertEquals(false,DateConversion.isValidYear(550));
    	assertEquals(false,DateConversion.isValidYear(0));
    	assertEquals(false,DateConversion.isValidYear(696));
    	// Student test contributions
    	assertEquals(false,DateConversion.isValidYear(-2018)); // Year is lower than valid value
    	assertEquals(false,DateConversion.isValidYear(-1900)); // Year is lower than valid value
    	}
    
    @Test 
    public void test_isValidYear2(){
    	assertEquals(true,DateConversion.isValidYear(1900));
    	assertEquals(true,DateConversion.isValidYear(2001));
    	assertEquals(true,DateConversion.isValidYear(2010));
    	assertEquals(false,DateConversion.isValidYear(2030));
    	assertEquals(true,DateConversion.isValidYear(2017));
    	assertEquals(false,DateConversion.isValidYear(2050));
    	}
    
    @Test 
    public void test_monthToNum(){
    	assertEquals(1,DateConversion.monthToNumber("Jan"));
    	assertEquals(1,DateConversion.monthToNumber("jan"));
    	assertEquals(2,DateConversion.monthToNumber("Febr"));
    	assertEquals(8,DateConversion.monthToNumber("Augus"));
    	assertEquals(9,DateConversion.monthToNumber("septemb"));
    	assertEquals(12,DateConversion.monthToNumber("December"));
    	assertEquals(10,DateConversion.monthToNumber("Octob"));
    	assertEquals(3,DateConversion.monthToNumber("marc"));
    	assertEquals(5,DateConversion.monthToNumber("May"));
    	assertEquals(7,DateConversion.monthToNumber("Jul"));
    	assertEquals(0,DateConversion.monthToNumber("ttt"));
    	// Personal test contributions
    	assertEquals(4,DateConversion.monthToNumber("apr")); // First three letters will be valid (april)
    	assertEquals(0,DateConversion.monthToNumber("ril")); // Last three letters will be invalid (april)
    	
    	}
    
    @Test 
    public void test_standardDateString(){
    	assertEquals("12 December 2015",DateConversion.standardDateString(12, 12, 2015));
    	assertEquals("12 January 2018",DateConversion.standardDateString(12, 1, 2018));
    	assertEquals("20 November 2017",DateConversion.standardDateString(20, 11, 2017));
    	assertEquals("1 May 2020",DateConversion.standardDateString(1, 5, 2020));
    	assertEquals("6 June 2015",DateConversion.standardDateString(6, 6, 2015));
    	
    	
    	
    	}





}
