package javaFundamentalsCorePlatform.streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Helper {

	public static Reader openReader(String string) throws FileNotFoundException {

		Reader reader = new FileReader(string);

		return reader;
	}

	public static Writer openWriter(String string) throws IOException {

		FileWriter writer = new FileWriter(string);
		
		return writer;
	}

}
