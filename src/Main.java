import java.util.Scanner;


// The main class will contain the main program, which initialize the array of threads and gets the input from the user
public class Main {
	
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		StockOfIntegers stock;
		SumThread[] arrayOfAllThreads;
		int lengthOfStock, numberOfThreads, sumOfArray = 0;
		
		
		// Get input from users
		// insert the length of stock
		System.out.println("Please insert the length of the Stock of integers: ");
		lengthOfStock = scan.nextInt();
		
		// insert the number of threads
		System.out.println("Please insert the number of Threads: ");
		numberOfThreads = scan.nextInt();
		
		scan.close();
		
		
		//Initialize
		// Initialize the Stock and array of threads with values from user
		stock = new StockOfIntegers(lengthOfStock);
		arrayOfAllThreads = new SumThread[numberOfThreads];
		
		//initialize with Random Value
		stock.initWithRandomValues();
		
		// Initialize each thread
		for( int i =0; i<numberOfThreads; i++) {
			arrayOfAllThreads[i] = new SumThread(stock);
		}
		
		// start each thread
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
		
		
		
		// Get the sum of the array after finishing all threads work
		sumOfArray = stock.getSumOfArray();
		System.out.println("The Summary of the array is: " + sumOfArray);
		
	}

}
