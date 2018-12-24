package javaFundamentalsCorePlatform.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
//		removalExample();
//		lambdaListExample();
//		conversionExample();
		comparableExample();
//		mapExample();
//		lambdaMapExample();
//		sortedMapExample();

	}

	private static void removalExample() {
		ArrayList<MySimpleClass> list = new ArrayList<>();

		MySimpleClass c1 = new MySimpleClass("abc", "1");
		MySimpleClass c2 = new MySimpleClass("abc", "2");
		MySimpleClass c3 = new MySimpleClass("abc", "3");
		list.add(c1);
		list.add(c2);
		list.add(c3);

		for (MySimpleClass m : list)
			System.out.print(m.getValue());
		System.out.println("\nRemove " + c3.getValue());

		list.remove(c3);

		for (MySimpleClass m : list)
			System.out.print(m.getValue());

		System.out.print("\nThe wrong object was deleted because the Collection superclass remove the first object "
				+ "which is returned true to his equals() method");

	}

	private static void lambdaListExample() {
		ArrayList<MySimpleClass> list = new ArrayList<>();

		MySimpleClass c1 = new MySimpleClass("abc", "1");
		MySimpleClass c2 = new MySimpleClass("aze", "2");
		MySimpleClass c3 = new MySimpleClass("abc", "3");
		list.add(c1);
		list.add(c2);
		list.add(c3);

		list.forEach(m -> System.out.println(m.getValue()));
		list.removeIf(m -> m.getLabel().equals("abc"));
		System.out.println();
		list.forEach(m -> System.out.println(m.getValue()));
	}

	private static void conversionExample() {
		// Collection to array
		ArrayList<MySimpleClass> list = new ArrayList<>();

		list.add(new MySimpleClass("abc", "1"));
		list.add(new MySimpleClass("aze", "2"));
		list.add(new MySimpleClass("abc", "3"));

		Object[] obj = list.toArray();

		MySimpleClass[] a1 = list.toArray(new MySimpleClass[0]);
		MySimpleClass[] a2 = new MySimpleClass[2];
		MySimpleClass[] a3 = list.toArray(a2);

		if (a2 == a3)
			System.out.println("a2 & a3 are references to the same object if a2.length == 3");

		System.out.println(a3.length);

		//
		// Array to Collection
		MySimpleClass[] myArray = { new MySimpleClass("abc", "1"), new MySimpleClass("aze", "2"),
				new MySimpleClass("abc", "3") };

		Collection<MySimpleClass> collection = Arrays.asList(myArray);
		collection.forEach(m -> System.out.println(m.getValue()));
	}

	private static void comparableExample() {
		// Example with a class which implement Comparable<MyComparableClass>
		TreeSet<MyComparableClass> list = new TreeSet<>();

		list.add(new MyComparableClass("aze", "22"));
		list.add(new MyComparableClass("rty", "11"));
		list.add(new MyComparableClass("bio", "33"));

		System.out.println("MyComparableClass define comparaison on value");
		list.forEach(m -> System.out.println(m.toString()));

		// Example 1 with a custom comparator
		System.out.println("MySimpleClass TreeSet with a custom comparator which compare on label");
		TreeSet<MySimpleClass> list1 = new TreeSet<>(new MyComparator());

		list1.add(new MySimpleClass("aze", "22"));
		list1.add(new MySimpleClass("rty", "11"));
		list1.add(new MySimpleClass("bio", "33"));

		list1.forEach(m -> System.out.println(m.toString()));

		// Example 2 with a custom comparator
		System.out.println("MySimpleClass List with a custom comparator which compare on label");
		List<MySimpleClass> list2 = new ArrayList<>();

		list2.add(new MySimpleClass("aaa", "22"));
		list2.add(new MySimpleClass("rrr", "11"));
		list2.add(new MySimpleClass("ccc", "33"));

		Collections.sort(list2, new MyComparator());
		list2.forEach(m -> System.out.println(m.toString()));

		// Example 3 with a reverse comparison
		System.out.println("MySimpleClass List with a custom comparator which compare on label");
		List<MySimpleClass> list3 = new ArrayList<>();

		list3.add(new MySimpleClass("aaa", "22"));
		list3.add(new MySimpleClass("rrr", "11"));
		list3.add(new MySimpleClass("ccc", "33"));

		Collections.sort(list3, new ReverseComparator<>(new MyComparator()));
		list3.forEach(m -> System.out.println(m.toString()));

		// Example 4 with a reverse comparison
		System.out.println("MySimpleClass List with a comparator as a generic parameter");
		List<MySimpleClass> list4 = new ArrayList<>();

		list4.add(new MySimpleClass("aaa", "22"));
		list4.add(new MySimpleClass("rrr", "11"));
		list4.add(new MySimpleClass("ccc", "33"));

		MySimpleClass objWithSmallestValue = minValue(list4, new MyComparator());
		System.out.println(objWithSmallestValue.toString());

		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		System.out.println(minValue(integers, Integer::compare));

//		// Example 5 with a reverse comparison
//		System.out.println("MySimpleClass List with a comparator directly writed");
//		List<MySimpleClass> list5 = new ArrayList<>();
//
//		list5.add(new MySimpleClass("aaa", "22"));
//		list5.add(new MySimpleClass("rrr", "11"));
//		list5.add(new MySimpleClass("ccc", "33"));
//
//		MySimpleClass objWithSmallestValue5 = (MySimpleClass) minValue(list5, new Comparator<MySimpleClass>() {
//			@Override
//			public int compare(final MySimpleClass o1, final MySimpleClass o2) {
//				return o1.compareTo(o2);
//			}
//
//		});

	}

	/**
	 * We can use T in signature because T is in the scope because of the <T> before
	 * Return type
	 * 
	 * @param list4
	 * @param myComparator
	 * @return
	 */
	private static <T> T minValue(List<T> list4, Comparator<T> myComparator) {
		if (list4.isEmpty())
			throw new IllegalArgumentException("Can't find a minimum in an empty list!");
		T lowest = list4.get(0);
		for (int i = 0; i < list4.size(); i++) {
			final T element = list4.get(i);
			if (myComparator.compare(element, lowest) < 0) {
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
	}

	private static void lambdaMapExample() {
		Map<String, String> map = new HashMap<>();
		map.put("22", "aze");
		map.put("11", "zer");
		map.put("33", "bvc");

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

		System.out.println("Return of head map from the map");
		SortedMap<String, String> hMap = map.headMap("33");
		hMap.forEach((k, v) -> System.out.println(k + " | " + v));

		System.out.println("Return of tail map from the map");
		SortedMap<String, String> tMap = map.tailMap("33");
		tMap.forEach((k, v) -> System.out.println(k + " | " + v));

		System.out.println("Return of sub map from the map");
		SortedMap<String, String> sMap = map.subMap("22", "44");
		sMap.forEach((k, v) -> System.out.println(k + " | " + v));

	}

	private static void iterateOverCollections() {
		MySimpleClass msc1 = new MySimpleClass("label1", "value1");
		MySimpleClass msc2 = new MySimpleClass("label2", "value2");
		MySimpleClass msc3 = new MySimpleClass("label3", "value3");

		Collection<MySimpleClass> col = new ArrayList<>();
		col.add(msc1);
		col.add(msc2);
		col.add(msc3);

		// Multiple ways to do the same thing
		// Traditionnal way: using the iterator
		final Iterator<MySimpleClass> iterator = col.iterator();
		while (iterator.hasNext()) {
			MySimpleClass msc = iterator.next();
			System.out.println(msc.getLabel() + " | " + msc.getValue());
			if (msc.getLabel().equals("toberemoved")) {
				iterator.remove();
			}
		}

		// Since Java 5
		for (MySimpleClass sc : col) {
			System.out.println(sc.getLabel() + " | " + sc.getValue());
			if (sc.getLabel().equals("toberemoved")) {
				// DOESN'T DO THIS:: If we want to add or remove element, use an iterator
				col.remove(sc);
			}
		}

		// Since Java 8 lambda functions
		col.forEach(sc -> System.out.println(sc.getLabel() + " | " + sc.getValue()));
	}
}
