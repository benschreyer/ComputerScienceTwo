package bspchecker;

public class InvalidSequenceException extends Exception {
	private String message;
	
	InvalidSequenceException()
	{
		message = "The password cannot contain more than two of the same character in sequence.";
	}
	
	InvalidSequenceException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
}
