package javaFundamentalsCorePlatform.basicConcepts.collections.comparison;

public class MySimpleClass {

	private String label, value;

	public MySimpleClass(String label, String value) {
		super();
		this.label = label;
		this.value = value;
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
		MySimpleClass other = (MySimpleClass) obj;
		if (value == null && other.value != null) {
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

}
