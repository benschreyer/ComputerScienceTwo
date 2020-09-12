//Ben Schreyer 9-11-2020
public class LinkNode<T> 
{
	private T data;
	private LinkNode<T> next;
	LinkNode(T d)
	{
		data = d;
		next = null;
	}
	LinkNode(T d, LinkNode<T> n)
	{
		data = d;
		next = n;
	}
	public void setNext(LinkNode<T> n) 
	{
		next = n;
	}
	public void setData(T d) 
	{
		data = d;
	}
	public T getData()
	{
		return data;
	}
	public LinkNode<T> getNext()
	{
		return next;
	}
}
