import java.util.ArrayList;
import java.util.Random;


// The class will represent the stock itself of the integers - this class will be the monitor class
// It will get from the user the length of the Stock

public class StockOfIntegers {

	private Random rnd = new Random();
	private ArrayList<Integer> stockArray;
	private int lengthOfStock, countOfThreadsDone = 0;
	
	private boolean doneWithSum = false;
	
	private final int START_RANGE = 1, END_RANGE = 100;
	
	
	
	//Initialize the monitor
	public StockOfIntegers(int lengthOfStock) {
		
		this.stockArray = new ArrayList<Integer>(lengthOfStock);
		this.lengthOfStock = lengthOfStock;
	}
	
	// return the current Array
	public ArrayList<Integer> getStock() {
		return this.stockArray;
	}
	
	
	public String printArray() {
		String content = "";
		
		for (Integer integer : stockArray) {
			content += " " + integer;
		}
		
		return content;
	}
	
	public void initWithRandomValues() {
		
		for(int i = 0; i<lengthOfStock; i++)
			this.stockArray.add( rnd.nextInt( END_RANGE - START_RANGE) + START_RANGE );
		
		System.out.println(this.stockArray);
		
	}

	
	public synchronized int getSumOfArray() {
	
		while(!doneWithSum) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		// return the sum
		return this.stockArray.get(0);
	}
	
	
	public synchronized int[] getTwoMembers() {
		
		int[] twoMembersToReturn = new int[2];
		
		while(this.stockArray.size() == 0 || this.stockArray.size() == 1) {
			System.out.println(this.printArray());
			
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception at getTwoMembers");
			}
		}
			
//		while (this.stockArray.size() == 1 && !doneWithSum) {
//			
//			
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			//return null;
//		}
		
		// remove both first cells
		twoMembersToReturn[0] = this.stockArray.remove(0);
		twoMembersToReturn[1] = this.stockArray.remove(0);
		
		return twoMembersToReturn;
	}
	
	public synchronized void insertSum(int sumOfTwo) {
		
		
		this.stockArray.add(sumOfTwo);
		
		
		
		notifyAll();	
	}
}
