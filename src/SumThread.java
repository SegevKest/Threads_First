
// the Class responsible for creation of the Sum Thread
// And overriding the Thread run() method according to the question
public class SumThread extends Thread{

	// each thread will receive the stock of Integers object to use - the shared resource
	private StockOfIntegers stock;

	// The constructor of the SumThread Class
	// Will get the stock to 
	public SumThread(StockOfIntegers stock) {

		this.stock = stock;
	}

	//Override the Run method in the Thread Class
	public void run(){

		int currSumToInsert = 0;

		// iterate on all array until its size is bigger than 1 - if not bigger - means we are done.
		while (this.stock.getStockSize() > 1) {
			
			
			// Gets both of the numbers		
			int[] twoMembers = this.stock.getTwoMembers();

			// Calculate the sum of both cells
			currSumToInsert = twoMembers[0] + twoMembers[1];

			// insert the sum to the array
			this.stock.insertSum(currSumToInsert);
		}
	}


}
