package javaFundamentalsCorePlatform.basicConcepts.objectOriented;

import java.util.HashMap;
import java.util.Map;

import javaFundamentalsCorePlatform.basicConcepts.objectOriented.markerInterface.MarkerInterface;

/******************************************************************************
 * strictfp is a keyword in java used for restricting floating-point
 * calculations and ensuring same result on every platform while performing
 * operations in the floating-point variable. <br>
 * Available since Java 2
 ******************************************************************************/
public strictfp interface IExampleInterface extends MarkerInterface {

	/******************************************************************************
	 * Traditional use of interface. Just declaring signatures. <br>
	 * These method are implicitly abstract & public <br>
	 * All these methods below are equivalent
	 ******************************************************************************/

	int getInt();

	public int getPublicInt();

	abstract int getAbstractInt();

	public abstract int getPublicAbstracInt();

	/******************************************************************************
	 * Interface can declare public constants. <br>
	 * Available since Java 7
	 ******************************************************************************/

	String MY_CONSTANT0 = "qsd";
	final String MY_CONSTANT1 = "qsd";
	static final String MY_CONSTANT2 = "qsd";
	public static final String MY_CONSTANT3 = "qsd";

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

	/**
	 * <h2>H2 title</h2> <br>
	 * <article>
	 * <h3>H3 title</h3>
	 * <p>
	 * a paragraph
	 * </p>
	 * <p>
	 * another paragraph
	 * </p>
	 * </article> <br>
	 * <aside>
	 * <p>
	 * Link aside <a href="http://www.google.com">here</a>.
	 * </p>
	 * </aside>
	 * 
	 * @param timeSec
	 * @param horsePower
	 * @param roadCondition
	 * @param tireCondition
	 * @return
	 */
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
