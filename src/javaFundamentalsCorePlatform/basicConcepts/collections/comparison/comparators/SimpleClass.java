package javaFundamentalsCorePlatform.basicConcepts.collections.comparison.comparators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleClass {

	private String label, value;
	private Double theDouble;
	private Integer theInteger;

	public SimpleClass(String label, String value, Double theDouble, Integer theInteger) {
		super();
		this.label = label;
		this.value = value;
		this.theDouble = theDouble;
		this.theInteger = theInteger;
	}

	public SimpleClass(String label, String value, Double theDouble) {
		super();
		this.label = label;
		this.value = value;
		this.theDouble = theDouble;
	}

	public SimpleClass(String label, Integer theInteger) {
		super();
		this.label = label;
		this.theInteger = theInteger;
	}

	public SimpleClass(String label, String value) {
		super();
		this.label = label;
		this.value = value;
		this.theDouble = 0D;
	}

	public SimpleClass(SimpleClass sc) {
		super();
		this.label = sc.label;
		this.value = sc.value;
	}

	public static ArrayList<SimpleClass> getNewOne() {
		return new ArrayList<>() {
			{
				add(new SimpleClass("nom1", Integer.valueOf(5000)));
				add(new SimpleClass("nom2", Integer.valueOf(15000)));
			}
		};
	}

	/*
	 * Compare the value field
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleClass other = (SimpleClass) obj;
//		if (value == null && other.value != null) {
//			return false;
//		} else if (!value.equals(other.value))
//			return false;
//		return true;
		// Compare only the value
		// Objects.equals(label, other.label) &&
		return Objects.equals(value, other.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label, value);
	}

	@Override
	public String toString() {
		return label + " | " + value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getTheDouble() {
		return theDouble;
	}

	public void setTheDouble(Double theDouble) {
		this.theDouble = theDouble;
	}

	public Integer getTheInteger() {
		return theInteger;
	}

	public void setTheInteger(Integer theInteger) {
		this.theInteger = theInteger;
	}

}
