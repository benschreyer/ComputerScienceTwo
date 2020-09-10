package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class NoSpecialCharacterException extends Exception {
	
	private String message;
	
	NoSpecialCharacterException()
	{
		message = "The password must contain at least one special character";
	}
	
	NoSpecialCharacterException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
}
