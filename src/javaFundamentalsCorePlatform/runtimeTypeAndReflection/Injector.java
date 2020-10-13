package javaFundamentalsCorePlatform.runtimeTypeAndReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Injector {

	private Map<Class<?>, Object> objectGraph = new HashMap<>();

	public Injector with(Object value) {
		objectGraph.put(value.getClass(), value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T newInstance(final Class<T> type) {

		return (T) objectGraph.computeIfAbsent(type, this::instantiate);
	}

	/**
	 * TODO
	 * 
	 * @param type
	 * @return
	 */
	private Object instantiate(Class<?> type) {
		try {
			Constructor<?>[] constructors = type.getConstructors();
			if (constructors.length != 1) {
				throw new IllegalArgumentException("Must have one constructor");
			}
			Constructor<?> c = constructors[0];
			Object param = objectGraph.get(objectGraph.keySet().toArray()[0]);
			Object instance = c.newInstance(param);
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
