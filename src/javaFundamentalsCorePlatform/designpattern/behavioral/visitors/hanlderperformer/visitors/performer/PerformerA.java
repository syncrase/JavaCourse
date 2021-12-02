package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.DispatchedActions;

public class PerformerA implements IPerformer {

	/*
	 * Here, some interfaces can be used by each visitor to handle some specific
	 * tasks. Or an abstract class
	 */

	@Override
	public void performOn(ElementB el) {
		System.out.print("name performOn ElementB");
		System.out.println(" I am " + el.name);
	}

	@Override
	public void performOn(ElementA el) {
		System.out.print("name performOn ElementA");
		System.out.println(" I am " + el.name);
	}

	@Override
	public void performOn(ElementContainer el) {
		System.out.print("name performOn ElementContainer");
		System.out.println(" I am " + el.name);

		if (el.childElements != null && el.childElements.size() > 0) {
			for (DispatchedActions element : el.childElements) {
				element.performWith(this);
			}
		}
	}

	@Override
	public void performOn(AbstractElement el) {
		System.out.print("print " + el.name);
		// Some actions for AbstractElement
	}

}
