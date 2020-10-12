import java.util.ArrayList;

public class ArrayStack<T> implements StackInterface<T>
{
	ArrayList<T> stack = new ArrayList<T>();
	@Override
	public boolean isEmpty() {
	
		return stack.size() == 0;
	}

	@Override
	public boolean isFull() {

		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(stack.size() < 1)
		{
			throw new StackUnderflowException();
		}
		else
		{
			T temp = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return temp;
		}

	}

	@Override
	public T top() throws StackUnderflowException {
		return stack.get(stack.size()-1);
	}

	@Override
	public int size() {

		return stack.size();
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		stack.add(e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		String ret = stack.get(0).toString();
		for(int i = 1;i < stack.size();i++)
		{
			T item = stack.get(i);
			ret+= delimiter + item.toString();
		}
		return ret;
	}

	@Override
	public void fill(ArrayList<T> list) {
		for(T item : list)
		{
			try {
				this.push(item);
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		
	}

}
