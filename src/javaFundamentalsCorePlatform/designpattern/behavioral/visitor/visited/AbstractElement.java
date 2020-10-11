package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

/**
 * Cette classe abstraite permet d'hériter de l'ensemble implémenté des méthodes
 * de l'interface
 * 
 * @author Pierre TAQUET
 *
 */
public abstract class AbstractElement implements VisitorActivator {

	public String name;

	public AbstractElement() {
		super();
	}

	/**
	 * The logic will be different based on the setOfAction passed in parameter
	 */
	@Override
	public void performAction(ISetOfAction setOfAction)  {
		setOfAction.performOn(this);
	}

}
