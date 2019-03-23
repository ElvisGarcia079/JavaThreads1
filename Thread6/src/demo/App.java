package demo;

//Look up all concurrent classes. They should probably be all thread safe.
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Count down Latches
//Thread safe class, does not need synchronized

class Processor implements Runnable{
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Started.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		
		latch.countDown();
	}
}

public class App {
	
	public static void main(String[] args) {
		//Great class to know for multi-threading code
		
		CountDownLatch latch = new CountDownLatch(3);
		//Lets one or more threads for the latch to reach a count of 0
		//When it finally is 0, the thread waiting on the latch can carry on
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i =0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //waits until count down latch has counted down to 0.
		
		System.out.println("Completed.");
		
	}
	
	
}
