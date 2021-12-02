package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visited;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.hanlderperformer.visitors.performer.IPerformer;

/**
 * Cette classe abstraite permet d'h�riter de l'ensemble impl�ment� des m�thodes
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
