package javaFundamentalsCorePlatform.basicConcepts.objectOriented.interfaces.markerInterface;

import java.io.Serializable;

public class MultiMarkedClass implements Serializable, Cloneable, MarkerInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6413056374265893398L;
	int j;
	String s;

	/**
	 * No way to be serialized
	 */
	public transient int publicTransientInt;

	public MultiMarkedClass() {
		System.out.println("I'm the super ?");
	}

	public MultiMarkedClass(int j, String s) {
		System.out.println("I'm the constructor");
		this.j = j;
		this.s = s;
		this.publicTransientInt = 111;
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
		// TODO differences between all of this?
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		if (!(obj instanceof MultiMarkedClass)) {
			return false;
		}

		MultiMarkedClass o = (MultiMarkedClass) obj;
		return o.j == this.j && o.s.equals(this.s);
	}

}
