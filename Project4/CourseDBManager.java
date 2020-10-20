import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface 
{

	CourseDBStructure db;
	
	CourseDBManager()
	{
		db = new CourseDBStructure(40);
	}
	//	public CourseDBElement(String cid, int crn, int cr, String rn, String in)
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		db.add(new CourseDBElement(id, crn, credits, roomNum, instructor));

	}

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
