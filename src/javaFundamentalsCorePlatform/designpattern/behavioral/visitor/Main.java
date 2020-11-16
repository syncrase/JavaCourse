package javaFundamentalsCorePlatform.designpattern.behavioral.visitor;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.DispatchedActions;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.HandlerA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.HandlerB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.IPerformer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.PerformerA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.PerformerB;

public class Main {

	public static void main(String[] args) {

		System.out.println("[run] " + Main.class);

		// My object on which I can dispatch actions
		DispatchedActions elementContainer = new ElementContainer("Alfred");
		((ElementContainer) elementContainer).initElementContainer();

		// My dispatched actions
		IPerformer performerA = new PerformerA();
		IPerformer performerB = new PerformerB();
		IHandler handlerA = new HandlerA();
		IHandler handlerB = new HandlerB();

		// Sets of actions to perform
		elementContainer.performWith(performerA);
		System.out.println();
		System.out.println();
		elementContainer.performWith(performerB);
		System.out.println();
		System.out.println();

		// Sets of actions to handle
		elementContainer.handleWith(handlerA);
		System.out.println();
		System.out.println();
		elementContainer.handleWith(handlerB);
		System.out.println();
		System.out.println();

	}

}
