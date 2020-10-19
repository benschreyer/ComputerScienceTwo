/**
* 
* Sorted Doubly Linked List Generically Typed With Method Accessed Iterator Subclass
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-12
*/
import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> 
{
	//comparator to use for sorting
	Comparator<T> comp;
	/**
	   * Constructor
	   * @param Comparator to use
	   * @return SortedDoubleLinkedList that was constructed
	   */
	SortedDoubleLinkedList(Comparator<T> c)
	{
		super();
		comp = c;
	}
	/**
	   * Invalid Method Inherited 
	   * @param Unused
	   */
	@Override
	public void addToFront(T add)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	   * Invalid Method Inherited 
	   * @param Unused
	   */
	@Override
	public void addToEnd(T add)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	   * Add an element into the sorted list
	   * @param Element to add
	   */
	public void add(T add)
	{
		size++;
		if(size == 1)
		{
			head = new Node<T>();
			tail = head;
			head.setData(add);
			head.setNext(null);
			head.setNext(null);
			return;
		}
		//edge cases with abnormal insertion
		if(comp.compare(add, head.getData()) < 0)
		{
			Node<T> temp = head;
			head = new Node<T>();
			head.setNext(temp);
			head.setData(add);
			head.setPrev(null);
			temp.setPrev(head);
			return;
		}
		if(comp.compare(add, tail.getData())>=0)
		{
			Node<T> temp = tail;
			tail = new Node<T>();
			tail.setPrev(temp);
			tail.setData(add);
			tail.setNext(null);
			temp.setNext(tail);
			return;
		}
		//all other cases
		Node<T> iter = head.getNext();
		while(iter != null)
		{
			if(comp.compare(add, iter.getData()) < 0)
			{
				iter.getPrev().setNext(new Node<T>());
				iter.getPrev().getNext().setData(add);
				iter.getPrev().getNext().setNext(iter);
				iter.getPrev().getNext().setPrev(iter.getPrev());
				iter.setPrev(iter.getPrev().getNext());
				return;
			}
			iter = iter.getNext();
		}
	}
}
