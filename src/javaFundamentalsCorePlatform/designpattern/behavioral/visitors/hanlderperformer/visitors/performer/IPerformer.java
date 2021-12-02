package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementContainer;

public interface IPerformer {

	void performOn(AbstractElement aEl);

	void performOn(ElementB el);

	void performOn(ElementA el);

	void performOn(ElementContainer el);
}
