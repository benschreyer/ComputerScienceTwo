/**
* 
* Generic double link node with object for queue class
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-09-19 
*/
public class DoubleLinkNode<T> 
{
	private DoubleLinkNode<T> prev;
	private DoubleLinkNode<T> next;
	private T data;
	DoubleLinkNode()
	{
		prev = null;
		next = null;
		data = null;
	}
	public DoubleLinkNode<T> getNext()
	{
		return next;
	}
	
	public T getData()
	{
		return data;
	}
	public DoubleLinkNode<T> getPrev()
	{
		return prev;
	}
	public void setData(T data)
	{
		this.data = data;
	}
	public void setNext(DoubleLinkNode<T> next)
	{
		this.next = next;
	}
	public void setPrev(DoubleLinkNode<T> prev)
	{
		this.prev= prev;
	}
}
