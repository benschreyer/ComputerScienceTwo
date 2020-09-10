//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
package bspchecker;
import java.util.ArrayList;
import java.util.regex.Matcher;
public class PasswordCheckerUtility {
	public static boolean isValidPassword(String pwd) throws Exception
	{
		if(pwd.length() < 6)
		{
			throw new LengthException();
		}
		

		if(!pwd.matches(".*[A-Z].*"))
		{
			throw new NoUpperAlphaException();
		}

		if(!pwd.matches(".*[a-z].*"))
		{
			throw new NoLowerAlphaException();
		}
		
		if(!pwd.matches(".*[0-9].*"))
		{
			throw new NoDigitException();
		}
		
		if(!pwd.matches(".*[!@#$%^&*?.,:;\\(\\)\\[\\]\\{\\}].*"))
		{
			throw new NoSpecialCharacterException();
		}
		
		for(int i = 0; i < pwd.length()-1;i++)
		{
			if(pwd.toCharArray()[i] == pwd.toCharArray()[i+1])
			{
				throw new InvalidSequenceException();
			}
		}
		if(pwd.length() < 10)
		{
			throw new WeakPasswordException();
		}

		return true;
	}
	public static boolean isWeakPassword(String pwd)
	{
		return pwd.length() <= 9 && pwd.length() >= 6;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> pwds)
	{
		ArrayList<String> ret = new ArrayList<String>(); 
		for(String pwd : pwds)
		{
			try
			{
				isValidPassword(pwd);
			}
			catch(Exception e)
			{
				ret.add(pwd);
			}
		}
		return ret;
	}
	public static ArrayList<String> validPasswords(ArrayList<String> pwds) {
		ArrayList<String> ret = new ArrayList<String>(); 
		for(String pwd : pwds)
		{
			try
			{
				isValidPassword(pwd);
			}
			catch(Exception e)
			{
				continue;
			}
			ret.add(pwd);
		}
		return ret;
	}
}
