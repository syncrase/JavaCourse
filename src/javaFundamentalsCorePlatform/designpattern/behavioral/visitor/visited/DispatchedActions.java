package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.hanldler.IHandler;
import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.IPerformer;

/**
 * Implement this interface in order to activate the visitor behaviour<br>
 * Defines actions which are available to be dispatch
 * 
 * @author Pierre TAQUET
 *
 */
public interface DispatchedActions {
	/**
	 * 
	 * This method must be override and contain the performer.performOn(this) call
	 * in order to use the IPerformer(Object o) overloading
	 * 
	 * @param Elementvisitor
	 */
	void performWith(IPerformer performer);

	void handleWith(IHandler handler);
}
