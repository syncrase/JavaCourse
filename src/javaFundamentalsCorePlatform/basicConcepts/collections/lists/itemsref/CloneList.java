package javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
import javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils.Duplicator;
import javaFundamentalsCorePlatform.basicConcepts.collections.lists.itemsref.utils.ListComparatorUtil;

/**
 * En plus de ces différentes méthode il existe des third party libraries qui
 * permette le clonage<br>
 * ou l'insterface Cloneable<br>
 * Source : https://www.geeksforgeeks.org/how-to-clone-a-list-in-java/<br>
 * Attention : une liste clonée ne clone pas les éléments
 * 
 * @author syncrase
 *
 */
public class CloneList extends ListComparatorUtil {

	static ArrayList<MySimpleClass> list = new ArrayList<>();
//	static ListComparatorUtil listComparator = new ListComparatorUtil();

	static {
		list.add(new MySimpleClass("a", "1"));
		list.add(new MySimpleClass("b", "2"));
		list.add(new MySimpleClass("c", "3"));
	}

	public static void main(String[] args) {

//		copyWithConstructor(list);
//		copyWithAddAll(list);
//		copyWithStream(list);
//		copyWithClone(list);
	}

	/**
	 * Quatrième approche : utiliser ArrayList#clone()<br>
	 * List n'implémente pas Cloneable
	 */
	private static void copyWithClone(ArrayList<MySimpleClass> list1) {
		ArrayList<MySimpleClass> copiedList = (ArrayList<MySimpleClass>) list1.clone();

		applyChangesAndPrintChecks(list1, copiedList);
	}

	/**
	 * Troisième approche : utiliser Collection#stream()
	 */
	private static void copyWithStream(ArrayList<MySimpleClass> list1) {
		ArrayList<MySimpleClass> copiedList = (ArrayList<MySimpleClass>) list1.stream().collect(Collectors.toList());

		applyChangesAndPrintChecks(list1, copiedList);
	}

	/**
	 * Première approche : utiliser le constructeur
	 */
	private static void copyWithConstructor(ArrayList<MySimpleClass> list1) {
		ArrayList<MySimpleClass> copiedList = new ArrayList<>(list1); // list1 == list2 : false

		applyChangesAndPrintChecks(list1, copiedList);
	}

	/**
	 * Deuxième approche : utiliser addAll
	 */
	private static void copyWithAddAll(ArrayList<MySimpleClass> list1) {
		ArrayList<MySimpleClass> copiedList = new ArrayList<MySimpleClass>();
		copiedList.addAll(list1);

		applyChangesAndPrintChecks(list1, copiedList);
	}

	/**
	 * Méthode pour copier complètement une liste. Les items contenus dans les liste
	 * copiées et résultantes sont différents
	 */
	private static void copyingList() {

		// Collection to array

		MySimpleClass[] tableau;
		// Transformation d'une liste en un tableau
		Duplicator duplicator = new Duplicator();
		tableau = duplicator.arrayFromList(list);
		// TODO Exception in thread "main" java.lang.ClassCastException: class
		// [Ljava.lang.Object; cannot be cast to class
		// [LjavaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
		// ([Ljava.lang.Object; is in module java.base of loader 'bootstrap';
		// [LjavaFundamentalsCorePlatform.basicConcepts.collections.comparison.MySimpleClass;
		// is in unnamed module of loader 'app')
//		a1 = (MySimpleClass[]) list.toArray();

		// MySimpleClass[] a2 = new MySimpleClass[3];
//		MySimpleClass[] a2 = list.toArray(new MySimpleClass[0]);

		// Solution : recréer les items pour avoir de nouvelles références
//		MySimpleClass[] a2 = list.stream().map(sc -> new MySimpleClass(sc)).collect(Collectors.toList())
//				.toArray(new MySimpleClass[0]);

		for (MySimpleClass msc : tableau) {
			msc.setLabel(msc.getLabel() + msc.getLabel());
		}

		// Print values
		System.out.println("\tListe\t\tTableau");
		for (int i = 0; i < tableau.length; i++) {
			System.out.println("\t" + list.get(i) + "\t" + tableau[i]);
		}

//		if (a2 == a1) {
//			System.out.println("Arrays equality just check the length !");
//		}

	}

}
