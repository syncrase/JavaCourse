package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.IPerformer;

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

	@Override
	public void handleWith(IHandler handler) {
		handler.handleOn(this);

	}

	public String getOnlyElementBValue() {
		return onlyElementBValue;
	}

	public void setOnlyElementBValue(String onlyElementBValue) {
		this.onlyElementBValue = onlyElementBValue;
	}
}
