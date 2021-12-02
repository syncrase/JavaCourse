package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementContainer;

public interface IHandler {

	void handleOn(AbstractElement aEl);

	void handleOn(ElementB el);

	void handleOn(ElementA el);

	void handleOn(ElementContainer el);
}
