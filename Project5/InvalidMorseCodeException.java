public class InvalidMorseCodeException extends Throwable
{
    InvalidMorseCodeException()
    {

    }
    public String toString()
    {
        return "InvalidMorseCodeException, a code entered was not valid morse code";
    }
}
