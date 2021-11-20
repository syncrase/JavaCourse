package javaFundamentalsCorePlatform.basicConcepts.collections.comparison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils.Duplicator;

public class Main {

	public static void main(String[] args) {
		comparableAndComparator();
//		mapExample();
//		sortedMapExample();
	}

	private static void comparableAndComparator() {
		// TODO ranger
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

		System.out.println();

		// Example with a class which implement Comparable<MyComparableClass>
		List<MyComparableClass> comparableList = new ArrayList<>();
		comparableList.add(new MyComparableClass("aze", "22"));
		comparableList.add(new MyComparableClass("rty", "11"));
		comparableList.add(new MyComparableClass("bio", "33"));
		System.out.println(getMinValue(comparableList, MyComparableClass::compareTo));

		System.out.println();

		// Use of the default Integer comparator
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		System.out.println(getMinValue(integers, Integer::compare));
		System.out.println(getMinValue(integers, new ReverseComparator<>(Integer::compare)));

		System.out.println();

		/**
		 * Use of Comparator<T> interface
		 */

		// TreeSet of simpleClass and specify the comparator
		TreeSet<MySimpleClass> list1 = new TreeSet<>(new SimpleClassComparator());
		list1.add(new MySimpleClass("aze", "22"));
		list1.add(new MySimpleClass("rty", "11"));
		list1.add(new MySimpleClass("bio", "33"));
		list1.forEach(m -> System.out.println(m.toString()));

		System.out.println();

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
		// list's min value
		MySimpleClass objWithSmallestValue = getMinValue(list2, new SimpleClassComparator());
		System.out.println("min : " + objWithSmallestValue.toString());
		// list's min value with lambda comparator
		objWithSmallestValue = (MySimpleClass) getMinValue(list2, new Comparator<MySimpleClass>() {
			@Override
			public int compare(final MySimpleClass o1, final MySimpleClass o2) {
				return o1.getLabel().compareToIgnoreCase(o2.getLabel());
			}
		});
		System.out.println("min : " + objWithSmallestValue.toString());
		// list's reversed min value, so the max
		objWithSmallestValue = getMinValue(list2, new ReverseComparator<>(new SimpleClassComparator()));
		System.out.println("max : " + objWithSmallestValue.toString());

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

	private static void mapExample() {
		Map<String, String> map = new HashMap<>();
		map.put("22", "aze");
		map.put("11", "zer");
		map.put("33", "bvc");
		System.out.println(map.get("11"));
		System.out.println(map.get("99"));
		System.out.println(map.getOrDefault("99", "default value"));

		map.replaceAll((k, v) -> "new " + v);
		map.forEach((k, v) -> System.out.println(k + " | " + v));
		map.replaceAll((k, v) -> v.toUpperCase());
		map.forEach((k, v) -> System.out.println(k + " | " + v));
	}

	private static void sortedMapExample() {
		SortedMap<String, String> map = new TreeMap<>();
		map.put("22", "aze");
		map.put("11", "zer");
		map.put("33", "bvc");
		map.put("44", "xcxv");
		map.put("66", "uyt");
		map.put("55", "rfv");

		map.forEach((k, v) -> System.out.println(k + " | " + v));

		SortedMap<String, String> hMap = map.headMap("33");// Strictly before
//		hMap.forEach((k, v) -> System.out.println(k + " | " + v));

		SortedMap<String, String> tMap = map.tailMap("33");// After or equals
//		tMap.forEach((k, v) -> System.out.println(k + " | " + v));

		SortedMap<String, String> sMap = map.subMap("22", "55");// After and strictly before
//		sMap.forEach((k, v) -> System.out.println(k + " | " + v));

		System.out.println();

		/**
		 * With a custom comparator
		 */
//		SortedMap<String, String> 
		map = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		map.put("22", "aze");
		map.put("11", "zer");
		map.put("33", "bvc");
		map.put("44", "xcxv");
		map.put("66", "uyt");
		map.put("55", "rfv");

		map.forEach((k, v) -> System.out.println(k + " | " + v));

		hMap = map.headMap("33");// Strictly before
//		hMap.forEach((k, v) -> System.out.println(k + " | " + v));

		tMap = map.tailMap("33");// After or equals
//		tMap.forEach((k, v) -> System.out.println(k + " | " + v));

		sMap = map.subMap("55", "22");// After and strictly before
//		sMap.forEach((k, v) -> System.out.println(k + " | " + v));

	}

}
