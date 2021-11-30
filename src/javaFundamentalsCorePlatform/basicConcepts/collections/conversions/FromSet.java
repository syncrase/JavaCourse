package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FromSet {

	static Set<String> s = new HashSet<String>();

	static {
		s.add("Geeks");
		s.add("for");
	}

	public static void main(String[] args) {
		toArray();
		toMap();
		toList();
		toCollection();
	}

	private static void toList() {
		// Simple copy
		List<String> lList = new LinkedList<String>(s);
		// static list copy
		lList = List.copyOf(s); // Unmodifiable
	}

	/**
	 * See examples in ${StreamEndExamples}<br>
	 * groupingBy<br>
	 * toMap<br>
	 */
	private static void toMap() {
		Map<String, List<String>> rsult = s.stream().collect(groupingBy(String::toString));
	}

	private static void toArray() {
		String[] myArray = new String[s.size()];// Instantiate the rigth size array
		myArray = s.toArray(myArray);// Fill the array with the set method
		myArray = s.stream().toArray(String[]::new);// With method reference
		myArray = s.stream().toArray(n -> new String[n]);// With lambda expression
	}

	private static void toCollection() {
		Collection<String> set = s.stream().collect(Collectors.toCollection(ArrayList::new));
		set = s.stream().collect(Collectors.toList());
	}

}
