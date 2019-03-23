package demo1;

import java.util.Scanner;

public class Processor {

	
	public void produce() throws InterruptedException{
		synchronized(this) {
			System.out.println("Producer Thread running...");
			wait();
			System.out.println("Resumed");
		}
	}
	
	public void consume() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized(this) {
			System.out.println("Waiting for the Return Key...");
			scanner.nextLine();
			System.out.println("Return Key Pressed...");
			notify();
			Thread.sleep(5000);
		}
	}
}
