package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

public class ElementB extends AbstractElement {

	public String onlyElementBValue;

	public ElementB(String name, String onlyElementBValue) {
		super();
		this.onlyElementBValue = onlyElementBValue;
		this.name = name;
	}

	@Override
	public void performAction(ISetOfAction setOfAction) {
		setOfAction.performOn(this);
	}

	public String getOnlyElementBValue() {
		return onlyElementBValue;
	}

	public void setOnlyElementBValue(String onlyElementBValue) {
		this.onlyElementBValue = onlyElementBValue;
	}
}
