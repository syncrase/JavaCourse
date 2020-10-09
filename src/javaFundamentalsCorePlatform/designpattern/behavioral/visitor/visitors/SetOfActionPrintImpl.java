package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.Element;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.TheMostSimpleElement;

public class SetOfActionPrintImpl implements ISetOfAction {

	@Override
	public void performOn(TheMostSimpleElement el) {
		System.out.print(el.getName());
	}

	@Override
	public void performOn(Element el) {
		System.out.print(el.getName());
	}

	@Override
	public void performOn(ElementContainer el) {
		System.out.print(el.getName());
	}

	@Override
	public void performOn(AbstractElement aEl) {
		System.out.print(aEl.getName());

	}

}
