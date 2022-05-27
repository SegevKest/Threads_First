

// the Class responsible for creation of the the Sum Thread
public class SumThread extends Thread{


	private StockOfIntegers stock;

	// The constructor of the SumThread Class
	// Will get the stock to 
	public SumThread(StockOfIntegers stock) {

		this.stock = stock;
	}



	//Override the Run method in the Thread Class
	public void run(){

		int currSumToInsert = 0;

		// Gets both of the numbers		

		while (this.stock.getStock().size() > 1) {
			
			int[] twoMembers = this.stock.getTwoMembers();

			System.out.println(twoMembers[0] +" + "+ twoMembers[1]);

			// Calculate the sum of both cells
			currSumToInsert = twoMembers[0] + twoMembers[1];

			// insert the sum to the array
			this.stock.insertSum(currSumToInsert);
		}
	}


}
