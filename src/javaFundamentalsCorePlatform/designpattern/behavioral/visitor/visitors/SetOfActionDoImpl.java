package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.Element;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.TheMostSimpleElement;

public class SetOfActionDoImpl implements ISetOfAction {

	@Override
	public void performOn(TheMostSimpleElement el) {
		// CSV
		System.out.println("Do " + el.getName());
	}

	@Override
	public void performOn(Element el) {
		// XLS
		System.out.println("Do " + el.getName());
	}

	@Override
	public void performOn(ElementContainer el) {
		// PDF
		System.out.println("Do " + el.getName());
	}

	@Override
	public void performOn(AbstractElement aEl) {
		try {
			throw new Exception("PerformOn depuis la classe abstraite");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
