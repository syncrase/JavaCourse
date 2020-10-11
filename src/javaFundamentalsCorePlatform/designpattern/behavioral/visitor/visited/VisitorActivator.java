package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

/**
 * Implement this interface in order to activate the visitor behaviour
 * 
 * @author Pierre TAQUET
 *
 */
public interface VisitorActivator {
	/**
	 * 
	 * This method must be override and contain the setOfAction.performOn(this);
	 * call in order to use the ISetOfAction:performOn(Object o) overloading
	 * 
	 * @param Elementvisitor
	 */
	void performAction(ISetOfAction Elementvisitor);
}
