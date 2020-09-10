package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class WeakPasswordException extends Exception {
	private String message;
	
	WeakPasswordException()
	{
		message = "The password is OK but weak - it contains fewer than 10 characters.";
	}
	
	WeakPasswordException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
	
}
