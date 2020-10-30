/**
* 
* Course Data Base Structure
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-19
*/

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class CourseDBStructure implements CourseDBStructureInterface 
{
	
	private int entries;
	private String name;
	public LinkedList<CourseDBElement>[] hashTable;
	
	
	private class SortByCRN implements Comparator<CourseDBElement>
	{
		public int compare(CourseDBElement element, CourseDBElement element2)
		{
			return element.getCRN()-element2.getCRN();
		}
	}
	
	private int hash(String CRN)
	{
		return Integer.parseInt(CRN) % (hashTable.length);
	}
	/**
	   * Constructor with name and table size
	   * @param Name
	   * @param Table size
	   * @return New object
	   */
	@SuppressWarnings("unchecked") 
	CourseDBStructure(String n,int hashTableSize)
	{
		entries = 0;
		name = n;
		hashTable = new LinkedList[hashTableSize];
		
		for(int i = 0;i < hashTableSize;i++)
		{
			hashTable[i] = null;
		}
	}
	/**
	   * Constructor with name 
	   * @param Name
	   * @return New object
	   */
	@SuppressWarnings("unchecked") 
	CourseDBStructure(String n)
	{
		entries = 0;
		name = n;
		hashTable = new LinkedList[499];
		for(int i = 0;i < 499;i++)
		{
			hashTable[i] = null;
		}
	}
	/**
	   * Constructor with table size
	   * @param Table size
	   * @return New object
	   */
	@SuppressWarnings("unchecked") 
	CourseDBStructure(int n)
	{
		entries = 0;
		name = "None";
		hashTable = new LinkedList[n];
		for(int i = 0;i < n;i++)
		{
			hashTable[i] = null;
		}
	}
	/**
	   * Add an item to the database
	   * @param item to add
	   */
	@Override
	public void add(CourseDBElement element) 
	{
		int hash = hash(Integer.toString(element.getCRN()));
		LinkedList<CourseDBElement> head = hashTable[hash];
		if(head == null)
		{
			hashTable[hash] = new LinkedList<CourseDBElement>();
			hashTable[hash].add(element);
			entries++;
		} 
		else
		{
			try 
			{
				if(this.get(element.getCRN()) == null)
				{
					hashTable[hash].add(element);
					entries++;
				}
				
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	   * Get a course object by CRN
	   * @param CRN
	   * @return Object if found, null if the object is not contained
	   */
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		int hash = hash(Integer.toString(crn));
		ListIterator<CourseDBElement> iter = hashTable[hash].listIterator();
		while(iter.hasNext())
		{
			CourseDBElement cur = iter.next();
			if(cur.getCRN() == crn)
			{
				return cur;
			}
		}
		return null;
	}
	/**
	   * Get table size
	   * @return Hash table size
	   */
	@Override
	public int getTableSize() 
	{
		return hashTable.length;
	}
	/**
	   * Get array of courses contained in structure sorted by CRN
	   * @return Array containing all entries
	   */
	public CourseDBElement[] toArray()
	{
		CourseDBElement[] ret = new CourseDBElement[entries];
		int curr = 0;
		for(int i = 0;i < hashTable.length;i++)
		{
			if(hashTable[i] != null)
			{
				for(CourseDBElement e: hashTable[i])
				{
					ret[curr] = e;
					curr++;
				}
			}
		}
		Arrays.sort(ret, new SortByCRN());
		return ret;
	}


}
