package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.ReverseComparator;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.SimpleClassComparator;

public class SortList {

	public static void main(String[] args) {
		sortListWithCustomComparator();
	}

	private static void sortListWithCustomComparator() {
		// The comparator (and reverse comparator) may be applied on a list via
		// Collections:sort
		List<MySimpleClass> list2 = new ArrayList<>();
		list2.add(new MySimpleClass("aaa", "22"));
		list2.add(new MySimpleClass("rrr", "11"));
		list2.add(new MySimpleClass("ccc", "33"));

		// Sorted list
		Collections.sort(list2, new SimpleClassComparator());
		list2.forEach(m -> System.out.println(m.toString()));
		System.out.println();

		// Reverse sorted list
		Collections.sort(list2, new ReverseComparator<>(new SimpleClassComparator()));
		list2.forEach(m -> System.out.println(m.toString()));
	}

}
