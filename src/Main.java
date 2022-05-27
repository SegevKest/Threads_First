
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);

		
		StockOfIntegers stock;
		SumThread[] arrayOfAllThreads;
		
		int lengthOfStock, numberOfThreads, sumOfArray = 0;
		
		// Get input from users
		System.out.println("Please insert the length of the Stock of integers: ");
		lengthOfStock = scan.nextInt();
		
		System.out.println("Please insert the number of Threads: ");
		numberOfThreads = scan.nextInt();
		
		
		// Initialize the Stock and array of threads
		stock = new StockOfIntegers(lengthOfStock);
		arrayOfAllThreads = new SumThread[numberOfThreads];
		
		//initialize with Random Value
		stock.initWithRandomValues();
		
		for( int i =0; i<numberOfThreads; i++) {
			
			arrayOfAllThreads[i] = new SumThread(stock);
		}
		
		for( int i =0; i<numberOfThreads; i++) {
			
			arrayOfAllThreads[i].start();
		}
		
		
		// Wait for all the Threads to finish running
		for( int i =0; i<numberOfThreads; i++) {
			
			try {
				arrayOfAllThreads[i].join();
			} catch (InterruptedException e) {
				System.out.println(i + " Thread was interrupted");
			}
		}
		
		
		
		sumOfArray = stock.getSumOfArray();
		System.out.println("The Summary of the array is: " + sumOfArray);
		
	}

}
