package javaFundamentalsCorePlatform.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/**
 * There's two types of streams: by byte and by character.<br\> For each of them
 * there're two way to read the contained values:<br\> 1 - Read one by one and
 * cast the int returned into the right type (byte or char)<br\> 2 - Read an
 * array of byte or char by passing the empty array in parameter<br\>
 * 
 * @author Pierre
 *
 */
public class Streams {

	public static void main(String[] args) {
//		Streams.exampleBetterWay();
//		Streams.exampleMultiResources();
		Streams.doCloseThing();
	}

	/**
	 * known subclasses
	 * https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
	 * 
	 * @throws IOException
	 */
	public void inputByteStream() throws IOException {
		// See all the direct known subclasses in order to see all objects available for
		// that
		InputStream stream = new ByteArrayInputStream(("myString").getBytes());
		int intVal = 0;

		while ((intVal = stream.read()) > -1) {
			byte byteVal = (byte) intVal;
			// Do something with byteVal
		}

		// The way to read an array of bytes
		int numberOfBytesRead;
		byte[] byteBuff = new byte[10];

		while ((numberOfBytesRead = stream.read(byteBuff)) > -1) {
			for (int i = 0; i < numberOfBytesRead; i++) {
				// Get values byte by byte
				byte byteVal = byteBuff[i];
				// Use this
			}
		}

	}

	/**
	 * known subclasses
	 * https://docs.oracle.com/javase/7/docs/api/java/io/Reader.html
	 * 
	 * @throws IOException
	 */
	public void inputCharStream() throws IOException {
		// See all the direct known subclasses in order to see all objects available for
		// that
		Reader reader = new StringReader("myString");
		int intVal2 = 0;

		while ((intVal2 = reader.read()) > -1) {
			char byteVal2 = (char) intVal2;
			// Do something with byteVal
		}

		// The way to read an array of characters
		int numberOfBytesRead;
		char[] charBuff = new char[10];

		while ((numberOfBytesRead = reader.read(charBuff)) > -1) {
			for (int i = 0; i < numberOfBytesRead; i++) {
				// Get values byte by byte
				char byteVal = charBuff[i];
				// Use this
			}
		}

	}

	/**
	 * known subclasses
	 * https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html
	 * 
	 * @throws IOException
	 */
	public void outputByteStream() throws IOException {

		OutputStream outputStream = new ByteArrayOutputStream();

		byte byteVal = 100;

		outputStream.write(byteVal);

		// Same way to write an array
		byte[] byteBuffer = { 100, (byte) 200, (byte) 300 };

		outputStream.write(byteBuffer);

	}

	/**
	 * known subclasses
	 * https://docs.oracle.com/javase/7/docs/api/java/io/Writer.html
	 * 
	 * @throws IOException
	 */
	public void outputCharStream() throws IOException {

		Writer writer = new CharArrayWriter();
		char charVal = 'a';
		writer.write(charVal);

		char[] charBuff = { 'a', 'b', 'c' };
		writer.write(charBuff);

		String string = "myString";
		writer.write(string);

	}

	public static void simpleExample() {
		char[] charBuf = new char[8];
		int length;
		Reader reader = null;
		try {
			reader = Helper.openReader("resources/file1.txt");
			while ((length = reader.read(charBuf)) > -1) {
				System.out.println("\nlength: " + length);
				for (int i = 0; i < length; i++) {
					System.out.print(charBuf[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getClass().getSimpleName() + " --> " + e2.getMessage());
			}
		}

	}

	public static void exampleBetterWay() {
		char[] charBuf = new char[8];
		int length;
		try (Reader reader = Helper.openReader("resources/file1.txt")) {
			while ((length = reader.read(charBuf)) > -1) {
				System.out.println("\nlength: " + length);
				for (int i = 0; i < length; i++) {
					System.out.print(charBuf[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
		}

	}

	public static void exampleMultiResources() {
		char[] charBuf = new char[8];
		int length;
		try (Reader reader = Helper.openReader("resources/file1.txt");
				Writer writer = Helper.openWriter("resources/file2.txt")) {
			while ((length = reader.read(charBuf)) > -1) {
				System.out.println("\nlength: " + length);
				writer.write(charBuf, 0, length);

			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
		}

	}

	/**
	 * Prove that if there's no close called explicitly, close is called when an
	 * Exception is thrown by the close method and method called before it.
	 */
	private static void doCloseThing() {
		try (MyAutoCloseable ac = new MyAutoCloseable()) {
			ac.saySomething();
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("Suppressed --> " + t.getMessage());
			}
		}
	}

	/**
	 * Allow to use different type of stream
	 * 
	 * @param in
	 * @throws IOException
	 */
	public void doChain(InputStream in) throws IOException {
		int length;
		char[] charBuff = new char[128];
		// InputStreamReader doesn't care if the passed stream is fileReader,
		// stringReader or anything else
		try (InputStreamReader reader = new InputStreamReader(in)) {

			while ((length = reader.read(charBuff)) > -1) {
				// do something with charBuff
			}
		}

	}

	public void bufferedStream() {

		try (BufferedReader br = new BufferedReader(new FileReader("resources/file1.txt"))) {

			int intVal;
			while ((intVal = br.read()) > -1) {
				char charVal = (char) intVal;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeData(String[] data) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/file1.txt"))) {
			for (String s : data) {
				bw.write(s);
				bw.newLine();

			}
		}
	}

	public void readData() throws IOException {
		try (BufferedReader bw = new BufferedReader(new FileReader("resources/file1.txt"))) {
			String inValue;
			while ((inValue = bw.readLine())!= null) {
				System.out.println(inValue);

			}
		}
	}
	
	
}
