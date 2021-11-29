package javaFundamentalsCorePlatform.basicConcepts.methods.accessibility;

import javaFundamentalsCorePlatform.basicConcepts.methods.accessibility.pojos.ChildClass;
import javaFundamentalsCorePlatform.basicConcepts.methods.accessibility.pojos.MotherClass;

public class OutterPackageChildClass extends MotherClass {

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.publicMethod();
		// cc.privateMethod(); Can't be called out of the class declaration
		// cc.protectedMethod(); Can't be accessed by non-sibling class declaration
	}

	public void testMethodAccessibility() {
		this.publicMethod();
		// this.privateMethod();// Can't be accessed by child object
		this.protectedMethod();
	}

	@Override
	public void publicMethod() {
		super.publicMethod();
	}

	@Override
	protected void protectedMethod() {
		super.protectedMethod();
	}

}
