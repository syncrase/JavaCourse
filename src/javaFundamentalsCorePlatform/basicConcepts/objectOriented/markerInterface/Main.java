package javaFundamentalsCorePlatform.basicConcepts.objectOriented.markerInterface;

import java.io.IOException;
import java.io.Serializable;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		final String folder = "serialized/";
		final String filename = "account.dat";
		Serializer serializer = new Serializer(folder, filename);

		MultiMarkedClass multiMarked = new MultiMarkedClass(123456, "strin");

		serializer.serialize(multiMarked);

		multiMarked = serializer.deserialize();

		System.out.println(multiMarked.j + " : " + multiMarked.s);

		try {
			MultiMarkedClass multiMarked2 = (MultiMarkedClass) multiMarked.clone();
			System.out.println("Two different object ? " + (multiMarked2 != multiMarked));
			System.out.println("Values are equals ? " + multiMarked2.equals(multiMarked));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

class MultiMarkedClass implements Serializable, Cloneable, MarkerInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6413056374265893398L;
	int j;
	String s;

	public MultiMarkedClass(int j, String s) {
		this.j = j;
		this.s = s;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		MultiMarkedClass o = (MultiMarkedClass) obj;
		return o.j == this.j && o.s.equals(this.s);
	}

}
