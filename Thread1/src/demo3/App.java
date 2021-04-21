//Packages are always where a particular set of files live. Different packages in theory should have different files
package demo3;

//This is the declaration of a "Class" in Object Oriented Programming. 
	//A "Class" is a Blueprint for an Object. It represents the properties and behavior that your object will contain, and you can reference these properties by using the "dot notation".
//Since Java is an Object Oriented Programming Language, that means that we are going to be working with and creating objects all the time. 

//As mentioned, this is a "Class" Declaration. This is how we will define out blueprint for any 'new' "App" Objects that we create.
public class App {
	
	//This is the standard "main" function in Java. It is used to run your main logic, while all other functions serve as helper methods/functions. 
	public static void main(String[] args) {
		
		//In this case, I am creating a Thread Object from the Java Thread Class. 
		//This object takes a "call back" function as a parameter. Meaning, that it is waiting for the creation of the object to implement it's Runnable Interface.
		//If you override the run() method that comes in the Runnable Object (Passed in as a Parameter for the Thread Object, you'll have the logic running as a Thread. 
		
		//So now you have a Thread Object, and this Thread Object is Implementing the Runnable Interface from right within the paramaters of the Thread Object as a Callback
		Thread t1 = new Thread(new Runnable() {
			
			//This key word is used is Java when you're overriding a method that is given to you in an interface with some functionality you're going to implement yourself.
			@Override
			//1. This is the function declaration. It starts with the access modifier, in this case, this function is public. 
			//2. Then it has the return type of the function, what type of data is returning from this function. Since it's void, it's not returning anything, it's just performing some task. 
			public void run() {
				
				//Simple for loop function that iterates from 1-10 and prints "Hello" and the index number
				for(int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		//This will start the Thread Object labeled t1 above on line 19. 
		t1.start();
		
	}
	
}
