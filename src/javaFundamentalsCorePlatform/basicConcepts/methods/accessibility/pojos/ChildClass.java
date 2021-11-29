package javaFundamentalsCorePlatform.basicConcepts.methods.accessibility.pojos;

public class ChildClass extends MotherClass {

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.publicMethod();
		// cc.privateMethod(); Can't be called on the living object
		cc.protectedMethod();// Can be called because Child and Mother Class are in the same package
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
