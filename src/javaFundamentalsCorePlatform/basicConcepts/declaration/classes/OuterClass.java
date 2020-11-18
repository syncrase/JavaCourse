package javaFundamentalsCorePlatform.basicConcepts.declaration.classes;

import java.io.Serializable;

/**
 * seulement un parmis (obligatoire)
 * <ul>
 * <li>public</li>
 * <li>protected</li>
 * <li>private</li>
 * </ul>
 * et ce qu'on veut parmis (facultatif)
 * <ul>
 * <li>static : accessible without instancing</li>
 * <li>transient : Préviens la serialisation de la variable</li>
 * <li>seulement un parmis (facultatif)
 * <ul>
 * <li>volatile : La variable est stockée dans la mémoire principale et pas dans
 * celle du Thread, donc la modification de la variable est propagée aux autres
 * Thread. Rend impossible tout deadlock</li>
 * <li>final : must be initialize at the latest in the constructor</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * 
 * seulement un type parmis (obligatoire)
 * <ul>
 * <li>byte</li>
 * <li>short</li>
 * <li>int</li>
 * <li>long</li>
 * <li>float</li>
 * <li>double</li>
 * <li>char</li>
 * <li>? extends Object</li>
 * </ul>
 * 
 * Incohérences :
 * <ul>
 * <li>Associer les mots-clés static et transient. Transient prévient la
 * variable de la sérialisation de l'instance et static précise que la variable
 * n'appartient pas à l'instance. Donc transient + static ne sert à rien puisque
 * la variable n'est de toute façon pas sérialisée.</li>
 * <li>Associer les mots-clés final et transient. Lors de la deserialisation il
 * ne sera pas possible d'assigner une valeur à la valeur final qui aura été
 * initialisé avec une valeur par défaut</li>
 * </ul>
 */
@SuppressWarnings("unused")
public class OuterClass {

//	abstract String sss;
	// Three ways to initialize a final variable
	private final long privateFinalLong = 0;// At the same time as the declaration
	private final long privateFinalLong2;// In the static initializer
	private final long privateFinalLong3;// In the instance initializer

	// Two ways to initialize a static final variable
	private static final long privateStaticFinalLong = 0;
	private static final long privateStaticFinalLong2;

	private transient volatile long qsdk;

	private static long privateStaticLong;

	// volatile <-> final
	private static volatile long qsd;
	private static final long qsdj = 2;

	/**
	 * static block (or static clause) used for static initialization.<br>
	 * Code executed only the first time that the class is load into memory<br>
	 * https://stackoverflow.com/questions/2943556/static-block-in-java
	 */
	static {
		System.out.println("static initialization");
		privateStaticFinalLong2 = 2;
	}

	/**
	 * instance initializer<br>
	 * https://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.6
	 */
	{
		privateFinalLong3 = 2;
		System.out.println("instance initialization. I'm before the constructor but after the super()");
	}

	public NestedClass nestedClass;

	public OuterClass() {
		super();
		privateFinalLong2 = 8;
		// Use of anonymous class
		nestedClass = new NestedClass();
		nestedClass.print();
	}

	/*
	 *******************************************************************************
	 *************************** INNER CLASSES *************************************
	 *******************************************************************************/

	/*
	 * An inner class in a serializable class must also be serializable
	 */
	public class NestedClass extends AClass implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8083840570712131005L;

		public void print() {
			System.out.println("Message from nested class");
		}

		@Override
		public void publicAbstractVoidMethod() {

		}
	}

	/*
	 * A class nested in a serializable class must also be serializable<br>
	 * 
	 */
	public static class StaticNestedClass extends AClass implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8083840570712131005L;

		public void print() {
			System.out.println("Message from static nested class : " + OuterClass.privateStaticFinalLong2);
		}

		@Override
		public void publicAbstractVoidMethod() {

		}
	}
}
