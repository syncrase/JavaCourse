package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.Element;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended.TheMostSimpleElement;

public interface ISetOfAction {

	void performOn(AbstractElement aEl);

	void performOn(TheMostSimpleElement el);

	void performOn(Element el);

	void performOn(ElementContainer el);
}
