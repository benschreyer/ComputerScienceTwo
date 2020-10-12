/**
* 
* Utility class to be called by GUI
*
* @author  Ben Schreyer
* @version 1.0
* @since   2020-09-19 
*/
public class Notation 
{
	 /**
	   * Utility for class
	   * @param a character left in a >= b
	   * @param b character right in a >= b
	   * @return boolean, a >= b
	   */
	private static boolean precedenceEqualOrHigher(char a, char b)
	{
		//a equal or higher b
		if("/*".contains(Character.toString(b)))
		{
			return true;
		}
		if("+-".contains(Character.toString(a)))
		{
			return true;
		}
		return false;
	}
	 /**
	   * converts infix string to postfix string
	   * @param infix expression
	   * @return postfix conversion
	   * @exception InvalidNotationFormatException
	   */
	public static String convertInfixToPostfix(String infix) throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException, QueueOverflowException
	{
		try {
		NotationStack<Character>  stack = new NotationStack<Character>();
		NotationQueue<Character>  queue = new NotationQueue<Character>();
		for(char t : infix.toCharArray())
		{
			
			if(Character.isDigit(t))
			{
				queue.enqueue(new Character(t));
			}
			else if("+-/*".contains(Character.toString(t)))
			{
				while(!stack.isEmpty() && precedenceEqualOrHigher(t,stack.top().charValue()) && stack.top().charValue() != '(')
				{
					char temp =  stack.pop().charValue();
					queue.enqueue(new Character(temp));
			
					
				}
				stack.push(new Character(t));
					
				
				
			}
			else if(t == '(')
			{
				stack.push(new Character('('));
			}
			else if(t == ')')
			{
				
				while(stack.top().charValue() != '(')
				{
					try
					{
						queue.enqueue(stack.pop());
					}
					catch(Exception e)
					{
						throw new InvalidNotationFormatException();
					}
				}
				stack.pop();
				}
				
			
			
		}
		while(!stack.isEmpty())
		{
			char temp = stack.pop().charValue();
			if(temp != '(')
			{
				queue.enqueue(new Character(temp));
			}
		}
		evaluatePostfixExpression(queue.toString());
		return queue.toString();
		}
		catch(Exception e)
		{
			throw new InvalidNotationFormatException();
		}
	}
	 /**
	   * converts postfix string to infix string
	   * @param postfix expression
	   * @return infix conversion
	   * @exception InvalidNotationFormatException
	   */
	public static String convertPostfixToInfix(String postfixExpression) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException
	{
		try
		{
		NotationStack<String> stack = new NotationStack<String>();
		for (char t: postfixExpression.toCharArray())
		{
			if(t == ' ')
			{
				continue;
			}
			if(Character.isDigit(t))
			{
				stack.push(new String(Character.toString(t)));
				continue;
			}
			if(stack.size() < 2)
			{
				throw new InvalidNotationFormatException();
			}
			String left = stack.pop().toString();
			String right = stack.pop().toString();
			stack.push("("+ right + Character.toString(t) + "" + left + ")");
			
		}
		if(stack.size() != 1)
		{
			throw new InvalidNotationFormatException();
		}
		return stack.pop();
	}
	catch(Exception e)
	{
		throw new InvalidNotationFormatException();
	}
	}
	 /**
	   * evaluate postfix string to double
	   * @param postfix expression
	   * @return double result
	   * @exception InvalidNotationFormatException
	   */
	public static double evaluatePostfixExpression(String exp) throws InvalidNotationFormatException, StackUnderflowException, NumberFormatException, StackOverflowException {
		try {
		NotationStack<Double> stack = new NotationStack<Double>();
		for(char t : exp.toCharArray())
		{
			if(t == ' ')
			{
				continue;
			}
			if(Character.isDigit(t))
			{
				stack.push(Double.parseDouble(Character.toString(t)));
				continue;
			}
			double val = 0;
			if(stack.size() < 2)
			{
				throw new InvalidNotationFormatException();
			}
			
			double right = stack.pop().doubleValue();
			double left = stack.pop().doubleValue();
			switch(t)
			{
			case '+':
				val = left + right;
				break;
			case '-':
				val = left - right;
				break;
			case '/':
				val = left / right;
				break;
			case '*':
				val = left * right;
				break;
			default:
				throw new InvalidNotationFormatException();
			}
			stack.push(new Double(val));
			
		}
		if(stack.size() != 1)
		{
			throw new InvalidNotationFormatException();
		}
		else
		{
			return stack.pop().doubleValue();
		}
	}
	catch(Exception e)
	{
		throw new InvalidNotationFormatException();
	}
	}
	
}
