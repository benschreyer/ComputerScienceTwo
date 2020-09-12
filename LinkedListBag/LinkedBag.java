//Ben Schreyer 9-11-2020
public class LinkedBag<T> implements BagInterface<T>
{
	private LinkNode<T> start;
	private int count;
	LinkedBag()
	{
		count = 0;
		start = null;
	}
	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		if(count > 0)
		{
			LinkNode<T> temp = start;
			start = new LinkNode<T>(newEntry, temp);
			count++;
			return true;
		}
		else
		{
			start = new LinkNode<T>(newEntry, null);
			count++;
			return true;
			
		}
	}

	@Override
	public boolean remove(T anEntry) {
		
		int c = 0;
		LinkNode<T> iter = start;
		LinkNode<T> prev = null;
		while(c < count || iter == null)
		{
			if(iter.getData().equals(anEntry))
			{
				if(prev == null)
				{
					start = iter.getNext();
				}
				else
				{
					prev.setNext(iter.getNext());
				}
				count--;
				return true;
			}
			prev = iter;
			iter = iter.getNext();
		
			c++;
		}
			

		
		return false;
	}

	@Override
	public int getFrequencyOf(Object anEntry) {
		// TODO Auto-generated method stub
		int total = 0;
		int c = 0;
		LinkNode<T> iter = start;
		while(c < count && iter != null)
		{
			if(iter.getData().equals(anEntry))
			{
				total++;
			}
			iter = iter.getNext();
		
			c++;
		}
		return total;
	}

	@Override
	public boolean contains(Object anEntry) {
		// TODO Auto-generated method stub
		int c = 0;
		LinkNode<T> iter = start;
		while(c < count && iter != null)
		{
			if(iter.getData().equals(anEntry))
			{
				return true;
			}
			iter = iter.getNext();
		
			c++;
		}
		return false;
	}
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return count;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count < 1;
	}
	@Override
	public T remove() {
		if(count > 0)
		{
			LinkNode<T> temp = start;
			start = temp.getNext();
			count--;
			return temp.getData();
		}
		return null;
	}
	@Override
	public void clear() {
		start = null;
		count = 0;
		
	}
	@Override
	public T[] toArray() {
		LinkNode<T> iter = start;
		T ret[] =(T[]) new Object[count];
		for(int i = 0;i < count;i++)
		{
			ret[i] = iter.getData();
			iter = iter.getNext();
		}
		return ret;
	}
}
