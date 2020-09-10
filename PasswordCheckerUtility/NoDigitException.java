package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class NoDigitException extends Exception {
	private String message;
	
	NoDigitException()
	{
		message = "The password must contain at least one digit";
	}
	
	NoDigitException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
}
