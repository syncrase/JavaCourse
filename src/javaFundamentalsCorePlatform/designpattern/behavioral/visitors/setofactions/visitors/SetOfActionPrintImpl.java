package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitors;


import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.Element;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.TheMostSimpleElement;

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
