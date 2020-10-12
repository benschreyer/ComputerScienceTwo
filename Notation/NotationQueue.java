
/**
* 
* Generic queue class implemented as doubly linked structure
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-09-19 
*/
import java.util.ArrayList;
public class NotationQueue<T> implements QueueInterface<T>
{

	private DoubleLinkNode<T> root;
	private DoubleLinkNode<T> end;
	private int count;
	private int limit;
	 /**
	   * Constructor for memory limited queue
	   * 
	   */
	NotationQueue()
	{
		root = null;
		end = null;
		count = 0;
		limit = -1;
	}
	 /**
	   * Constructor for user limited queue
	   * @param maximum items in queue
	   */
	NotationQueue(int l)
	{
		root = null;
		end = null;
		count = 0;
		limit = l;
	}
	 /**
	   * Get if list is empty
	   * @return boolean, true if queue is empty
	   */
	@Override
	public boolean isEmpty() {
		
		return count == 0;
	}
	 /**
	   * Get if list is full
	   * @return boolean, true if amount of items in queue is greater than or equal to the user limit
	   */
	@Override
	public boolean isFull() {
		
		return limit > -1 && count >= limit;
	}

	@Override
	 /**
	   * Get an item from the queue
	   * @return T, the item added to the queue longest ago
	   */
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		DoubleLinkNode<T> temp = end;
		T ret = end.getData();
		if(count == 1)
		{
			root = null;
			end = null;
			count = 0;
		}
		else
		{
			end = end.getPrev();
			end.setNext(null);
			count--;
		}
		temp.setNext(null);
		temp.setPrev(null);
		//System.out.println(this.toString(" "));
		return ret;
	}
	 /**
	   * Get the amount of items in the queue
	   * @return int, amount of items in queue
	   */
	@Override
	public int size() {
	
		return count;
	}
	 /**
	   * Add an item to the queue
	   * @param item to add
	   * @return if the item was added successfully
	   */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(count == limit)
		{
			throw new QueueOverflowException();
		}
		if(count == 0)
		{
			root = new DoubleLinkNode<T>();
			root.setData(e);
			root.setPrev(null);
			root.setNext(null);
			end = root;
			count++;
		}
		else {
		count++;
		DoubleLinkNode<T> temp = root;
		root = new DoubleLinkNode<T>();
		root.setData(e);
		root.setPrev(null);
		root.setNext(temp);
		temp.setPrev(root);
		}
		return true;
	}
	 /**
	   * Concatenate queue items into a string with toString() and a delimiter
	   * @param delimeter to use
	   * @return String, string representation of the queue
	   */
	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		if (count == 0 )
		{
			return new String("");
		}
		DoubleLinkNode<T> iter = end.getPrev();
		String ret = end.getData().toString();
		while (iter != null)
		{
			ret+= delimiter + iter.getData().toString();
			iter = iter.getPrev();
		}
		return ret;
	}
	 /**
	   * Concatenate queue items into a string with toString() and no delimiter
	   * @return String, string representation of the queue, no delimiter
	   */
	public String toString()
	{
		return this.toString("");
	}
	 /**
	   * Enqueue an ArrayList of items into the queue
       * @param ArrayList of T to enqueue
	   */
	@Override
	public void fill(ArrayList<T> list) {
		for(T item : list)
		{
			try {
				this.enqueue(item);
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		
	}

}
