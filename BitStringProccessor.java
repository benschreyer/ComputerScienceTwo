/*
 * Without using arithmetic one could determine whether or not a binary string has an equal amount of 1's and 0's by creating a stack for 1's and a stack for 0's 
 * and iterate the bitstring where everytime you see a 1 or a 0 you push an object onto the stack for 1 or 0
 * then you empty both stacks and if they do not become empty at the same time you can declare that the amount of 1's and 0's are not the same
 *
 * 
 * Benjamin Schreyer 9/18/2020
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.Stack;
public class BitStringProccessor {
	public static void main(String[] args)
	{
		String proccess = "1100010";
		Stack<String> zeroStack = new Stack<String>();
		Stack<String> oneStack = new Stack<String>();
		for(char c: proccess.toCharArray())
		{
			if(c == '0')
			{
				zeroStack.push(new String("t"));
			
			}
			if (c == '1')
			{
				oneStack.push(new String("t"));
			}
		}
		while(!zeroStack.empty())
		{
			
			if(oneStack.empty())
			{
				System.out.println("More 0's than 1's");
				break;
			}
			else
			{
				oneStack.pop();
			}
			zeroStack.pop();
		}
		if(zeroStack.empty() && !oneStack.empty())
		{
			System.out.println("More 1's than 0's");
		}
		if(zeroStack.empty() && oneStack.empty())
		{
			System.out.println("Equal count of 1's and 0's");
		}

	}
	
}
