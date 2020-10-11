package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.IPerformer;

public class ElementB extends AbstractElement {

	public String onlyElementBValue;

	public ElementB(String name, String onlyElementBValue) {
		super();
		this.onlyElementBValue = onlyElementBValue;
		this.name = name;
	}

	@Override
	public void performWith(IPerformer performer) {
		performer.performOn(this);
	}

	public String getOnlyElementBValue() {
		return onlyElementBValue;
	}

	public void setOnlyElementBValue(String onlyElementBValue) {
		this.onlyElementBValue = onlyElementBValue;
	}
}
