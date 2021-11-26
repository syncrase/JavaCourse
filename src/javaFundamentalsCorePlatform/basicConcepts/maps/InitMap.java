package javaFundamentalsCorePlatform.basicConcepts.maps;

import static java.util.Map.entry;
import static java.util.stream.Collectors.toMap;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.collections4.MapUtils;

public class InitMap {

	public static Map<String, Object> mapOne;

	static {
		// Init in static initializer block
		mapOne = new HashMap<>();
		mapOne.put("ar01", "Intro to Map");
		mapOne.put("ar02", "Some article");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void initializing() {
		// With an anonymous class
		Map<String, Object> m = new HashMap<String, Object>() {
			private static final long serialVersionUID = 8410429510878404798L;
			{
				put("key", 1);
				put("seq", 2);

			}
		};

//		Guava
//		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);

		// this works for up to 10 elements:
		Map<String, String> test1 = Map.of("a", "b", "c", "d");

		// this works for any number of elements:
		Map<String, String> test2 = Map.ofEntries(entry("a", "b"), entry("c", "d"));

		// Apache utils
		MapUtils.putAll(new HashMap<String, String>(), new Object[] { "My key", "my value" });

		// With SimpleEntry and toMap
		Map<String, String> myMap = Stream.of(//
				new SimpleEntry<>("key1", "value1"), //
				new SimpleEntry<>("key2", "value2"), //
				new SimpleEntry<>("key3", "value3"))//
				.collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));

		// Instanciate an inmutable map
		Map<String, String> animalSounds = Map.of(//
				"dog", "bark", // key , value
				"cat", "meow", // key , value
				"bird", "chirp" // key , value
		);

		Map<Object, Object> weekdayWorker = Map.ofEntries(//
				Map.entry("", "value"), // Call to `Map.entry` method returns
										// an object implementing
										// `Map.Entry`.
				Map.entry("key", "value"), //
				Map.entry("key", "value"), //
				Map.entry("key", "value"), //

				Map.entry("key", "value")//
		);

		// Immutable copy of existing map
		Map<Object, Object> immutableMap = Map.copyOf(test1);

	}

}
