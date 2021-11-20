package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;

/**
 * These methods return an entirely new list of elements
 * 
 * @author syncrase
 *
 */
public class Duplicator {

	public MySimpleClass[] arrayFromList(List<MySimpleClass> list) {
		return list.stream()//
				.map(sc -> new MySimpleClass(sc))//
				.collect(Collectors.toList())//
				.toArray(new MySimpleClass[0]);
	}

	public MySimpleClass[] arrayFromArray(MySimpleClass[] array) {
		return Arrays.stream(array)//
				.collect(Collectors.toList())//
				.toArray(new MySimpleClass[0]);
	}
}
