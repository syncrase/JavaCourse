package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.IPerformer;

import java.util.ArrayList;

public class ElementContainer extends AbstractElement {

	public ArrayList<DispatchedActions> childElements;

	public ElementContainer(String name) {
		super();
		this.name = name;
		this.childElements = new ArrayList<>();
	}

	//@Override
	//public void performWith(IPerformer performer) {

		//performer.performOn(this);
	//}

	//@Override
	public void handleWith(IHandler handler) {
		//handler.handleOn(this);

	}

	public void resetChildren(ArrayList<DispatchedActions> childs) {
		this.childElements = childs;
	}

	public void addChild(DispatchedActions element) {

		//this.childElements.add(element);
	}

	public void initElementContainer() {
		//this.resetChildren(new ArrayList<DispatchedActions>());

		//this.addChild(new ElementA("Albert"));
		//this.addChild(new ElementB("Alain", "I'm something"));

		//this.addChild(new ElementA("Robert"));

		ElementContainer cont = new ElementContainer("coucou");
		ArrayList<DispatchedActions> robertChildren = new ArrayList<>();
		//robertChildren.add(new ElementA("Richard"));
		//cont.resetChildren(robertChildren);
		//cont.addChild(new ElementB("Rolland", "I'm something"));
		//this.addChild(cont);

	}

	@Override
	public void performWith(IPerformer performer) {
		// TODO Auto-generated method stub
		
	}

}
