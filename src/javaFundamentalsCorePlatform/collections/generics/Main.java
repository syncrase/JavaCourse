package javaFundamentalsCorePlatform.collections.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static class StringList extends ArrayList<String> {

	}

	public static void main(String[] args) {

//		List<String> strings = new ArrayList<>();
//		Class<?> stringsType = strings.getClass();
//		final TypeVariable<? extends Class<?>>[] typeParameters = stringsType.getTypeParameters();
//
//		System.out.println(Arrays.toString(typeParameters));
//		System.out.println(stringsType);
//		System.out.println(stringsType.toGenericString());
		final ParameterizedType arraylistOfStrings = (ParameterizedType) StringList.class.getGenericSuperclass();
		// Extract the type of parent parameterized superclass at runtime
		System.out.println(Arrays.toString(arraylistOfStrings.getActualTypeArguments()));
	}

}
