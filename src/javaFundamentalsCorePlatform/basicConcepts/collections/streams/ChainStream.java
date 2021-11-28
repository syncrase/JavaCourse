package javaFundamentalsCorePlatform.basicConcepts.collections.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class ChainStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Accumulate names into a List
		List<SimpleClass> people = new ArrayList<>() {
			{
				add(new SimpleClass("nom1", Integer.valueOf(5000)));
				add(new SimpleClass("nom2", Integer.valueOf(15000)));
			}
		};

		List<String> list = people.stream()//
				.map(SimpleClass::getLabel)//
				.sorted(
						// Definition of the sort logic withg the Comparator builder
						Comparator.comparing(String::toString).reversed()//
				)//
				.collect(Collectors.toList());

	}

}
