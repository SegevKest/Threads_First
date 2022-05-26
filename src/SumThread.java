import java.util.ArrayList;

// the Class responsible for creation of the the Sum Thread
public class SumThread extends Thread{

	
	private ArrayList<Integer> stock;
	
	// The constructor of the SumThread Class
	// Will get the stock to 
	public SumThread(ArrayList<Integer> stockOfIntegers) {
		
		this.stock = stockOfIntegers;
	}

	
	
	//Override the Run method in the Thread Class
	public void run(){
		
	}

	
}
