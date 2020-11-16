package javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WorkHandler(useThreadPool = false )
public class Main {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(5);
		BankAccount account = new BankAccount(100);
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker(account);
			// Five workers are running their run() method which accessing the same account
			// There's a high risk of concurrency issues if access aren't synchronized
			es.submit(worker);
		}

	}

}
