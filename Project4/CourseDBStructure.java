/**
* 
* Course Data Base Structure
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-19
*/

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class CourseDBStructure implements CourseDBStructureInterface 
{

	private int entries;
	private String name;
	public LinkedList<CourseDBElement>[] hashTable;
	private int hash(String CRN)
	{
		return Integer.parseInt(CRN) % (hashTable.length);
	}
	
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
	@SuppressWarnings("unchecked") 
	CourseDBStructure(String n)
	{
		entries = 0;
		name = n;
		hashTable = new LinkedList[25];
		for(int i = 0;i < 25;i++)
		{
			hashTable[i] = null;
		}
	}
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

	@Override
	public int getTableSize() 
	{
		return hashTable.length;
	}

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
		return ret;
	}

}
