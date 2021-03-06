package demo1;

class Account {

	private int balance = 10000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void printBalance() {
		System.out.println("You have " + balance + " dollars left in your account");
	}
	
	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
	
}

// TONY IS WRITING HIS NAME. (code immersives PY-113 spring 2021)
