package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

public class ElementContainer extends AbstractElement {

	public ArrayList<VisitorActivator> childElements;

	public ElementContainer(String name) {
		super();
		this.name = name;
		this.childElements = new ArrayList<VisitorActivator>();
	}

	@Override
	public void performAction(ISetOfAction setOfAction) {
		setOfAction.performOn(this);
	}

	public void resetChildren(ArrayList<VisitorActivator> childs) {
		this.childElements = childs;
	}

	public void addChild(VisitorActivator element) {
		this.childElements.add(element);
	}

}
