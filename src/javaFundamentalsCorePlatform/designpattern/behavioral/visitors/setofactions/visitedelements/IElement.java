package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements;


import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitors.ISetOfAction;

import java.util.ArrayList;

/**
 * Permet de prendre en compte la classe interfa��e dans les �l�ments
 * @author I310911
 *
 */
public interface IElement {
	/**
	 * Cette m�thode est, par convention, cens�e appeler toute les autres m�mes m�thodes dans les Elements fils et finalement appeler la m�thode performOn(?)
	 * @param Elementvisitor
	 */
	void performSetOfAction(ISetOfAction Elementvisitor); // Elements have to provide
													// accept().

	/**
	 * Un Element peut poss�der une liste contenant tout ses parents
	 * @param childs
	 */
	void resetChildren(ArrayList<IElement> childs);

	/**
	 * Ajoute un Element � la fin de la liste
	 * @param element
	 */
	void addChild(IElement element);
}
