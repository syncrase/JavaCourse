package javaFundamentalsCorePlatform.collections;

import java.util.Comparator;

public class MyComparator implements Comparator<MySimpleClass> {

	@Override
	public int compare(MySimpleClass arg0, MySimpleClass arg1) {
		return arg0.getLabel().compareToIgnoreCase(arg1.getLabel());
	}

}
