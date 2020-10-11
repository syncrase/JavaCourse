package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;

public interface IHandler {

	void handleOn(AbstractElement aEl);

	void handleOn(ElementB el);

	void handleOn(ElementA el);

	void handleOn(ElementContainer el);
}
