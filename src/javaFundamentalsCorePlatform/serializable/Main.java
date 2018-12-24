package javaFundamentalsCorePlatform.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount;

public class Main {


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

//		BankAccount acct = new BankAccount("123456", 500);
//		acct.deposit(50);
//		saveAccount(acct, "account.dat");

		BankAccount acct = loadAccount("account.dat");
		System.out.println(acct.getId() + " : " + acct.getBalance());
	}

	private static void saveAccount(BankAccount acct, String filename) {
		try (ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
			objectStream.writeObject(acct);

		} catch (IOException e) {

		}
	}

	private static BankAccount loadAccount(String filename) {
		BankAccount acct = null;
		try (ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
			acct = (BankAccount) objectStream.readObject();

		} catch (IOException | ClassNotFoundException e) {

		}
		return acct;
	}

}
