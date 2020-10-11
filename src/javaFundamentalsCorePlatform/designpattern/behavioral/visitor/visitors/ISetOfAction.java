package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;

public interface ISetOfAction {

	void performOn(AbstractElement aEl);

	void performOn(ElementB el);

	void performOn(ElementA el);

	void performOn(ElementContainer el);
}
