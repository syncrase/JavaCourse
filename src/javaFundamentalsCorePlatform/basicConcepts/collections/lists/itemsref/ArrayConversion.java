package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

/**
 * Exemples pour changer le type d'une collections mais garder les mémes
 * références pour les objets contenus<br>
 * Les éléments eux-mémes ne sont pas copiés
 */
public class ArrayConversion {

	static ArrayList<SimpleClass> list = new ArrayList<>();
	static {
		list.add(new SimpleClass("abc", "1"));
		list.add(new SimpleClass("aze", "2"));
		list.add(new SimpleClass("abc", "3"));
	}

	public static void main(String[] args) {

		listToArrayExample();
		arrayToListExample();
		overrideToArrayExample();

	}

	private static void listToArrayExample() {

		// Transformation d'une liste en un tableau (les items contenus sont les mêmes!)
//		MySimpleClass[] tableau = list.toArray(new MySimpleClass[0]);
		// Cast impossible
		// TODO Exception in thread "main" java.lang.ClassCastException: class
		// [Ljava.lang.Object; cannot be cast to class
		// [LjavaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
		// ([Ljava.lang.Object; is in module java.base of loader 'bootstrap';
		// [LjavaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
		// is in unnamed module of loader 'app')
//		MySimpleClass[] tableau = (MySimpleClass[]) list.toArray();

		SimpleClass[] tableau = new SimpleClass[0];
//		tableau = 
		tableau = list.toArray(tableau);

		// Modification des valeurs du tableau résultant
		for (SimpleClass msc : tableau) {
			msc.setLabel(msc.getLabel() + msc.getLabel());
		}

		// Comparaison de la liste et du tableau
		System.out.println("\tListe\t\tTableau");
		for (int i = 0; i < tableau.length; i++) {
			System.out.println("" + list.get(i) + "\t" + tableau[i]);
		}

		// ==> les éléments de la liste initiale ont changées

		// Comparaison des références des éléments de la liste et du tableau
		for (int i = 0; i < tableau.length; i++) {
			System.out.println("Les références des éléments sont les mémes ? " + (list.get(i) == tableau[i]));
		}

	}

	private static void overrideToArrayExample() {
		// TODO syso
		SimpleClass[] tableau1 = (SimpleClass[]) list.toArray(new IntFunction<SimpleClass[]>() {
			@Override
			public SimpleClass[] apply(int value) {
//				return new MySimpleClass(list.get(value));
				return new SimpleClass[value];
			}
		});
	}

	private static void arrayToListExample() {

		/*
		 * array to list
		 */
		SimpleClass[] myArray = { new SimpleClass("abc", "1"), new SimpleClass("aze", "2"),
				new SimpleClass("abc", "3") };

		// https://stackoverflow.com/questions/3317381/what-is-the-difference-between-collection-and-list-in-java
//		Collection<MySimpleClass> collection = Arrays.asList(myArray);
		List<SimpleClass> list1 = Arrays.asList(myArray);
		// Comparaison des références des éléments de la liste et du tableau
		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Les références des éléments sont les mêmes ? " + (list1.get(i) == myArray[i]));
		}

	}
}
