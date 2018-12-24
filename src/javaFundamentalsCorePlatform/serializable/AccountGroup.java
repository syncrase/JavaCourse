package javaFundamentalsCorePlatform.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount;

public class AccountGroup {

	private Map<String, BankAccount> accountMap = new HashMap<>();
	/**
	 * Won't be written to the serialization stream
	 */
	private transient int totalBalance;

	public int getTotalBalance() {
		return totalBalance;
	}

	public void addAccount(BankAccount account) {
		totalBalance += account.getBalance();
		accountMap.put(account.getId(), account);
	}

	void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		for (BankAccount ba : accountMap.values())
			totalBalance += ba.getBalance();
	}

}
