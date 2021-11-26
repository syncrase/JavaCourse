package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.ordering;

import java.util.TreeSet;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MyComparableClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.SimpleClassComparator;

public class OrderedSet {

	public static void main(String[] args) {
		useItemComparator();
		overrideDefaultComparator();
//		sortedMapExample();
	}

	private static void overrideDefaultComparator() {

		// TreeSet of simpleClass and specify the comparator
		TreeSet<MySimpleClass> list1 = new TreeSet<>(new SimpleClassComparator());
		list1.add(new MySimpleClass("aze", "22"));
		list1.add(new MySimpleClass("rty", "11"));
		list1.add(new MySimpleClass("bio", "33"));
		list1.forEach(m -> System.out.println(m.toString()));
	}

	private static void useItemComparator() {
		/**
		 * Use of Comparable<T> interface
		 */
		// TreeSet of comparable class, the set is sorted by default because of
		// Comparable<T> interface
		TreeSet<MyComparableClass> comparableTreeSet = new TreeSet<>();
		comparableTreeSet.add(new MyComparableClass("aze", "22"));
		comparableTreeSet.add(new MyComparableClass("rty", "11"));
		comparableTreeSet.add(new MyComparableClass("bio", "33"));
		System.out.println("MyComparableClass define comparaison on value");
		comparableTreeSet.forEach(m -> System.out.println(m.toString()));
	}

}
