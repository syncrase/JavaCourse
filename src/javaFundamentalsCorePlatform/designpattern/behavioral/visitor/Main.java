package javaFundamentalsCorePlatform.designpattern.behavioral.visitor;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.DispatchedActions;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.IPerformer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.PerformerA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.PerformerB;

public class Main {

	public static void main(String[] args) {

		System.out.println("[run] " + Main.class);

		DispatchedActions elementContainer = new ElementContainer("Alfred");
		((ElementContainer) elementContainer).initElementContainer();

		visitorUseExample(elementContainer);

	}

	private static void visitorUseExample(DispatchedActions elementContainer) {
		// Sets of actions to perform
		IPerformer performerA = new PerformerA();
		IPerformer performerB = new PerformerB();

		elementContainer.performWith(performerA);
		System.out.println();
		System.out.println();
		elementContainer.performWith(performerB);
		System.out.println();
		System.out.println();

		DispatchedActions a = new ElementA("Element A");
		a.performWith(performerB);
		a.performWith(performerA);
	}

}
