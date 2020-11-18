package javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {

		/**
		 * Define the implementation of the functional interface with a lambda
		 * expression
		 */
		FuncInterface<Integer> fi = (i, d) -> i + d;
		FuncInterface<Integer> fi2 = (i, d) -> i * d;

		System.out.println(fi.doSomething(1, 1));
		System.out.println(fi2.doSomething(1, 1));

		/**
		 * Define the implementation of the functional interface with an anonymous class
		 */
		FuncInterface<Integer> fi3 = new FuncInterface<Integer>() {
			@Override
			public Integer doSomething(Integer i, Integer d) {
				return i / d;
			}
		};
		System.out.println(fi3.doSomething(1, 1));

		int res = new FuncInterface<Integer>() {
			@Override
			public Integer doSomething(Integer i, Integer d) {
				return i - d;
			}
		}.doSomething(1, 1);
		System.out.println(res);

		//

		UseFunctionalInterface<Integer> qsd = new UseFunctionalInterface<Integer>();
		List<Integer> list = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		qsd//
				.add(list)//
				.display()//
				.apply((i, d) -> i + d)//
				.apply((i, d) -> i + d)//
				.display();

		list.stream().map(i -> i).collect(Collectors.toList());
	}

}

class UseFunctionalInterface<T> {

	List<T> list;

	public UseFunctionalInterface() {
		this.list = new ArrayList<T>();
	}

	public UseFunctionalInterface<T> display() {
		System.out.println(list);
		return this;
	}

	public UseFunctionalInterface<T> add(List<T> collect) {
		list.addAll(collect);
		return this;
	}

	public UseFunctionalInterface<T> apply(FuncInterface<T> fi) {

		for (int i = 0; i < list.size(); i++) {
			list.set(i, fi.doSomething(list.get(i), list.get(i)));
		}
		return this;
	}

}