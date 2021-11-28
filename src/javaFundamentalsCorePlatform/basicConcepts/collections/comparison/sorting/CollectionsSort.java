package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.MyComparableClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.ReverseComparator;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClassComparator;

public class CollectionsSort {

	public static void main(String[] args) {
		sortListWithCustomComparator();
		sortListWithLambdaComparator();
		sortListWithEmbeddedComparator();
	}

	private static void sortListWithCustomComparator() {
		// The comparator (and reverse comparator) may be applied on a list via
		// Collections:sort
		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));

		// Sorted list
		Collections.sort(list2, new SimpleClassComparator());
		list2.forEach(m -> System.out.println(m.toString()));

		System.out.println();

		// Reverse sorted list
		Collections.sort(list2, new ReverseComparator<>(new SimpleClassComparator()));
		list2.forEach(m -> System.out.println(m.toString()));
		System.out.println();
	}

	private static void sortListWithLambdaComparator() {
		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));

		System.out.println("Sort list with lambda a < b ");
		// Sorted list
		Collections.sort(list2, (a, b) -> a.getLabel().compareTo(b.getLabel()));
		list2.forEach(m -> System.out.println(m.toString()));

		System.out.println("Sort list with lambda b < a ");
		// Sorted list
		Collections.sort(list2, (a, b) -> b.getLabel().compareTo(a.getLabel()));
		list2.forEach(m -> System.out.println(m.toString()));
	}

	private static void sortListWithEmbeddedComparator() {
		List<MyComparableClass> list2 = new ArrayList<>();
		list2.add(new MyComparableClass("aaa", "22"));
		list2.add(new MyComparableClass("rrr", "11"));
		list2.add(new MyComparableClass("ccc", "33"));

		// Sorted list
		Collections.sort(list2);
		list2.forEach(m -> System.out.println(m.toString()));
		System.out.println();

		list2.forEach(m -> System.out.println(m.toString()));
		System.out.println();
	}

}
