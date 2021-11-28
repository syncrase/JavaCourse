package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.TreeSet;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.MyComparableClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClassComparator;

public class OrderedSet {

	public static void main(String[] args) {
		useItemComparator();
		overrideDefaultComparator();
	}

	private static void overrideDefaultComparator() {

		// TreeSet of simpleClass and specify the comparator
		TreeSet<SimpleClass> list1 = new TreeSet<>(new SimpleClassComparator());
		list1.add(new SimpleClass("aze", "22"));
		list1.add(new SimpleClass("rty", "11"));
		list1.add(new SimpleClass("bio", "33"));
		list1.forEach(m -> System.out.println(m.toString()));
	}

	private static void useItemComparator() {
		TreeSet<MyComparableClass> comparableTreeSet = new TreeSet<>();
		comparableTreeSet.add(new MyComparableClass("aze", "22"));
		comparableTreeSet.add(new MyComparableClass("rty", "11"));
		comparableTreeSet.add(new MyComparableClass("bio", "33"));
		System.out.println("MyComparableClass define comparison on value");
		comparableTreeSet.forEach(m -> System.out.println(m.toString()));
	}

}
