package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class LengthException extends Exception {
	private String message;
	
	LengthException()
	{
		message = "The password must be at least 6 characters long";
	}
	LengthException(String s)
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
