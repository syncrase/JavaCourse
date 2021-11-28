package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators;

import java.util.Comparator;

/**
 * Compare on labels
 * 
 * @author Pierre
 *
 */
public class SimpleClassComparator implements Comparator<SimpleClass> {

	@Override
	public int compare(SimpleClass arg0, SimpleClass arg1) {
		return arg0.getLabel().compareToIgnoreCase(arg1.getLabel());
	}

}
