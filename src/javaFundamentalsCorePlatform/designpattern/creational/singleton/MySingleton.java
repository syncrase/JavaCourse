package javaFundamentalsCorePlatform.designpattern.creational.singleton;

public class MySingleton {

	private static MySingleton instance;

	private MySingleton() {
		super();
	}

	public static MySingleton getIntance() {
		if (instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}

	public void doSomething() {
		// TODO Auto-generated method stub

	}

}
