package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.sorting;

import java.util.Arrays;
import java.util.List;

public class SortWithProvidedTypeComparison {

	public static void main(String[] args) {
		sortWithDoubleComparators();
	}

	private static void sortWithDoubleComparators() {
		List<Float> testList = Arrays.asList(0.5F, 0.5F, 0.2F, 0.9F, 0.1F, 0.1F, 0.1F, 0.54F, 0.71F, 0.71F, 0.71F,
				0.92F, 0.12F, 0.65F, 0.34F, 0.62F);

		testList.sort((a, b) -> Double.compare(b, a));
		testList.forEach(m -> System.out.println(m.toString()));

		List<Integer> intList = Arrays.asList(5, 2, 9, 1, 1, 1, 54, 71, 71, 71, 92, 12, 65, 34, 62);
		intList.sort((a, b) -> Integer.compare(b, a));
		intList.forEach(m -> System.out.println(m.toString()));

	}

}
