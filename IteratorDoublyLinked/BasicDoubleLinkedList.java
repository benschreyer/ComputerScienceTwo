/**
* 
* Doubly Linked List Generically Typed With Method Accessed Iterator Subclass
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-10-12
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<E>
{

	
	//Protected fields and classes are needed for use in inheriting classes
	
	//Linked node class for internal use
	protected class Node<T>
	{
		private Node<T> next;
		private Node<T> prev;
		private T data;

		Node()
		{
			next = null;
			prev = null;
		}
		public T getData()
		{
			return data;
		}
		
		public void setData(T s)
		{
			data = s;
		}
		
		public Node<T> getNext()
		{
			return next;
		}
		
		public void setNext(Node<T> n)
		{
			next = n;
		}
		
		public Node<T> getPrev()
		{
			return prev;
		}
		
		public void setPrev(Node<T> n)
		{
			prev = n;
		}
	}
	
	//Iterator to return to user
	private class Iterator<T> implements ListIterator
	{
		
		private Node<E> curr;
		
		Iterator()
		{
			curr = head;
		}
		
		public E next()
		{
			if(!this.hasNext())
			{
				throw new NoSuchElementException();
			}
			E temp = curr.getData();
			curr = curr.getNext();
			return temp;
		}
		
		public E previous()
		{
			if(curr == null)
			{
				curr = tail;
				return curr.getData();
			}
			if(curr.getPrev() != null)
			{
				curr = curr.getPrev();
				return curr.getData();
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		
		public boolean hasNext()
		{
			return curr != null;
		}
		
		public boolean hasPrevious()
		{
			return curr == null || curr.getPrev() != null;
		}

		@Override
		public void add(Object arg0) {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(Object arg0) {
			throw new UnsupportedOperationException();
			
		}
	}
	
	protected Node<E> head;
	protected Node<E> tail;
	protected int size;
	 /**
	   * Constructor
	   * @return BasicDoubleLinkedList<T>
	   */
	BasicDoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	 /**
	   * Get an iterator over the collection starting with the head element
	   * @return Iterator over the collection initialized on the head element
	   */
	public ListIterator<E> iterator()
	{
		return new Iterator<E>();
	}
	 /**
	   * Get the number of elements in the list
	   * @return Integer number of elements
	   */
	public int getSize()
	{
		return size;
	}
	 /**
	   * Get the last element of the list
	   * @return The last element
	   * @exception NoSuchElementException
	   */
	public E getLast()
	{
		if(tail != null)
		{
			return tail.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	/**
	   * Get the first element of the list
	   * @return The first element
	   * @exception NoSuchElementException
	   */
	public E getFirst()
	{
		if(head != null)
		{
			return head.getData();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	/**
	   * Get the first element of the list and remove it
	   * @return The first element
	   * @exception NoSuchElementException
	   */
 	public E retrieveFirstElement()
 	{
 		if(head != null)
		{
 			E temp = head.getData();
			head.getNext().setPrev(null);
			head = head.getNext();
			size--;
			return temp;
			
		}
		else
		{
			throw new NoSuchElementException();
		}
 	}
 	/**
	   * Get the last element of the list and remove it
	   * @return The last element
	   * @exception NoSuchElementException
	   */
 	public E retrieveLastElement()
 	{
 		if(tail != null)
		{
 			E temp = tail.getData();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			size--;
			return temp;

		}
		else
		{
			throw new NoSuchElementException();
		}
 	}
 	/**
	   * Add an element to the end of the list 
	   * @param Data to add
	   */
 	public void addToEnd(E data)
 	{
 		if(size < 1)
 		{
 			tail = new Node<E>();
 			tail.setNext(null);
 			tail.setPrev(null);
 			tail.setData(data);
 			head = tail;
 			
 		}
 		else
 		{
 			tail.setNext(new Node<E>());
 			tail.getNext().setPrev(tail);
 			tail = tail.getNext();
 			tail.setData(data);
 			
 			tail.setNext(null);
 		}
 		size++;
 	}
 	/**
	   * Add an element to the front of the list
	   *@param Data to add
	   */
 	public void addToFront(E data)
 	{
 		if(size < 1)
 		{
 			tail = new Node<E>();
 			tail.setNext(null);
 			tail.setPrev(null);
 			tail.setData(data);
 			head = tail;
 			
 		}
 		else
 		{
 			head.setPrev(new Node<E>());
 			head.getPrev().setNext(head);
 			head = head.getPrev();
 			head.setData(data);
 			head.setPrev(null);
 		}
 		size++;
 	}
 	/**
	   * Remove the first instance of an element from the list
	   * @param Element to match and remove with comparator
	   * @param Comparator to use
	   * @return The modified list
	   */
 	public BasicDoubleLinkedList<E> remove(E targetData, Comparator<E> comparator)
 	{
 		if(size == 0)
 		{
 			return this;
 		}
 		Node<E> iter = head;
 		while(iter != null)
 		{
 			if(comparator.compare(iter.getData(), targetData) == 0)
 			{
 				if(head == iter)
 				{
 					head = iter.getNext();
 				}
 				if(tail == iter)
 				{
 					tail = iter.getPrev();
 				}
 				
 				if(size == 1)
 				{
 					head = null;
 					tail = null;
 					size--;
 					return this;
 				}
 				if(iter.getPrev() != null)
 				{
 					iter.getPrev().setNext(iter.getNext());
 				}
 				if(iter.getNext() != null)
 				{
 					iter.getNext().setPrev(iter.getPrev());
 				}
 				size--;
 				return this;
 				
 			}
 			iter = iter.getNext();
 		}
 		return this;
 	}
 	/**
	   * Get list as an ArrayList
	   * @return ArrayList containing the elements in the same order
	   */
 	public ArrayList<E> toArrayList()
 	{
 		ArrayList<E> ret = new ArrayList<E>();
 		Node<E> iter = head;
 		while(iter != null)
 		{
 			ret.add(iter.getData());
 			iter=iter.getNext();
 		}
 		return ret;
 	}
	
	
}
