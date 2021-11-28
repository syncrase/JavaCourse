package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.MyComparableClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class SortWithComparatorLibrary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortListWithEmbeddedComparator();
		constructCustomSortingStrategy();
	}

	private static void constructCustomSortingStrategy() {

		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));

		// Definition of the sort logic withg the Comparator builder
		list2.sort(Comparator//
				.comparing(//
						SimpleClass::getValue, // by field
						Comparator.nullsLast(Comparator.naturalOrder())// null-friendly natural order comparator
				)//
				.thenComparing(//
						SimpleClass::getTheDouble, // by Double field
						(a, b) -> Double.compare(a, b)// Lambda wich return comparator
				)// by Double field
				.thenComparingDouble(SimpleClass::getTheDouble)//// by Double comparison on Double field
				.reversed()//
		);

		list2.forEach(m -> System.out.println(m.toString()));
		System.out.println();
	}

	private static void sortListWithEmbeddedComparator() {
		List<MyComparableClass> list2 = new ArrayList<>();
		list2.add(new MyComparableClass("aaa", "22"));
		list2.add(new MyComparableClass("rrr", "11"));
		list2.add(new MyComparableClass("ccc", "33"));

		// Different ways to sort

		// Using the item comparator
		list2.sort(Comparator.naturalOrder());
		list2.sort(Comparator.reverseOrder());

	}

}
