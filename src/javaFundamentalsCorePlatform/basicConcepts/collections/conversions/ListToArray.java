package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;

public class ListToArray {

	public static void main(String[] args) {
		// Collection to array
		ArrayList<MySimpleClass> list = new ArrayList<>();

		list.add(new MySimpleClass("abc", "1"));
		list.add(new MySimpleClass("aze", "2"));
		list.add(new MySimpleClass("abc", "3"));

		MySimpleClass[] a1;
		// These two notations are equivalents
		a1 = list.toArray(new MySimpleClass[0]);
		a1 = (MySimpleClass[]) list.toArray();

		MySimpleClass[] a2 = new MySimpleClass[3];
		MySimpleClass[] a3 = list.toArray(a2);

		if (a2 == a3) {
			// lists are the same one
			System.out.println("Arrays equality just check the length !");
		}
	}

}
