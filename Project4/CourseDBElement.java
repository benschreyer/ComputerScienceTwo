/**
* 
* Course Data Base Element
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-19
*/
public class CourseDBElement implements Comparable
{
	private int CRN;
	private int credits;
	private String courseID;
	private String roomNumber;
	private String instructorName;
	
	public CourseDBElement(String cid, int crn, int cr, String rn, String in) {
		courseID = cid;
		CRN = crn;
		credits = cr;
		roomNumber = rn;
		instructorName = in;
	}
	public CourseDBElement() {
		courseID = "NONE";
		CRN = 0;
		credits = 0;
		roomNumber = "NONE";
		instructorName = "NONE";
	}

	public boolean equals(CourseDBElement element)
	{
		return this.compareTo(element) == 0;
	}
	
	@Override
	public int compareTo(CourseDBElement element) 
	{
		return this.CRN - element.getCRN();
	}
	
	public int getCRN() 
	{
		return CRN;
	}

	public int getCredits()
	{
		return credits;
	}
	
	public String getCourseID()
	{
		return courseID;
	}
	
	public String getRoomNumber()
	{
		return roomNumber;
	}
	
	public String getInstructorName()
	{
		return instructorName;
	}
	
	
	public void setCRN(int crn) 
	{
		CRN = crn;
	}

	public void setCredits(int cred)
	{
		credits = cred;
	}
	
	public void setCourseID(String cid)
	{
		courseID = cid;
	}
	
	public void setRoomNumber(String rn)
	{
		roomNumber = rn;
	}
	
	public void setInstructorName(String in)
	{
		instructorName = in;
	}
	
	public int hashCode()
	{
		return CRN;
	}
	
}
