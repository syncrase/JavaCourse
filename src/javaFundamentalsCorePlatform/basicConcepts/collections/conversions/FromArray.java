package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;

public class FromArray {

	public static void main(String[] args) {
		toCollection();

	}

	private static void toCollection() {
		// Array to Collection
		MySimpleClass[] myArray = { //
				new MySimpleClass("abc", "1"), //
				new MySimpleClass("aze", "2"), //
				new MySimpleClass("abc", "3") //
		};

		// https://stackoverflow.com/questions/3317381/what-is-the-difference-between-collection-and-list-in-java
		Collection<MySimpleClass> collection = Arrays.asList(myArray);
		List<MySimpleClass> list1 = Arrays.asList(myArray);
	}

}
