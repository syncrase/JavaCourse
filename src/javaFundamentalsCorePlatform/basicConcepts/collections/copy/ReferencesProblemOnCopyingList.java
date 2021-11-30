package javaFundamentalsCorePlatform.basicConcepts.collections.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class ReferencesProblemOnCopyingList {

	static ArrayList<SimpleClass> list = new ArrayList<>();
	static {
		list.add(new SimpleClass("abc", "1"));
		list.add(new SimpleClass("aze", "2"));
		list.add(new SimpleClass("abc", "3"));
	}

	public static void main(String[] args) {
//		copyingList();
	}


}
