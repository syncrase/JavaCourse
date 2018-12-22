package javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample;

/**
 * This class is an example to protect memory from multithreading access
 * 
 * @author Pierre
 *
 */
public class BankAccount {

	/**
	 * This variable is protect from multithreading access because of the
	 * synchronization of method which use it.
	 */
	private int balance;

	public BankAccount(int startBalance) {
		super();
		this.balance = startBalance;
	}

	public int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int amount) {
		balance += amount;
	}

	public synchronized void withdrawal(int amount) {
		balance -= amount;
	}
}
