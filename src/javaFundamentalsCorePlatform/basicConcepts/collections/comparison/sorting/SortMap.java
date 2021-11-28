package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMap {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(55, "John");
		map.put(22, "Apple");
		map.put(66, "Earl");
		map.put(77, "Pearl");
		map.put(12, "George");
		map.put(6, "Rocky");

		// Sort by key
		List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		// Sort by value
		entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
	}

}
