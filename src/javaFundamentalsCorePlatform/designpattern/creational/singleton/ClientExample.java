package javaFundamentalsCorePlatform.designpattern.creational.singleton;

public class ClientExample {

	public static void main(String[] args) {

		MySingleton singleton = MySingleton.getIntance();

		singleton.doSomething();
	}

}
