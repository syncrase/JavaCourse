package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.DispatchedActions;

public class PerformerA implements IPerformer {

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
