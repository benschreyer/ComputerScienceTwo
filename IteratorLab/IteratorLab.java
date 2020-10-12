//Ben Schreyer 9/29/2020
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class IteratorLab {
	public static void main(String[] args)
	{
		boolean lost = true;
		while(lost)
		{
			
		ArrayList<Integer> values = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0;i < 20;i++)
		{
			values.add(new Integer(random.nextInt(90) + 10));
		}
		
		
		System.out.println(values);
		while(values.size() > 0)
		{
			ListIterator<Integer> itr = values.listIterator();

			boolean flag = true;
			while(itr.hasNext())
			{
				int first = itr.next();
				if(!itr.hasNext())
				{
					break;
				}
				int second = itr.next();
				if(first/10 ==second/10 || first % 10 == second % 10)
				{
					itr.remove();
					itr.previous();
					itr.remove();
					if(itr.hasNext())
					{
						itr.next();
					}
					flag = false;
				}
				if(itr.hasPrevious())
				{
					itr.previous();
				}
		
			}
			System.out.println(values);
			if(flag)
			{
				break;
			}
		}
		if(values.size() == 0)
		{
			System.out.println("The game was won");
			lost = false;
		}
		else
		{
			System.out.println("The game was lost");
			lost = true;
		}
		}
	}
}
