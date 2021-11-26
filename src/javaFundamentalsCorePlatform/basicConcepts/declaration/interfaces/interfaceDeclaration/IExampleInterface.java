package javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.interfaceDeclaration;

import java.io.Serializable;

import javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.markerInterface.MarkerInterface;

/******************************************************************************
 * strictfp is a keyword in java used for restricting floating-point
 * calculations and ensuring same result on every platform while performing
 * operations in the floating-point variable. <br>
 * Available since Java 2
 ******************************************************************************/
/**
 * In interface we can :<br>
 * <ul>
 * <li>Just declare signatures. These method are implicitly abstract &
 * public</li>
 * <li>nest PUBLIC STATIC classes which can be final</li>
 * <li>nest interfaces implicitly public.</li>
 * <li>Nested interfaces can be static.</li>
 * </ul>
 * 
 * @author syncrase
 *
 */
public strictfp interface IExampleInterface extends MarkerInterface {

	/******************************************************************************
	 * Traditional use of interface. <br>
	 * 
	 ******************************************************************************/

	// All these methods below are equivalent
	int getInt();

	public int getPublicInt();

	abstract int getAbstractInt();

	public abstract int getPublicAbstracInt();

	/******************************************************************************
	 * Nested classes<br>
	 * Common use cases :
	 * <ul>
	 * <li>defining objects that are received or returned by the enclosing interface
	 * methods. Typically data holding structures</li>
	 * <li>when an interface has to throw custom exceptions. You the keep the
	 * exceptions with their associated interface</li>
	 * <li>Provide a default implementation of the interface <a href=
	 * "https://stackoverflow.com/questions/3427073/java-interface-implementation-pair/3442218#3442218">source</a></li>
	 * <li></li>
	 * </ul>
	 * 
	 *****************************************************************************/

	// Implicitly public & static (obviously)
	class MyClass implements IExampleInterface {
		@Override
		public int getInt() {
			return 0;
		}

		@Override
		public int getPublicInt() {
			return 0;
		}

		@Override
		public int getAbstractInt() {
			return 0;
		}

		@Override
		public int getPublicAbstracInt() {
			return 0;
		}
	}

	public static abstract class Abstract implements Serializable {
		// the default abstract implementation
	}

	/******************************************************************************
	 * Nested interfaces
	 *****************************************************************************/

	interface Interface1 {

	}

	// For example : cf. Map.Entry<K,V>
	static interface Interface2 {

	}

	/******************************************************************************
	 * Interface can declare public constants. <br>
	 * Available since Java 7
	 ******************************************************************************/

	String MY_STRING = "qsd";
	final String MY_FINAL_STRING = "qsd";
	static final String MY_STATIC_FINAL_STRING = "qsd";
	public static final String MY_PUBLIC_STATIC_FINAL_STRING = "qsd";// Implicitly public

	/******************************************************************************
	 * Interface can declare static & default methods <br>
	 * These method are implicitly public <br>
	 * Available since Java 8<br>
	 * <br>
	 * In the past, it had been common to place static methods in a companion class.
	 * You find pairs of interfaces and utility classes, such as
	 * Collection/Collections or Path/Paths, in the Java API. This split is no
	 * longer necessary.<br>
	 * Default methods put an end to the classic pattern of providing an interface
	 * and a companion class that implements most or all of its methods, such as
	 * Collection/AbstractCollection or WindowListener/WindowAdapter in the Java
	 * API. Nowadays you should just implement the methods in the interface.<br>
	 * https://www.informit.com/articles/article.aspx?p=2832415&seqNum=2#:~:text=A%20private%20method%20can%20be,other%20methods%20of%20the%20interface.
	 ******************************************************************************/

	static int getSomething() {
		return getPrivateStaticZero();
	}

	public static int getOtherthing() {
		return getPrivateStaticZero();
	}

	default String getString() {
		getPrivateZero();
		return "default String";
	}

	/******************************************************************************
	 * Interface can declare private methods <br>
	 * Available since Java 9
	 ******************************************************************************/

	private static int getPrivateStaticZero() {
		return 0;
	}

	private int getPrivateZero() {
		return 0;
	}

}
