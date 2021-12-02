package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementContainer;

public class HandlerB implements IHandler {

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
