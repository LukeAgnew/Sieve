import javax.swing.JOptionPane;
import java.util.Scanner;

public class Sieve {
	public static void main(String[] args) {
		try
		{
			String input = JOptionPane.showInputDialog("Please enter the number N for the list of numbers "
																	+ "from 2 to N whose primes you want to find");
			Scanner inputScanner = new Scanner(input);
			
			int N = inputScanner.nextInt();
			
			inputScanner.close();
			
			boolean[] markedNumbersList = new boolean[N+1];
			
			for (int index = 0; index <= N; index++)
			{
				markedNumbersList[index] = true;
			}
			
			findPrimes(markedNumbersList);
		}
		catch (NullPointerException exception)
		{
			JOptionPane.showMessageDialog(null, "You must enter a number for N.");
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "You must enter a valid integer value for N." );
		}
	}
	
	public static void findPrimes(boolean[] markedNumbersList)
	{
				
		for (int index = 2; index <= Math.sqrt(markedNumbersList.length-1); index++)
		{
			// Check if current number is not marked Off
	
			if (markedNumbersList[index])
			{			
				markOffMultiples(index, markedNumbersList);				
			}
			
		}
		printNumbers(markedNumbersList);
		
	}
	
	public static void markOffMultiples(int currentNumber, boolean[] markedNumbersList)
	{
		for (int index = currentNumber*2; index < (markedNumbersList.length);index+=currentNumber)
		{
			markedNumbersList[index] = false;
		}
	}
	
	public static void printNumbers(boolean[] markedNumbersList)
	{
		String primeNumbersList = "The prime numbers are: ";
		for (int index = 2; index <= (markedNumbersList.length-1); index++)
		{
			if (markedNumbersList[index])
			{
				switch (index)
				{
				case 2:
					primeNumbersList = primeNumbersList + index;
					break;
				default:
					primeNumbersList = primeNumbersList + ", " + index;
					break;
				}
			}
		}
		JOptionPane.showMessageDialog(null, primeNumbersList);
	}
}
