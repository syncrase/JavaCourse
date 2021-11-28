package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class ListToArray {

	public static void main(String[] args) {
		// Collection to array
		ArrayList<SimpleClass> list = new ArrayList<>();

		list.add(new SimpleClass("abc", "1"));
		list.add(new SimpleClass("aze", "2"));
		list.add(new SimpleClass("abc", "3"));

		SimpleClass[] a1;
		// These two notations are equivalents
		a1 = list.toArray(new SimpleClass[0]);
		a1 = (SimpleClass[]) list.toArray();

		SimpleClass[] a2 = new SimpleClass[3];
		SimpleClass[] a3 = list.toArray(a2);

		if (a2 == a3) {
			// lists are the same one
			System.out.println("Arrays equality just check the length !");
		}
	}

}
