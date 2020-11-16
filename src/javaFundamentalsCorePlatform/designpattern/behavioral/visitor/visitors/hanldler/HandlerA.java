package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;

public class HandlerA implements IHandler {

	/*
	 * Here, some interfaces can be used by each visitor to handle some specific
	 * tasks. Or an abstract class
	 */

	@Override
	public void handleOn(AbstractElement aEl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleOn(ElementB el) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleOn(ElementA el) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleOn(ElementContainer el) {
		// TODO Auto-generated method stub

	}
}
