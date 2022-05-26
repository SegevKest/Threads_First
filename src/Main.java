
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);

		
		StockOfIntegers stock;
		SumThread[] arrayOfAllThreads;
		
		int lengthOfStock, numberOfThreads, sumOfArray;
		
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
			
			arrayOfAllThreads[i] = new SumThread(stock.getStock());
		}
		
		for( int i =0; i<numberOfThreads; i++) {
			
			arrayOfAllThreads[i].start();
		}
		
	}

}
