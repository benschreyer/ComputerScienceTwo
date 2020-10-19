// Ben Schreyer October 19 2020



import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UniqueWords 
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
				 System.out.println("Give a valid path to a text file...");
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
		 //remove all chars besides punctuation from the text
		text = text.replaceAll("[^a-zA-Z]"," ");
		//split the string on spaces to get words
		String[] tokens = text.split(" ");
		
		//create a set so that repeat items are not included twice
		HashSet<String> unique = new HashSet<String>();
		
		for(String s: tokens)
		{
			//add all strings in the split string to the set
			if(!s.equals(""))
			{
				unique.add(s.toLowerCase());
			}
		}
		//get the set as an array, sort it, then print it
		String[] sorted = new String[unique.size()];
		sorted = unique.toArray(sorted);
		Arrays.sort(sorted);
		for(String s: sorted)
		{
				System.out.println(s);
		}
	}
}
