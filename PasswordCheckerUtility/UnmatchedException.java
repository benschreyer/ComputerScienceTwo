package bspchecker;
//Class Written by Benjamin Schreyer 9/3/2020 - 9/10/2020
public class UnmatchedException extends Exception {
	private String message;
	
	UnmatchedException()
	{
		message = "The passwords do not match";
	}

	UnmatchedException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
}
