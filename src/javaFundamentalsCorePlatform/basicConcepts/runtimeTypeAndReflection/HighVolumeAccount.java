package javaFundamentalsCorePlatform.basicConcepts.runtimeTypeAndReflection;

import javaFundamentalsCorePlatform.basicConcepts.multithreadingAndConcurrency.coordinatingExample.BankAccount;

public final class HighVolumeAccount extends BankAccount implements Runnable {

	public HighVolumeAccount(int startBalance) {
		super(startBalance);
	}

	public HighVolumeAccount(String id, int balance) {
		super(id, balance);
	}

	private int[] readDailyReposits() {
		return new int[1];
	}

	private int[] readDailyWithdrawals() {
		return new int[1];
	}

	@Override
	public void run() {
		for (int deposit : readDailyReposits()) {
			deposit(deposit);
		}
		for (int withdrawal : readDailyWithdrawals()) {
			withdrawal(withdrawal);
		}
	}

	public int sayHello(String value) {
		System.out.println("hello " + value);
		return 951486273;
	}
}
