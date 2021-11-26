package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;

public class ListComparatorUtil {

	public static void applyChangesAndPrintChecks(ArrayList<MySimpleClass> list1, ArrayList<MySimpleClass> copiedList) {
		printAllChecks(list1, copiedList);

		System.out.println("******************************************************* Changement de valeur");
		System.out.println("copiedList.get(0).setValue(\"8\");");
		copiedList.get(0).setValue("8");// La référence ne change pas => changement dans les deux listes
		printAllChecks(list1, copiedList);

		System.out.println("******************************************************* Changement de référence");
		System.out.println("copiedList.set(0, new MySimpleClass(\"a\", \"1\"));");
		copiedList.set(0, new MySimpleClass("a", "1"));// La référence change
		printAllChecks(list1, copiedList);
	}

	public static void printAllChecks(ArrayList<MySimpleClass> list1, ArrayList<MySimpleClass> copiedList) {
		print("list1 : ", list1);
		print("list2 : ", copiedList);
		printListEqualities(list1, copiedList);
		printValuesReferencesEquality(list1, copiedList);
		printLists(list1, copiedList);
	}

	public static void printLists(ArrayList<MySimpleClass> list1, ArrayList<MySimpleClass> list2) {

		System.out.println("lists references are the same ? " + (list2 == list1));
		print("list1 : ", list1);
		print("list2 : ", list2);
	}

	public static void printListEqualities(ArrayList<MySimpleClass> list1, ArrayList<MySimpleClass> list2) {
		System.out.println("check reference (==) : " + (list2 == list1));
		System.out.println("check values (equals()) : " + (list2.equals(list1)));
	}

	public static void printValuesReferencesEquality(ArrayList<MySimpleClass> list1, ArrayList<MySimpleClass> list2) {
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("Les références des éléments sont les mêmes ? " + (list1.get(i) == list2.get(i)));
		}

	}

	public static void print(String title, List<MySimpleClass> l) {
		System.out.println(title + l.stream().map(item -> item.toString()).collect(Collectors.joining(", ", "[", "]")));
	}
}
