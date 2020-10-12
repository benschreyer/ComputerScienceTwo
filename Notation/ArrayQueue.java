import java.util.ArrayList;

public class ArrayQueue<T> implements QueueInterface<T>{
	ArrayList<T> queue;
	@Override
	public boolean isEmpty() {

		return queue.size() == 0;
	}

	@Override
	public boolean isFull() {

		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(queue.size() < 1)
		{
			throw new QueueUnderflowException();
		}
		T temp = queue.get(0);
		queue.remove(0);
		return temp;
	}

	@Override
	public int size() {

		return queue.size();
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		queue.add(e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		String ret = queue.get(0).toString();
		for(int i = 1;i < queue.size();i++)
		{
			T item = queue.get(i);
			ret+= delimiter + item.toString();
		}
		return ret;
	}

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
