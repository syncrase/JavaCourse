package javaFundamentalsCorePlatform.basicConcepts.collections.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class SortStream {

	public static void main(String[] args) {

		sortWithComparatorLibrary();
	}

	private static void sortWithComparatorLibrary() {
		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));
		list2.stream()//
				.sorted(
						// Definition of the sort logic withg the Comparator builder
						Comparator.comparing(SimpleClass::getValue).reversed()//
				)//
				.collect(Collectors.toList());
	}

}
