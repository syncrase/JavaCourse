package javaFundamentalsCorePlatform.collections;

/**
 * <T extends Comparable<T>> means that passed values implements Comparable and
 * that they are comprable between them ________________________________________
 * This class guarantee that passed arguments are sorted on instanciation time
 * 
 * @author Pierre
 *
 * @param <T>
 */
public class SortedPair<T extends Comparable<T>> {

	private final T first;
	private final T second;

	public SortedPair(T first, T second) {
		if (first.compareTo(second) < 0) {
			// Second is greater than first
			this.first = first;
			this.second = second;
		} else if (second.compareTo(first) > 0) {
			// first is greater than second
			this.first = second;
			this.second = first;
		} else {
			// Second and first are equals
			this.first = first;
			this.second = first;

		}

	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

}