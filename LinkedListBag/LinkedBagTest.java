//Ben Schreyer 9-11-2020
public class LinkedBagTest 
{
	public static void main(String[] args)
	{
		LinkedBag<String> bag = new LinkedBag<String>();
		bag.add(new String("Hello!"));
		bag.add(new String("Hello!2"));
		bag.add(new String("Hello!5"));
		bag.add(new String("Hello!5"));
		bag.add(new String("Hello!5"));
		bag.add(new String("Hello!2"));
		bag.add(new String("Hello!"));
		for(Object c : bag.toArray())
		{
			System.out.println((String)c);
		}
		System.out.println("\n\n"+bag.remove()+"\n\n");
		bag.add(new String("Hello32"));
		bag.remove("Hello!");
		
		System.out.println("\n\ntest\n\n");
		for(Object c : bag.toArray())
		{
			System.out.println((String)c);
		}
		System.out.println(bag.contains("Hello32"));
		System.out.println(bag.contains("Hello!"));
		System.out.println(bag.contains("Hello!5"));
		System.out.println(bag.getFrequencyOf("Hello!2"));
		System.out.println(bag.contains("Hello!55"));
		System.out.println(bag.getCurrentSize());
		bag.clear();
		System.out.println("Clear Test!");
		for(Object c : bag.toArray())
		{
			System.out.println((String)c);
		}
		System.out.println(bag.isEmpty());
	}
}
