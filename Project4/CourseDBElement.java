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
	/**
	   * Constructor used to fill fields
	   * @param Course ID
	   * @param Course Number
	   * @param Credits
	   * @param Room Number
	   * @param Instructor Name
	   * @return New CourseDBElement
	   */
	public CourseDBElement(String cid, int crn, int cr, String rn, String in) {
		courseID = cid;
		CRN = crn;
		credits = cr;
		roomNumber = rn;
		instructorName = in;
	}
	/**
	   * Constructor used to create empty object
	   * @return New CourseDBElement
	   */
	public CourseDBElement() {
		courseID = "NONE";
		CRN = 0;
		credits = 0;
		roomNumber = "NONE";
		instructorName = "NONE";
	}
	/**
	   * Equality of courses, uses CRN
	   * @param Element to check against
	   * @return Boolean representing equality
	   */
	public boolean equals(CourseDBElement element)
	{
		return this.compareTo(element) == 0;
	}
	/**
	   * Compare to another course
	   * @param Other course to compare to
	   * @return Signed int, 0 for equal, -1 for less than
	   */
	@Override
	public int compareTo(CourseDBElement element) 
	{
		return this.CRN - element.getCRN();
	}
	/**
	   * Getter for CRN
	   * @return CRN
	   */
	public int getCRN() 
	{
		return CRN;
	}
	/**
	   * Getter for credits
	   * @return credits
	   */
	public int getCredits()
	{
		return credits;
	}
	/**
	   * Getter for course ID
	   * @return course ID
	   */
	public String getCourseID()
	{
		return courseID;
	}
	/**
	   * Getter for room number
	   * @return Room number
	   */
	public String getRoomNumber()
	{
		return roomNumber;
	}
	/**
	   * Getter for instructor name
	   * @return Instructor name
	   */
	public String getInstructorName()
	{
		return instructorName;
	}
	
	/**
	   * Setter for CRN
	   * @param CRN
	   */
	public void setCRN(int crn) 
	{
		CRN = crn;
	}
	/**
	   * Setter for credits
	   * @param Credits
	   */
	public void setCredits(int cred)
	{
		credits = cred;
	}
	/**
	   * Setter for course ID
	   * @param course ID
	   */
	public void setCourseID(String cid)
	{
		courseID = cid;
	}
	/**
	   * Setter for room number
	   * @param Room number
	   */
	public void setRoomNumber(String rn)
	{
		roomNumber = rn;
	}
	/**
	   * Setter for instructor name
	   * @param Instructor name
	   */
	public void setInstructorName(String in)
	{
		instructorName = in;
	}
	/**
	   * Get hash code
	   * @return CRN
	   */
	public int hashCode()
	{
		return CRN;
	}
	
	public String toString()
	{
		return "Course:"+this.getCourseID() + " CRN:" + Integer.toString(this.getCRN()) + " Credits:" + this.getCredits()+ " Instructor:" + this.getInstructorName() + " Room:" + this.getRoomNumber();
		
	}
	
}
