package javaFundamentalsCorePlatform.appExecutionAndEnvironment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecutionAndEnvironment {

	/**
	 * In order to execute from the command line ___________________________________
	 * Check java and javac command lines are working. If not, add jDK/bin to your
	 * classpath ___________________________________________________________________
	 * From the src directory run the following command ____________________________
	 * java
	 * javaFundamentalsCorePlatform.appExecutionAndEnvironment.ExecutionAndEnvironment
	 * Hello there world _________________________________________________________
	 * 
	 * If error occur run javac
	 * javaFundamentalsCorePlatform/appExecutionAndEnvironment/ExecutionAndEnvironment.java
	 * 
	 * ________________________________________________________________________________
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 1) {
			showUsage();
			return;
		} else {
//			for (String word : args) {
//				System.out.println(word);
//			}
			String filename = args[0];
			if (!Files.exists(Paths.get(filename))) {
				System.out.println(String.format("File \"%s\" not found", filename));
			}
			showFileName(filename);

		}
	}

	private static void showFileName(String filename) {
		System.out.println();

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
		}

	}

	private static void showUsage() {
		System.out.println();
		System.out.println("You have to provide the filename");
	}
	
	
	

}
