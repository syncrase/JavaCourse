package javaFundamentalsCorePlatform.basicConcepts.objectOriented.classesDeclaration;

public class NestedClassExample {

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
