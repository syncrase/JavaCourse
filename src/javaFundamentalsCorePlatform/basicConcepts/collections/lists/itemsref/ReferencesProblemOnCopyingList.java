package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;

public class ReferencesProblemOnCopyingList {

	static ArrayList<MySimpleClass> list = new ArrayList<>();
	static {
		list.add(new MySimpleClass("abc", "1"));
		list.add(new MySimpleClass("aze", "2"));
		list.add(new MySimpleClass("abc", "3"));
	}

	public static void main(String[] args) {
//		copyingList();
	}


}
