package javaFundamentalsCorePlatform.basicConcepts.collections;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private final Comparator<T> delegateComparator;

	public ReverseComparator(Comparator<T> delegateComparator) {
		super();
		this.delegateComparator = delegateComparator;
	}

	@Override
	public int compare(final T left, final T right) {
		return -1 * delegateComparator.compare(left, right);
	}

}
