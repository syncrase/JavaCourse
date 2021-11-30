package javaFundamentalsCorePlatform.basicConcepts.collections.copy;

import java.util.HashSet;
import java.util.Set;

public class CloneSet {

	static Set<String> s = new HashSet<String>();

	static {
		s.add("Geeks");
		s.add("for");
	}

	public static void main(String[] args) {
		Set<String> targetSet = Set.copyOf(s);// Inmodifiable
	}

}
