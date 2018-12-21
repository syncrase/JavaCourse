package javaFundamentalsCorePlatform.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collections {

	public static void main(String[] args) {
//		removalExample();
//		lambdaListExample();
//		conversionExample();
//		comparableExample();
//		mapExample();
//		lambdaMapExample();
		sortedMapExample();

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
		TreeSet<MyComparableClass> list = new TreeSet<>();

		list.add(new MyComparableClass("aze", "22"));
		list.add(new MyComparableClass("rty", "11"));
		list.add(new MyComparableClass("bio", "33"));

		System.out.println("MyComparableClass define comparaison on value");
		list.forEach(m -> System.out.println(m.toString()));

		// Example with a custom comparator
		System.out.println("MySimpleClass with a custom comparator which compare on label");
		TreeSet<MySimpleClass> list1 = new TreeSet<>(new MyComparator());

		list1.add(new MySimpleClass("aze", "22"));
		list1.add(new MySimpleClass("rty", "11"));
		list1.add(new MySimpleClass("bio", "33"));

		list1.forEach(m -> System.out.println(m.toString()));

	}

	private static void mapExample() {
		Map<String, String> map = new HashMap<>();
		map.put("22", "aze");
		map.put("11", "zer");
		map.put("33", "bvc");
		System.out.println(map.get("11"));
		System.out.println(map.get("99"));
		System.out.println(map.getOrDefault("99", "default value"));

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

}
