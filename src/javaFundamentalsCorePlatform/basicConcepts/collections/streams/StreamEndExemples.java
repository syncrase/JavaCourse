package javaFundamentalsCorePlatform.basicConcepts.collections.streams;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators.SimpleClass;

public class StreamEndExemples {

	private static Set<String> mySet = new HashSet<>();
	static {
		mySet.add("test");
		mySet.add("test1");
		mySet.add("test2");
	}

	public static void main(String[] args) {

//		withToArray();
		withCollect();
//		withReduce();
//		collectComputedResult();
//		collectWithToMap();
//		collectMapWithGroupingBy();
//		collectMapWithPartitionBy();
//		extractedCollector();
	}

	private static void withReduce() {

		// sum integers with summingInt or reduce
		List<Integer> ints = Arrays.asList(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2),
				Integer.valueOf(3));
		//
		int divider = 0;
		int theDivisedSum = ints.stream()//
				// .reduce(0, (a, b) -> a + b);
				// .reduce(0, Integer::sum);
				.reduce(0, (a, b) -> {
					try {
						return a / divider + b / divider;
					} catch (ArithmeticException e) {
					}
					return 0;
				});

		String abcde = Arrays.asList("a", "b", "c", "d", "e").stream()//
				// .reduce("", (partialString, element) -> partialString + element);
				.reduce("", String::concat);
		System.out.println("String abcde = " + abcde);
	}

	private static void withCollect() {
		List<String> myList = mySet.stream().collect(Collectors.toList());

		// Concatenated Strings
		String joinedResult = myList.stream().collect(Collectors.joining(", "));
		joinedResult = myList.stream().collect(Collectors.joining(", ", "[", "]"));

		// collect as Set
		Set<String> myList3 = mySet.stream().collect(Collectors.toSet());
		// Specify which set to instantiate
		TreeSet<String> set = myList.stream().collect(Collectors.toCollection(TreeSet::new));

		System.out.println();
		set.stream().peek(e -> {
			System.out.print(e);
		});
		System.out.println();

	}

	private static void collectMapWithPartitionBy() {

		ArrayList<SimpleClass> listOfSimpleClasses = SimpleClass.getNewOne();
		// Partition list based on the field's nullity
		Map<Boolean, List<SimpleClass>> splitOnValueNullity = listOfSimpleClasses.stream().collect(//
				Collectors.partitioningBy(s -> s.getValue() != null)//
		);

	}

	private static void collectMapWithGroupingBy() {

		// Mapping with a groupingBy
		ArrayList<SimpleClass> listOfSimpleClasses = SimpleClass.getNewOne();

		// Regroup items based on the key mapper (method signature or lambda)
		Map<Double, List<SimpleClass>> byDouble = listOfSimpleClasses.stream()
				.collect(groupingBy(SimpleClass::getTheDouble));

		byDouble = listOfSimpleClasses.stream().collect(groupingBy(simpCla -> simpCla.getTheDouble()));

		Map<Double, Integer> totalByDept = listOfSimpleClasses.stream().collect(//
				groupingBy(//
						SimpleClass::getTheDouble, // Classifier function : mapping input to keys
						summingInt(SimpleClass::getTheInteger)// Implementation of the downstream reduction
				));

		Map<Double, Set<String>> setOfLabelsBydoudle = listOfSimpleClasses.stream().collect(//
				groupingBy(//
						SimpleClass::getTheDouble, // Classifier function
						TreeMap::new, // downstream reduction
						mapping(// Map factory
								SimpleClass::getLabel, //
								toSet()//
						)//
				)//
		);//

	}

	private static void extractedCollector() {

		Collector<? super SimpleClass, ?, Map<Double, Set<String>>> collector = groupingBy(//
				SimpleClass::getTheDouble, // Classifier function
				TreeMap::new, // downstream reduction
				mapping(// Map factory
						SimpleClass::getLabel, //
						toSet()//
				)//
		);
		Map<Double, Set<String>> setOfLabelsBydoudle = SimpleClass.getNewOne().stream().collect(collector);//

		// Extract to set
		Collector<SimpleClass, ?, TreeSet<SimpleClass>> intoSet = Collector.of(//
				TreeSet::new, // Supplier
				TreeSet::add, // Accumulator
				(left, right) -> { // Combinor
					left.addAll(right);
					return left;
				}//
		);
		TreeSet<SimpleClass> setOfLabelsBydoudle2 = SimpleClass.getNewOne().stream().collect(intoSet);//
	}

	private static void collectComputedResult() {

		// sum integers with summingInt or reduce
		List<Integer> ints = Arrays.asList(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2),
				Integer.valueOf(3));
		int total = ints.stream().collect(summingInt(a -> a));

		//
		IntSummaryStatistics stats = ints.stream().collect(summarizingInt(a -> a.intValue()));
		System.out.println("average : " + stats.getAverage() + "\nmax" + stats.getMax() + "\nsum" + stats.getSum());

	}

	private static void collectWithToMap() {

		// Mapping with customs key and value mappers
		Map<String, String> myList2 = mySet.stream().collect(toMap(//
				Function.identity(), // mandatory key mapper
				s -> s.toString(), // mandatory value mapper
				(a, b) -> a.toString() + b.toString()// merge function (merge values when keys are equals)
		));
	}

	private static void withToArray() {
		// La taille de la liste est importante
		String[] myList0 = mySet.stream().toArray(a -> new String[mySet.size()]);
	}
}
