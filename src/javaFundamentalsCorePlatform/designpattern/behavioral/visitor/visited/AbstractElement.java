package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.performer.IPerformer;

/**
 * Cette classe abstraite permet d'hériter de l'ensemble implémenté des méthodes
 * de l'interface
 * 
 * @author Pierre TAQUET
 *
 */
public abstract class AbstractElement implements DispatchedActions {

	public String name;

	public AbstractElement() {
		super();
	}

	/**
	 * The logic will be different based on the performer passed in parameter
	 */
	@Override
	public void performWith(IPerformer performer) {
		performer.performOn(this);
	}

}
