package javaFundamentalsCorePlatform.runtimeTypeAndReflection;

public class Logger {

	private String value;

	public Logger(String value) {
//		super();
		this.value = value;
	}

	public void log() {
		System.out.println(this.value);
	}

}
