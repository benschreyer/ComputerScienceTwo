package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class NoUpperAlphaException extends Exception {
	
	private String message;
	
	NoUpperAlphaException()
	{
		message = "The password must contain at least one uppercase alphabetic character";
	}
	
	NoUpperAlphaException(String s)
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
