/**
* 
* Course Data Base Manager
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-19
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface 
{

	CourseDBStructure db;
	/**
	   * Constructor
	   * @return New object
	   */
	CourseDBManager()
	{
		db = new CourseDBStructure(499);
	}
	//	public CourseDBElement(String cid, int crn, int cr, String rn, String in)
	/**
	   * Add an element to the database
	   * @param Course ID
	   * @param CRN
	   * @param Credits
	   * @param Room number
	   * @param Instructor
	   */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		db.add(new CourseDBElement(id, crn, credits, roomNum, instructor));

	}
	/**
	   * Get an element by CRN
	   * @param CRN
	   * @return Element if found, null if not found
	   */
	@Override
	public CourseDBElement get(int crn) 
	{
			try {
				return db.get(crn);
			}
			catch(Exception e)
			{
				return null;
			}
		
	}
	/**
	   * Read newline seperate courses in from text file
	   * @param File to read in
	   */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{

		Scanner scan;
		scan = new Scanner(input);
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] split = line.split(" ");
			String name = "";
			for(int i = 4;i < split.length;i++)
			{
				if(split[i] != "")
				{
					name+=" " + split[i];
				}
			}
			name = name.trim();
			db.add(new CourseDBElement(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], name));
		}
		scan.close();
		


	}
	/**
	   * Get all entries as an ArrayList of string representations
	   * @return 
	   */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(CourseDBElement e: db.toArray())
		{
			String line = "\nCourse:"+e.getCourseID() + " CRN:" + Integer.toString(e.getCRN()) + " Credits:" + e.getCredits()+ " Instructor:" + e.getInstructorName() + " Room:" + e.getRoomNumber();
			ret.add(line);
		}
		Collections.sort(ret);
		return ret;
	}

}
