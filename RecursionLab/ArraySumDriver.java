import java.util.Arrays;
import java.util.function.BinaryOperator;
//Ben Schreyer September 25 2020
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		double sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5) + sumOfArrayGeneric(myArray,5);
		System.out.println(sum);
		
		for(int i = 1;i < 20;i++)
		{
			System.out.println(fibonacci(i));
		}
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static int sumOfArray(Integer[] arr, int num) {
		if(num == -1)
		{
			return 0;
		}

		return arr[num] + sumOfArray(arr, num - 1);
		
	}

	public static <T extends Number> double sumOfArrayGeneric(T[] arr, int num) {
		if(num == -1)
		{
			return new Double(0.0);

		}

		return arr[num].doubleValue() + sumOfArrayGeneric(arr, num - 1) ;
		
	}
	public static int fibonacci(int n)
	{
		return fibonacci(1,1,n);
	}
	public static int fibonacci(int a, int b,int n)
	{
		if( n - 1== 0)
		{
			return a;
		}
		return fibonacci(b, a + b, n-1);
	}

}