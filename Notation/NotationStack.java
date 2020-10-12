/**
* 
* Generic queue class implemented as singly linked structure
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-09-19 
*/
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>{
	private LinkNode<T> root;
	private int count;
	private int limit;
	 /**
	   * Construct a memory limited stack
	   */
	NotationStack()
	{
		limit = -1;
		count = 0;
		root = null;
	}
	 /**
	   * Construct a user limited stack
	   * @param maximum items in stack
	   */
	NotationStack(int l)
	{
		limit = l;
		count = 0;
		root = null;
	}
	 /**
	   * Get whether the stack is empty
	   * @return boolean, true if no items in stack
	   */
	@Override
	public boolean isEmpty() 
	{
		
		return root == null;
	}
	 /**
	   * Get whether the stack is full
	   * @return boolean, true if stack is full
	   */
	@Override
	public boolean isFull() 
	{
		return limit > -1 && count >= limit;
	}

	 /**
	   * Get item added most recently and remove it from the stack
	   * @return T, the item added most recently to the stack
	   */
	@Override
	public T pop() throws StackUnderflowException {
		if(root == null || count == 0)
		{
			throw new StackUnderflowException();
		}
		LinkNode<T> temp = root;
		root = root.getNext();
		count--;
		return temp.getData();
	}
	/**
	   * Get item added most recently
	   * @return T, the item added most recently to the stack
	   */
	@Override
	public T top() throws StackUnderflowException {
		if(root == null)
		{
			throw new StackUnderflowException();
		}
		return  root.getData();
	}
	/**
	   * Get the number of items in the stack
	   * @return int, the amount of items in the stack
	   */
	@Override
	public int size() {

		return count;
	}
	/**
	   * Adds and item to the stack
	   * @param T, the item to add to the stack
	   */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(limit == count)
		{
			throw new StackOverflowException();
		}
		LinkNode<T> temp = root;
		root = new LinkNode<T>();
		root.setData(e);
		root.setNext(temp);
		count++;
		return true;
	}
	/**
	   * Get a String representation of the stack separated with a delimiter using toString() on objects
	   * @param String, the delimiter to use
	   * @return String, representation of the stack as a String
	   */
	@Override
	public String toString(String delimiter) {
		String ret = root.getData().toString();
		LinkNode<T> iter = root.getNext();
		while(iter != null)
		{
			
			String add =  iter.getData().toString() + delimiter ;
			StringBuilder sb = new StringBuilder(add);
			sb.reverse();
			ret+= sb.toString();
			iter = iter.getNext();
		}
		StringBuilder sb = new StringBuilder(ret);
		sb.reverse();
		return sb.toString();
	}
	/**
	   * Get a String representation of the stack separated with no delimiter using toString() on objects
	   * @return String, representation of the stack as a String
	   */
	public String toString()
	{
		return this.toString("");
	}
	 /**
	   * Push an ArrayList of items onto the stack
     * @param ArrayList of T to push
	   */
	@Override
	public void fill(ArrayList<T> list) {
		for(T item: list)
		{
			try
			{
				this.push(item);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				break;
			}
			
		}
		
	}

}
