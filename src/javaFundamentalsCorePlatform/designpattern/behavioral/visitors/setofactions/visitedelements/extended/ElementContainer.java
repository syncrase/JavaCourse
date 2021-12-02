package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.AbstractElement;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.IElement;

import java.util.ArrayList;

public class ElementContainer extends AbstractElement {

	public ElementContainer(String name) {
		super();
		this.name = name;

		this.resetChildren(new ArrayList<IElement>());
		
		this.addChild(new Element("Albert"));
		this.addChild(new TheMostSimpleElement("Alain"));

		IElement el = new Element("Robert");
		ArrayList<IElement> children = new ArrayList<IElement>();
		children.add(new Element("Robin"));
		children.add(new Element("Roger"));
		children.add(new Element("Rivoli"));
		children.add(new Element("Rollo"));
		children.add(new Element("Richard"));
		el.resetChildren(children);
		el.addChild(new TheMostSimpleElement("Rolland"));
		
		this.addChild(el);

	}

}
