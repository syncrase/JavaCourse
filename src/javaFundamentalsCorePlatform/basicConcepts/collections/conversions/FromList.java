package javaFundamentalsCorePlatform.basicConcepts.collections.conversions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

/**
 * Java core examples<br>
 * It's also possible to use third parties libraries like :
 * <ul>
 * <li>guava</li>
 * <li>appache commons</li>
 * </ul>
 * 
 * @author syncrase
 *
 */
public class FromList {

	static ArrayList<SimpleClass> list = new ArrayList<>();

	static {
		list.add(new SimpleClass("abc", "1"));
		list.add(new SimpleClass("aze", "2"));
		list.add(new SimpleClass("abc", "3"));
	}

	public static void main(String[] args) {

		toArray();
		toMap();
		toSet();
	}

	private static void toSet() {
		Set<SimpleClass> foo = new HashSet<SimpleClass>(list);
	}

	private static void toMap() {
		Map<String, Set<String>> map = list.stream().collect(//
				Collectors.groupingBy(//
						SimpleClass::getLabel, //
						Collectors.mapping(//
								e -> e.getValue(), //
								Collectors.toSet()//
						)//
				)//
		);

		System.out.println("Map : " + map);

		Map<Integer, SimpleClass> map2 = list.stream().collect(//
				Collectors.toMap(//
						SimpleClass::getTheInteger, //
						Function.identity()//
				)//
		);

	}

	private static void toArray() {
		// Collection to array

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
