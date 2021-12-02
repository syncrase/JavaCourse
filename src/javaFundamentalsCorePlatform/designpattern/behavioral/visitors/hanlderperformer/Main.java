package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.DispatchedActions;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited.ElementContainer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler.HandlerA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler.HandlerB;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.IPerformer;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.PerformerA;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.PerformerB;

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
