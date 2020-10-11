package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.DispatchedActions;

public class PerformerB implements IPerformer {

	@Override
	public void performOn(ElementB el) {
		System.out.print("specific performOn ElementB");
		System.out.println(" I am " + el.name + " and " + el.getOnlyElementBValue());
	}

	@Override
	public void performOn(ElementA el) {
		System.out.print("specific performOn ElementA");
		System.out.println(" I am " + el.name);
	}

	@Override
	public void performOn(ElementContainer el) {
		System.out.print("specific performOn ElementContainer");
		System.out.println(" I am " + el.name + " and I have " + el.childElements.size() + " children");

		if (el.childElements != null && el.childElements.size() > 0) {
			for (DispatchedActions element : el.childElements) {
				element.performWith(this);
			}
		}
	}

	@Override
	public void performOn(AbstractElement aEl) {
		try {
			throw new Exception("PerformOn depuis la classe abstraite");
		} catch (Exception e) {
			System.out.println("Do " + e.getLocalizedMessage());
		}
	}

}
