import java.util.ArrayList;
import java.util.Random;


// The class will represent the stock itself of the integers - this class will be the monitor class
// It will get from the user the length of the Stock
public class StockOfIntegers {

	private Random rnd = new Random();
	
	private ArrayList<Integer> stockArray;
	private int lengthOfStock;
	private final int START_RANGE = 1, END_RANGE = 100;
	
	
	//Initialize the monitor
	public StockOfIntegers(int lengthOfStock) {
		
		this.stockArray = new ArrayList<Integer>(lengthOfStock);
		this.lengthOfStock = lengthOfStock;
	}
	
	
	// The method will be reponsible for initialize the arraylist with its random members 
	// from 1-100
	public void initWithRandomValues() {
		
		for(int i = 0; i<lengthOfStock; i++)
			this.stockArray.add( rnd.nextInt( END_RANGE - START_RANGE) + START_RANGE );
		
		//Print of the array
		System.out.println(this.stockArray);	
	}

	
	
	// return the current Array size
	public synchronized int getStockSize() {
		return this.stockArray.size();
	}
		

	// The method will access the array and return its final summary of all past cells 
	//- which will be located at the first index as the only member of the arraylist
	public synchronized int getSumOfArray() {
			
		// return the sum
		return this.stockArray.get(0);
	}
	
	// the method will return a 2 cells array, which will contain both members to calculate sum!
	public synchronized int[] getTwoMembers() {
		
		int[] twoMembersToReturn = new int[2];
		
		while(this.stockArray.size() == 0 || this.stockArray.size() == 1) {
			//System.out.println(this.printArray());
			
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception at getTwoMembers");
			}
		}
		
		// remove both first cells
		twoMembersToReturn[0] = this.stockArray.remove(0);
		twoMembersToReturn[1] = this.stockArray.remove(0);
		
		return twoMembersToReturn;
	}
	
	// the method which will insert the sum that calculated to the Stock
	public synchronized void insertSum(int sumOfTwo) {
		
		this.stockArray.add(sumOfTwo);
		notifyAll();	
	}
}
