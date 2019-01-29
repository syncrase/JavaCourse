package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements.extended;

import java.util.ArrayList;

import fr.exp.patterns.behavioral.visitor.visitedelements.AbstractElement;
import fr.exp.patterns.behavioral.visitor.visitedelements.IElement;

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
