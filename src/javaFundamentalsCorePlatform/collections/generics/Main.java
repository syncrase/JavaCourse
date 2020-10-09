package javaFundamentalsCorePlatform.collections.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static class StringList extends ArrayList<String> {

	}

	public static void main(String[] args) {

		List<String> strings = new ArrayList<>();

		System.out.println(Arrays.toString(strings.getClass().getTypeParameters()));
		System.out.println(strings.getClass());
		System.out.println(strings.getClass().toGenericString());
		final ParameterizedType arraylistOfStrings = (ParameterizedType) StringList.class.getGenericSuperclass();
		// Extract the type of parent parameterized superclass at runtime
		System.out.println(Arrays.toString(arraylistOfStrings.getActualTypeArguments()));
	}

}
