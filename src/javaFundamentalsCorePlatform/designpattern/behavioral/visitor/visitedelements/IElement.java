package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

/**
 * Permet de prendre en compte la classe interfaçée dans les éléments
 * @author I310911
 *
 */
public interface IElement {
	/**
	 * Cette méthode est, par convention, censée appeler toute les autres mêmes méthodes dans les Elements fils et finalement appeler la méthode performOn(?)
	 * @param Elementvisitor
	 */
	void performSetOfAction(ISetOfAction Elementvisitor); // Elements have to provide
													// accept().

	/**
	 * Un Element peut posséder une liste contenant tout ses parents
	 * @param childs
	 */
	void resetChildren(ArrayList<IElement> childs);

	/**
	 * Ajoute un Element à la fin de la liste
	 * @param element
	 */
	void addChild(IElement element);
}
