package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.IPerformer;

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
