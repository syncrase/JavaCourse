package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.IPerformer;

public class ElementA extends AbstractElement {

	public ElementA(String name) {
		super();
		this.name = name;
	}

	@Override
	public void performWith(IPerformer performer) {
		performer.performOn(this);
	}

}
