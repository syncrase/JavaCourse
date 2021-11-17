package javaFundamentalsCorePlatform.basicConcepts.collections.iterables.interfaces;

import java.util.Iterator;
import java.util.Spliterator;

public class MyIterableClass<T> implements Iterable<T> {

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		// Utilisation de l'interface iterable
		MyIterableClass<String> itCl = new MyIterableClass<>();

		itCl.forEach(str -> {
			System.out.println(str);
		});

		Spliterator<String> spliterator = itCl.spliterator();
		// TODO spliterator.
	}

}
