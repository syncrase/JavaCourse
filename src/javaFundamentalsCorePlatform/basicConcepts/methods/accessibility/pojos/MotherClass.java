package javaFundamentalsCorePlatform.basicConcepts.methods.accessibility.pojos;

public abstract class MotherClass {

	public void publicMethod() {

	}

	/*
	 * Private methods canno't be extended by child classes
	 */
	private void privateMethod() {
	}

	protected void protectedMethod() {

	}
}
