package javaFundamentalsCorePlatform.designpattern.behavioral.visitor;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.VisitorActivator;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.NamePrinter;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.SpecificPrinter;

public class Main {

	public static void main(String[] args) {

		System.out.println("[run] " + Main.class);

		VisitorActivator elementContainer = new ElementContainer("Alfred");
		initElementContainer((ElementContainer) elementContainer);

		visitorUseExample(elementContainer);

	}

	private static void visitorUseExample(VisitorActivator elementContainer) {
		// Sets of actions to perform
		ISetOfAction nameVisitor = new NamePrinter();
		ISetOfAction specificVisitor = new SpecificPrinter();

		elementContainer.performAction(nameVisitor);
		System.out.println();
		System.out.println();
		elementContainer.performAction(specificVisitor);
		System.out.println();
		System.out.println();

		VisitorActivator a = new ElementA("Element A");
		a.performAction(specificVisitor);
		a.performAction(nameVisitor);
	}

	private static void initElementContainer(ElementContainer elementContainer) {
		elementContainer.resetChildren(new ArrayList<VisitorActivator>());

		elementContainer.addChild(new ElementA("Albert"));
		elementContainer.addChild(new ElementB("Alain", "I'm something"));

		elementContainer.addChild(new ElementA("Robert"));

		ElementContainer cont = new ElementContainer("coucou");
		ArrayList<VisitorActivator> robertChildren = new ArrayList<VisitorActivator>();
		robertChildren.add(new ElementA("Richard"));
		cont.resetChildren(robertChildren);
		cont.addChild(new ElementB("Rolland", "I'm something"));
		elementContainer.addChild(cont);

	}

}
