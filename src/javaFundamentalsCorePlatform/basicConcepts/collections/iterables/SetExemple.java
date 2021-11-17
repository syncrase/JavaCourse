package javaFundamentalsCorePlatform.basicConcepts.collections.iterables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExemple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> mySet = new HashSet<>();
		mySet.add("test");

		/**
		 * Le set implémente la Collection qui elle-même implémente l'Iterable</br>
		 * La méthode forEach est définie par défaut dans l'interface Iterable
		 */
		mySet.forEach(lotId -> {
			// Nouveau contexte => nouveau try catch
		});
		// On peut facilement supprimer des items avec l'itérator
		// avec for et for-each c'est plus complexe car la liste change de taille
		// https://www.w3schools.com/java/java_iterator.asp
		// Le spliterator ?
		// https://stackoverflow.com/questions/18410035/ways-to-iterate-over-a-list-in-java
		// https://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
		Iterator<String> it = mySet.iterator();
		String str1;
		while (it.hasNext()) {
			str1 = it.next();
		}
		for (String str2 : mySet) {

		}

		/**
		 * Les méthodes ci-dessous sont définies dans l'interface Collection</br>
		 * Le parallelStream utilise le spliterator
		 */
		mySet.parallelStream().peek(id -> {
		});
		mySet.stream().peek(id -> {
		});

		/**
		 * Le set est convertible en un tableau
		 */
		String[] myArray = mySet.toArray(new String[0]);
		/**
		 * Le set est convertible via les collectors des streams (cf.
		 * CollectorsExemples)
		 */

	}

}
