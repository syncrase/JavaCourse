package javaFundamentalsCorePlatform.basicConcepts.collections.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

/**
 * Remove in item from a list calls the equals() method of the list.<br>
 * It impacts methods :
 * <ul>
 * <li>contains</li>
 * <li>remove</li>
 * <li>removeAll</li>
 * <li>...</li>
 * </ul>
 */
public class RemoveFromList {

	public static void main(String[] args) {

		ArrayList<SimpleClass> list = new ArrayList<>();

		SimpleClass c1 = new SimpleClass("a", "1");
		SimpleClass c2 = new SimpleClass("b", "2");
		SimpleClass c3 = new SimpleClass("c", "1");
		list.add(c1);
		list.add(c2);
		list.add(c3);

		displayList(list);

		SimpleClass c4 = new SimpleClass("d", "1");
		System.out.println("new MySimpleClass(\"d\", \"1\") : " + c4);
		System.out.println("list.contains(c4) : " + list.contains(c4));

		System.out.println("list.remove(c3) with c3 = " + c3);
		list.remove(c3);// Supprime le premier item pour qui equals == true
		displayList(list);

		System.out.println("list.removeAll(List.of(c4)) with c4 = " + c4);
		list.removeAll(List.of(c4));// Supprime tous les items pour lesquels equals == true
		displayList(list);

		// Remove item without the equals method
		list.removeIf(m -> m.getLabel().equals("a") && m.getValue().contentEquals("1"));
	}

	private static void displayList(ArrayList<SimpleClass> list) {
		System.out.println("all items are : "
				+ list.stream().map(item -> item.toString()).collect(Collectors.joining(", ", "[", "]")));
	}

}
