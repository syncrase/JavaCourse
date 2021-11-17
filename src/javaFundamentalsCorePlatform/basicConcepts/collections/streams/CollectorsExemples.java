package javaFundamentalsCorePlatform.basicConcepts.collections.streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsExemples {

	public static void main(String[] args) {

		Set<String> mySet = new HashSet<>();
		mySet.add("test");

		List<String> myList = mySet.stream().collect(Collectors.toList());
		// La taille de la liste est importante
		String[] myList2 = mySet.stream().toArray(a -> new String[mySet.size()]);

		// TODO groupingBy
	}
}
