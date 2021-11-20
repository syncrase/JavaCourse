package javaFundamentalsCorePlatform.basicConcepts.collections.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La m�thode equals() est en g�n�ral utilis�e pour faire une comparaison
 * s�mantique (par attribut)
 * 
 * @author syncrase
 *
 */
public class HashcodeAndEquals {

	public static void main(String[] args) {

		System.out.println("### Compare two simple objects");
		printComparisonResult(new Object(), new Object());

		System.out.println();
		System.out.println("### Compare two simple classes");
		printComparisonResult(new TestClass("1", "2"), new TestClass("1", "2"));

		System.out.println();
		System.out.println("### Compare two objects with overrided hashcode and equals methods");
		printComparisonResult(new TestClass2("1", "2"), new TestClass2("1", "2"));

		System.out.println();
		System.out.println("### Compare two identical strings");
		printComparisonResult(new String("12"), new String("12"));

		System.out.println();
		System.out.println("### Compare two identical Lists");
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		printComparisonResult(list1, new ArrayList<>(list1));

		System.out.println();
		System.out.println("### Compare two Lists of objects wich return always true on equals");
		ArrayList<EqualsAlwaysTrueClass> list2 = new ArrayList<>();
		list2.add(new EqualsAlwaysTrueClass("1"));
		System.out.println("Containing this different object ? " + (list2.contains(new EqualsAlwaysTrueClass("qsd"))));
	}

	private static void printComparisonResult(Object o1, Object o2) {
		// Compare the object reference
		System.out.println("== : " + (o1 == o2));
		System.out.println("equals : " + (o1.equals(o2)));
	}

}

/**
 * Default hashcode and equals methods
 * 
 * @author syncrase
 *
 */
class TestClass {
	String str1, str2;

	public TestClass(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// Default equals compare with '=='
		return super.equals(obj);
	}

}

/**
 * Overrided hashcode and equals method
 * 
 * @author syncrase
 *
 */
class TestClass2 {
	String str1, str2;

	public TestClass2(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(str1, str2);
	}

	/**
	 * Default code generated by eclipse
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestClass2 other = (TestClass2) obj;
		return Objects.equals(str1, other.str1) && Objects.equals(str2, other.str2);
	}

}

/**
 * Overrided hashcode and equals method
 * 
 * @author syncrase
 *
 */
class EqualsAlwaysTrueClass {
	String str1;

	public EqualsAlwaysTrueClass(String s) {
		this.str1 = s;
	}

	/**
	 * Yes man!
	 */
	@Override
	public boolean equals(Object obj) {
		return true;
	}

}
