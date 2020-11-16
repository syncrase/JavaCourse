package javaFundamentalsCorePlatform.basicConcepts.objectOriented.classesDeclaration;

import javaFundamentalsCorePlatform.basicConcepts.objectOriented.classesDeclaration.OuterClass.NestedClass;

public class AnonymousClassExample {

	public static void main(String... args) {

		// Test the public nested class and override its print method
		// Use of anonymous class
		OuterClass.NestedClass qsd = new OuterClass().new NestedClass() {
			private static final long serialVersionUID = 1L;

			public void print() {
				System.out.println("anonymous print");
			}

			// For reflexion use
			@SuppressWarnings("unused")
			public static final int publicStaticFinal = 456;

			// For reflexion use
			@SuppressWarnings("unused")
			public int publicInt = 5;

			// For reflexion use
			@SuppressWarnings("unused")
			private int privateInt = 14000;

			// For reflexion use
			@SuppressWarnings("unused")
			public void print2() {
				System.out.println("cannot be called from outside");
			}
		};
		qsd.print();

		/**
		 * Add new method to an anonymous class : 4 ways<br>
		 * Possible to write this but no way to call it from the outside because once
		 * the anonymous class instance has been implicitly cast into the named type it
		 * can't be cast back because there is no name for the anonymous type<br>
		 * Can be called by an overriding method or directly
		 */
		new Object() {
			public void print2() {
				System.out.println("new method on object : this");
			}
		}.print2();

		identity(new Object() {
			public void print2() {
				System.out.println("new method on object : identity");
			}
		}).print2();

		// Reflexion way to access
		try {
			Class<? extends NestedClass> myClass = qsd.getClass();
			// only public access
			myClass.getMethod("print2").invoke(qsd);
			System.out.println(myClass.getField("publicStaticFinal").getInt(qsd));
			System.out.println(myClass.getField("publicInt").getInt(qsd));

			// all access
			System.out.println(myClass.getDeclaredField("privateInt").getInt(qsd));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static <T> T identity(T value) {
		return value;
	}
}
