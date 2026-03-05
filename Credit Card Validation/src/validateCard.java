import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class validateCard
	{
		static ArrayList<Long> cardNumbers = new ArrayList<Long>();
		static long cardNumber;
		public static void main(String[] args) throws IOException
			{
				Scanner userIntInput = new Scanner(System.in);
				System.out.println("Welcome! Would you like to:");
				System.out.println("(1) Check a card number.");
				System.out.println("(2) Check your text file?");
				int choice = userIntInput.nextInt();
				
				if (choice == 1)
					{
						userCheck();
						System.out.println(cardTest(cardNumber));
					}
				else if (choice == 2)
					{
						readTextFile();
						cardTest(cardNumber);
					}
				else
					{
						System.out.println("That was not an option. Please select one of the 2 options.");
					}
			}
		
		public static void userCheck()
		{
			Scanner userLongInput = new Scanner(System.in);
			System.out.println("Please enter the credit card number to see if it's valid.");
			cardNumber = userLongInput.nextLong();
		}
		
		public static void readTextFile() throws IOException
		{
			String fileName = "CCV.txt";
			Scanner fileReader = new Scanner(new File("CCV.txt"));
			while (fileReader.hasNext()) 
				{
					String CCV = fileReader.nextLine();
					cardNumbers.add(Long.parseLong(CCV));
				}
			
			
		}
		
		public static boolean cardTest(long cardNumber)
		{
			//fill array with CC#
			String cardString = String.valueOf(cardNumber);
			int[] digits = new int[16];
			for (int i = 0; i < 16; i++)
				{
					digits[i] = Character.getNumericValue(cardString.charAt(i));
				}
			
			//Step 1. Double alternating digits starting with the first digit in the sequence.
			for (int i = 0; i < 16; i+=2)
				{
					digits[i] = digits[i] * 2;
			//Step 2. If the doubling resulted in a number with two digits, add them together to get a single digit number
					if (digits[i] >= 10)
						{
							String digitString = String.valueOf(digits[i]);
							int firstDigit = digitString.charAt(0);
							int secondDigit = digitString.charAt(1);
							digits[i] = firstDigit + secondDigit;		
						}
				}
			
			//Step 4. Check to see if the sum is evenly divisible by 10 (you can simply look to see whether or not it ends with a zero).
			long finalNumber = 0;
			for (int i = 0; i < 16; i+=2)
				{
					finalNumber = (finalNumber * 10) + digits[i]; 
			
				}
			if (finalNumber % 10 == 0)
				{
					return true;
				}
			
			return false;
		}
		
			
		
		
		//Step 1. Double alternating digits starting with the first digit in the sequence.
		//Step 2. If the doubling resulted in a number with two digits, add them together to get a single digit number
		//Step 3. Now go back to the original credit number and replace the digits that you doubled with the new value — either the doubled value, or the doubled value with the digits added together — and add it all up.
		//Step 4. Check to see if the sum is evenly divisible by 10 (you can simply look to see whether or not it ends with a zero).


	}
