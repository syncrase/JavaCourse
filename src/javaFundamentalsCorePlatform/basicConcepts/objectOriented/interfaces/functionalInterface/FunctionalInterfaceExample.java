package javaFundamentalsCorePlatform.basicConcepts.objectOriented.interfaces.functionalInterface;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {

		/**
		 * Define the implementation of the functional interface with a lambda
		 * expression
		 */
		FuncInterface fi = (s, i, d) -> System.out.println(s + ":" + i + ":" + d);
		FuncInterface fi2 = (s, i, d) -> System.out.println(s + "§" + i + "§" + d);

		fi.doSomething("s", 1, 1.0);
		fi2.doSomething("s", 1, 1.0);

		/**
		 * Define the implementation of the functional interface with an anonymous class
		 */
		FuncInterface fi3 = new FuncInterface() {
			@Override
			public void doSomething(String str, int i, double d) {
				System.out.println("(" + str + ":" + i + ":" + d + ")");
			}
		};
		fi3.doSomething("s", 1, 1.0);

		new FuncInterface() {
			@Override
			public void doSomething(String str, int i, double d) {
				System.out.println("(" + str + ":" + i + ":" + d + ")");
			}
		}.doSomething("s", 1, 1.0);
	}

}
