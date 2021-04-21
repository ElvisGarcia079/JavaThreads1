package demo1;

//Extend the Thread class is "thefirst" way to use thread
//in your java class
//Need to override run

class Runner extends Thread{
	public void run() {
		for(int i = 0; i < 10; i++) {
			
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class App {
 public static void main(String[] args) {
	Runner runner1 = new Runner();
	Runner runner2 = new Runner();
	runner1.start(); 
	runner2.start();
 }

}

// Chris Porter was here PY113 Code Immersives
