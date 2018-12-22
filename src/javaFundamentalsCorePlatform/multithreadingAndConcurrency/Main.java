package javaFundamentalsCorePlatform.multithreadingAndConcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

//		traditionnalWay();
		wayToUseRunnableThreads();

	}

	private static void traditionnalWay() {

		String[] infiles = { "./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt",
				"./file6.txt", };
		String[] outfiles = { "./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt",
				"./file5.out.txt", "./file6.out.txt", };

		Thread[] threads = new Thread[infiles.length];
//		try {
		for (int i = 0; i < infiles.length; i++) {
			RunnableAdder adder = new RunnableAdder(infiles[i], outfiles[i]);

			// DON'T USE THIS
			// adder.doAdd();
			// BUT A THREAD
			threads[i] = new Thread(adder);
			threads[i].start();

		}

		for (Thread t : threads) {
			try {
				t.join();// Blocks waiting for thread completion
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	private static void wayToUseRunnableThreads() {
		String[] infiles = { "./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt",
				"./file6.txt", };
		String[] outfiles = { "./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt",
				"./file5.out.txt", "./file6.out.txt", };

		ExecutorService es = Executors.newFixedThreadPool(3);
		for (int i = 0; i < infiles.length; i++) {
			RunnableAdder adder = new RunnableAdder(infiles[i], outfiles[i]);
			es.submit(adder);

		}
		try {
			es.shutdown();
			es.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void wayToUseCallableThreads() {
		String[] infiles = { "./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt",
				"./file6.txt", };
		String[] outfiles = { "./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt",
				"./file5.out.txt", "./file6.out.txt", };

		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer>[] results = new Future[infiles.length];

		for (int i = 0; i < infiles.length; i++) {
			CallableAdder adder = new CallableAdder(infiles[i], outfiles[i]);
			results[i] = es.submit(adder);

		}

		for (Future<Integer> result : results) {
			try {
				int value = result.get();// blocks until return value available
				System.out.println("Total: " + value);
			} catch (ExecutionException e) {// Exception raised by Adder
				Throwable addEx = e.getCause();
				//...
			} catch (Exception e) {// non-Adder Exception

			}

		}

	}

}
