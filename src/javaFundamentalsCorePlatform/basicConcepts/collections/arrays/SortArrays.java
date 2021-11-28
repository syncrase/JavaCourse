package javaFundamentalsCorePlatform.basicConcepts.collections.arrays;

import java.util.Arrays;

public class SortArrays {

	public static void main(String[] args) {

		int[] toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };

		Arrays.sort(toSort, 3, 7);

		Arrays.parallelSort(toSort);

		Arrays.sort(toSort, 3, 7);

	}

}
