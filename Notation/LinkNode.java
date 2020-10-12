/**
* 
* Generic single link node with object for stack class
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-09-19 
*/
public class LinkNode<T> 
{
	private LinkNode<T> next;
	private T data;
	LinkNode()
	{
		next = null;
		data = null;
	}
	public LinkNode<T> getNext()
	{
		return next;
	}
	public T getData()
	{
		return data;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	public void setNext(LinkNode<T> next)
	{
		this.next = next;
	}
}
