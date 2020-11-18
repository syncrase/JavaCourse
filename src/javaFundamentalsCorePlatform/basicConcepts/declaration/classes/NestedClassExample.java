package javaFundamentalsCorePlatform.basicConcepts.declaration.classes;

/**
 * A final class cannot be extended<br>
 * A final method cannot be overrided<br>
 * 
 * @author syncrase
 *
 */
final public class NestedClassExample {

	public static void main(String[] args) {

		// An inner class must be instantiate from an outerClass instance
		OuterClass.NestedClass qsd = new OuterClass().new NestedClass();
		qsd.print();

		// Static nested classes can be instantiate without any instance of the outer
		// class
		OuterClass.StaticNestedClass snc = new OuterClass.StaticNestedClass();
		snc.print();

	}

}
