package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class FromArray {

	public static void main(String[] args) {
		toCollection();

	}

	private static void toCollection() {
		// Array to Collection
		SimpleClass[] myArray = { //
				new SimpleClass("abc", "1"), //
				new SimpleClass("aze", "2"), //
				new SimpleClass("abc", "3") //
		};

		// https://stackoverflow.com/questions/3317381/what-is-the-difference-between-collection-and-list-in-java
		Collection<SimpleClass> collection = Arrays.asList(myArray);
		List<SimpleClass> list1 = Arrays.asList(myArray);
	}

}
