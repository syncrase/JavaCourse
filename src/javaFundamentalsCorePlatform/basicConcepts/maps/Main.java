package javaFundamentalsCorePlatform.basicConcepts.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		mapExample();
		sortedMapExample();
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
