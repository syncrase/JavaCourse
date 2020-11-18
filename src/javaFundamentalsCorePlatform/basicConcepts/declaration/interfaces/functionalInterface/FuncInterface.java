package javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.functionalInterface;

/**
 * lambda expressions, method references, or constructor references.
 * 
 * @author syncrase
 *
 */
@FunctionalInterface
public interface FuncInterface<T> {

	/**
	 * Implicitly abstract<br>
	 * Only abstract method authorized in the functional interface
	 */
	public T doSomething(T i, T d);

	default void qsd() {

	}

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

//	Object clone() throws CloneNotSupportedException;

	@Override
	String toString();

//	void finalize() throws Throwable;

}
