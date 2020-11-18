package javaFundamentalsCorePlatform.basicConcepts.collections.generics;

public class GenericSimpleImpl<T> {

	private T[] array;
	private int size = 0;

	private int cursor = 0;

	public GenericSimpleImpl(int size) {
		array = (T[]) new Object[size];
	}

	public boolean addSomething(T tObj) {
		if (array[cursor] != null) {
			return false;
		}
		array[cursor] = tObj;
		++cursor;
		return true;
	}

	public T getSomething() {

		return array[cursor];
	}
}
