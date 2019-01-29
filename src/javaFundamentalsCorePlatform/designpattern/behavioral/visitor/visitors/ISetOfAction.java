package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors;

import fr.exp.patterns.behavioral.visitor.visitedelements.AbstractElement;
import fr.exp.patterns.behavioral.visitor.visitedelements.extended.Element;
import fr.exp.patterns.behavioral.visitor.visitedelements.extended.ElementContainer;
import fr.exp.patterns.behavioral.visitor.visitedelements.extended.TheMostSimpleElement;

public interface ISetOfAction {

	void performOn(AbstractElement aEl);

	void performOn(TheMostSimpleElement el);

	void performOn(Element el);

	void performOn(ElementContainer el);
}
