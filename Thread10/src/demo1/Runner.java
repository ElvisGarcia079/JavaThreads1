package demo1;

//Re-Entrant Locks
//More Concurrent Classes that are Thread Safe. This introduces sage locks to use so you don't derive from the object class.
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		lock.lock();
		
		System.out.println("Thread 1 is sleeping going to wait.");
		cond.await();
		
		System.out.println("Thread 1 is back up.");
		try {
			increment();
		}finally {
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException{
		System.out.println("Entering Thread 2");
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press Return Key...");
		new Scanner(System.in).nextLine();
	 	System.out.println("Return Key Pressed...");
		
		cond.signal();
		
		
		try {
			increment();
		}finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Count is: " + count);
		
	}
}
