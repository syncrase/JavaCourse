package javaFundamentalsCorePlatform.streams;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {

	public void saySomething() throws IOException {
		throw new IOException("Exception from saySomething");
//		System.out.println("something");
	}
	@Override
	public void close() throws IOException {
		throw new IOException("Exception from close");
//		System.out.println("close");
	}

}
