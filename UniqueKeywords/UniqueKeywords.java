// Ben Schreyer October 26 2020



import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UniqueKeywords
{
	public static void main(String[] args) throws IOException
	{
		 String text = "";
		 Scanner scan = new Scanner(System.in);
		 //prompt for and try file path until a valid file is found
		 while(true)
		 {
			 try 
			 {
				 System.out.println("Give a valid path to a Java file...");
				 String path = scan.nextLine();
				 text = new String(Files.readAllBytes(Paths.get(path)));
				 break;
			 } 
			 catch (IOException e) 
			 {
				 System.out.println("Invalid path, try again.");
			      continue;
			 }
		 }
		 scan.close();
		 //remove all non numeric/alpha chars

		text = text.replaceAll("[^a-zA-Z0-9_]"," ");
		//split the string on spaces to get words
		String[] tokens = text.split(" ");
		//Java keywords
		String[] keywords = {"abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "Integer", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while", "_"};
		//HashMap to count occurences of keywords
	
		HashMap<String, Integer> seen = new HashMap<String, Integer>();
		for(String s: keywords)
		{
			seen.put(s, new Integer(0));
		}
		
		//Increment counter for keyword for each token that matches
		for(String s: tokens)
		{
			Integer t = seen.get(s);
			if(t != null)
			{
				seen.put(s, new Integer(t.intValue() + 1));
			}
		}
		ArrayList<String> exist = new ArrayList<String>();
		//Gather and sort keywords that exist in the list, add a label for amount
		for(String s: keywords)
		{
			Integer t=seen.get(s);
			if(t.intValue() > 0)
			{
				exist.add(s + " "+t.toString());
			}
		}
		exist.sort(null);
		for(String s: exist)
		{
				System.out.println(s);
		}
	}
}
