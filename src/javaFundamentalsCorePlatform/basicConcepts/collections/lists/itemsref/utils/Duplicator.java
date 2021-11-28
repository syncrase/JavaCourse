package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

/**
 * These methods return an entirely new list of elements
 * 
 * @author syncrase
 *
 */
public class Duplicator {

	public SimpleClass[] arrayFromList(List<SimpleClass> list) {
		return list.stream()//
				.map(sc -> new SimpleClass(sc))//
				.collect(Collectors.toList())//
				.toArray(new SimpleClass[0]);
	}

	public SimpleClass[] arrayFromArray(SimpleClass[] array) {
		return Arrays.stream(array)//
				.collect(Collectors.toList())//
				.toArray(new SimpleClass[0]);
	}
}
