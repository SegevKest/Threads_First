import java.util.ArrayList;
import java.util.Random;


// The class will represent the stock itself of the integers
//It will get from the user the length of the Stock

public class StockOfIntegers {

	private Random rnd = new Random();
	private ArrayList<Integer> stockArray;
	private int lengthOfStock;
	
	private final int START_RANGE = 1, END_RANGE = 100;
	
	public StockOfIntegers(int lengthOfStock) {
		
		this.stockArray = new ArrayList<Integer>(lengthOfStock);
		this.lengthOfStock = lengthOfStock;
	}
	
	public ArrayList<Integer> getStock() {
		return this.stockArray;
	}
	
	public void initWithRandomValues() {
		
		for(int i = 0; i<lengthOfStock; i++)
			this.stockArray.add( rnd.nextInt( END_RANGE - START_RANGE) + START_RANGE );
	}
}
