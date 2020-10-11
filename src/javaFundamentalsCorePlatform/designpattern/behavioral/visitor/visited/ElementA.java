package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

public class ElementA extends AbstractElement {

	public ElementA(String name) {
		super();
		this.name = name;
	}

	@Override
	public void performAction(ISetOfAction setOfAction) {
		setOfAction.performOn(this);
	}

}
