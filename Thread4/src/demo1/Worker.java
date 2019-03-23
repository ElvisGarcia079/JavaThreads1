package demo1;
import java.util.*;

//Locks and Synchronized
//Create locks and synchronized blocks to allow for faster thread processing and sharing of variables.
//Synchronized methods block the thread from entering until the lock has been released
//Code blocks of synchronized allows the thread to enter the method, but then wait for the lock to be released. 
//Allows for savings in terms of processing time. By about double, because it is doing half the waiting. 


public class Worker {
	
	private Random random = new Random();
	
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public void stageOne() {
		
		synchronized(lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		list1.add(random.nextInt(100));
	}
	
	public void stageTwo() {
		
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		list2.add(random.nextInt(100));
	}
	
	public void process() {
		for(int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	
	
	public void main() {
		System.out.println("Starting ...");
	
		
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				process();
			}
		});
		
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		
		System.out.println("Time Taken: " + (end-start));
		System.out.println("List1: " + list1.size());
		System.out.println("List2: " + list2.size());
	}
	
	
}
