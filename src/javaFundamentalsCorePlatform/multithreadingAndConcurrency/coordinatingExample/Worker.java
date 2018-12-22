package javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample;

public class Worker implements Runnable {

	private BankAccount account;

	public Worker(BankAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
//			int startBalance = account.getBalance();
			// Exact same result that use this for BankAccount method
			// 1 - Enable to synchronized access on unsynchronized Classes
			// 2 - Protect block of code
			synchronized (account) {
				account.deposit(10);
			}

//			int endBalance = account.getBalance();
		}

	}

}
