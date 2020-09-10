package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class NoLowerAlphaException extends Exception {
	
	private String message;
	
	NoLowerAlphaException()
	{
		message = "The password must contain at least one lowercase alphabetic character";
	}
	
	NoLowerAlphaException(String s)
	{
		message = s;
	}
	
	public String toString()
	{
		return message;
	}
	public String getMessage()
	{
		return message;
	}
}
