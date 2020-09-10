package bspchecker;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Class Methods Filled in by Benjamin Schreyer 9/3/2020 - 9/10/2020
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	private ArrayList<String> testPasswords;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("a!B2");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password must be at least 6 characters long");
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("va23klmno2");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password must contain at least one uppercase alphabetic character");
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("ABC23FARW2");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password must contain at least one lowercase alphabetic character");
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("vA!klmno2");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password is OK but weak - it contains fewer than 10 characters.");
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("vA!klmno2zzz");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password cannot contain more than two of the same character in sequence.");
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("vA!klmno!zzz");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"The password must contain at least one digit");
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		String message = "fail";
		try
		{
			PasswordCheckerUtility.isValidPassword("vaA!klmno!z23");
		}
		catch(Exception e)
		{
			message = e.getMessage();
		}
		assertEquals(message,"fail");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		testPasswords = new ArrayList<String>( 
	            Arrays.asList("baf32", 
                        "vaA!klmno!z23", 
                        "vA!klmno!zzz",
                        "zw!2ABC23FARW215",
                        "vA!klmno2zzz",
                        "a!B2",
                        "ABC23FARW2",
                        "zw!2ABC23FARW2")); 
                        ArrayList<String> res = PasswordCheckerUtility.validPasswords(testPasswords);
                    	assertEquals(res, 
                                Arrays.asList(
                                        "vaA!klmno!z23", 
                                        "zw!2ABC23FARW215",
                                        "zw!2ABC23FARW2") );
	}
	
	
	
}
