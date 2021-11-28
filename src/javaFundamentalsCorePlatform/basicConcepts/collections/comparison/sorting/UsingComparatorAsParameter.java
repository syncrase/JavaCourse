package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.MyComparableClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.ReverseComparator;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClassComparator;

public class UsingComparatorAsParameter {

	public static void main(String[] args) {
		usingComparableItemsDefaultComparator();
		usingItemsDefaultComparator();
		usingCustomComparatorOnNonComparableItems();
		usingOnTheFlyDefinedComparator();
	}

	private static void usingItemsDefaultComparator() {
		// Use of the default Integer comparator
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		System.out.println(getMinValue(integers, Integer::compare));
		System.out.println(getMinValue(integers, new ReverseComparator<>(Integer::compare)));
	}

	private static void usingComparableItemsDefaultComparator() {
		// Example with a class which implement Comparable<MyComparableClass>
		List<MyComparableClass> comparableList = new ArrayList<>();
		comparableList.add(new MyComparableClass("aze", "22"));
		comparableList.add(new MyComparableClass("rty", "11"));
		comparableList.add(new MyComparableClass("bio", "33"));
		System.out.println(getMinValue(comparableList, MyComparableClass::compareTo));
	}

	private static void usingCustomComparatorOnNonComparableItems() {
		// Example with a class which implement Comparable<MyComparableClass>
		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));
		// list's min value
		SimpleClass objWithSmallestValue = getMinValue(list2, new SimpleClassComparator());
		System.out.println("min : " + objWithSmallestValue.toString());

		// list's reversed min value, so the max
		objWithSmallestValue = getMinValue(list2, new ReverseComparator<>(new SimpleClassComparator()));
		System.out.println("max : " + objWithSmallestValue.toString());
	}

	private static void usingOnTheFlyDefinedComparator() {
		List<SimpleClass> list2 = new ArrayList<>();
		list2.add(new SimpleClass("aaa", "22"));
		list2.add(new SimpleClass("rrr", "11"));
		list2.add(new SimpleClass("ccc", "33"));
		// list's min value with lambda comparator
		SimpleClass objWithSmallestValue = (SimpleClass) getMinValue(list2, new Comparator<SimpleClass>() {
			@Override
			public int compare(final SimpleClass o1, final SimpleClass o2) {
				return o1.getLabel().compareToIgnoreCase(o2.getLabel());
			}
		});
		System.out.println("min : " + objWithSmallestValue.toString());
	}

	/**
	 * Use the comparator in order to find the min value
	 * 
	 * @param list
	 * @param comparator
	 * @return
	 */
	private static <T> T getMinValue(List<T> list, Comparator<T> comparator) {
		if (list.isEmpty())
			throw new IllegalArgumentException("Can't find a minimum in an empty list!");
		T lowest = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			final T element = list.get(i);
			if (comparator.compare(element, lowest) < 0) {
				lowest = element;
			}
		}
		return lowest;
	}
}