package javaFundamentalsCorePlatform.collections;

/**
 * Compared by value
 * 
 * @author Pierre
 *
 */
public class MyComparableClass implements Comparable<MyComparableClass> {

	private String label, value;

	public MyComparableClass(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

//	/* Compare the label field
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		MyClass other = (MyClass) obj;
//		if (label == null) {
//			if (other.label != null)
//				return false;
//		} else if (!label.equals(other.label))
//			return false;
//		return true;
//	}

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
		MyComparableClass other = (MyComparableClass) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
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

	/*
	 * this < other => - ; this = other => 0 ; this > other => +
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MyComparableClass other) {
		return value.compareToIgnoreCase(other.getValue());
	}

}
