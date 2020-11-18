package javaFundamentalsCorePlatform.basicConcepts.collections;

import java.util.Comparator;

/**
 * Compare on labels
 * 
 * @author Pierre
 *
 */
public class SimpleClassComparator implements Comparator<MySimpleClass> {

	@Override
	public int compare(MySimpleClass arg0, MySimpleClass arg1) {
		return arg0.getLabel().compareToIgnoreCase(arg1.getLabel());
	}

}
