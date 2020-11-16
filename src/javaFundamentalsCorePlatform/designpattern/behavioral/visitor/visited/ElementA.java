package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.IPerformer;

public class ElementA extends AbstractElement {

	public ElementA(String name) {
		super();
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

}
