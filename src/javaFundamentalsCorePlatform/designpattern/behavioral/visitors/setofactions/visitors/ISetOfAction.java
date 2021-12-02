package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitors;


import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.Element;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended.TheMostSimpleElement;

public interface ISetOfAction {

	void performOn(AbstractElement aEl);

	void performOn(TheMostSimpleElement el);

	void performOn(Element el);

	void performOn(ElementContainer el);
}
