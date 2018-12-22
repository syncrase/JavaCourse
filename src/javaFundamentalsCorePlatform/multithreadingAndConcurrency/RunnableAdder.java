package javaFundamentalsCorePlatform.multithreadingAndConcurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunnableAdder implements Runnable {

	private String infile, outfile;

	
	public RunnableAdder(String infile, String outfile) {
		super();
		this.infile = infile;
		this.outfile = outfile;
	}

	public int doAdd() throws IOException {
		int total = 0;
		String line = "";
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(infile))){
			while((line = reader.readLine()) != null) {
				line += Integer.parseInt(line);
			}
		}
		return total;
	}

	@Override
	public void run() {
		try {
			doAdd();
		}catch(IOException e) {
			
		}
	}
	
	
}
