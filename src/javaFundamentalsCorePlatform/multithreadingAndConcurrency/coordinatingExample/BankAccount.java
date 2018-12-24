package javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This class is an example to protect memory from multithreading access
 * 
 * @author Pierre
 *
 */

@ProcessedBy(Worker.class)
public class BankAccount implements Serializable {

	/**
	 * C:\Users\Pierre\dev\Java\JavaCourses\bin>serialver
	 * javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount
	 * -> private static final long serialVersionUID = -7045527315334332312L; _____
	 * Based on the class signature. Allow to deserialize object with an updated
	 * definition
	 */
	private static final long serialVersionUID = -7045527315334332312L;

	/**
	 * This variable is protect from multithreading access because of the
	 * synchronization of method which use it.
	 */
	private int balance;

	private String id;

	private char lastTxType;
	private int lastTxAmount;

	public BankAccount(int startBalance) {
		super();
		this.balance = startBalance;
	}

	public BankAccount(String id, int balance) {
		super();
		this.balance = balance;
		this.id = id;
	}

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public synchronized void deposit(int amount) {
		balance += amount;
		lastTxType = 'd';
		lastTxAmount = amount;

	}

	public synchronized void withdrawal(int amount) {
		balance -= amount;
		lastTxType = 'w';
		lastTxAmount = amount;
	}

	/**
	 * Customization of the serialization process
	 * 
	 * @param out
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	/**
	 * Customization of the serialization process
	 * 
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		ObjectInputStream.GetField fields = in.readFields();
		id = (String) fields.get("id", null);
		balance = fields.get("balance", 0);
		lastTxType = fields.get("lastTxType", 'u');
		lastTxAmount = fields.get("lastTxAmount", -1);

	}
}
