package javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitedelements;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.designpattern.behavioral.visitor.visitors.ISetOfAction;

/**
 * Cette classe abstraite permet d'hériter de l'ensemble implémenté des méthodes
 * de l'interface
 * 
 * @author I310911
 *
 */
public abstract class AbstractElement implements IElement {

	public String name;

	public ArrayList<IElement> childElements;

	public AbstractElement() {
		super();
		this.name = "";
		this.childElements = new ArrayList<IElement>();
	}

	public String getName() {
		return name;
	}

	@Override
	public void performSetOfAction(ISetOfAction setOfAction) {
		// // Tous les Elements peuvent avoir un comportement différents (code
		// // écrit ici) mais ne sont finalement traités que dans
		// l'implémentation
		// //
		// // Some code before...
		// //
		// for (IElement element : childElements) {
		// element.performSetOfAction(setOfAction);
		// }
		// //
		// // Some code after...
		// //
		// setOfAction.performOn(this);

		// This signature must appears in the ISetOfAction.java
		setOfAction.performOn(this);

		// Appel du code commun à tous les IElement
		if (this.childElements != null && this.childElements.size() > 0) {
			System.out.print(" père de {");
			// for (IElement element : this.childElements) {
			// element.performSetOfAction(setOfAction);
			// }

			// WARNING!!! TRICKY FOR LOOP
			for (int i = 0; i < this.childElements.size(); this.childElements.get(i).performSetOfAction(
					setOfAction), i++, /*
										 * Tout le temps sauf quand c'est au
										 * début
										 */System.out.print(i < this.childElements.size() ? ", " : "")) {
				// Tout le temps sauf quand c'est au début
				// System.out.print(i != 0 ? ", " : "");
			}
			System.out.print("}");
		}

	}

	@Override
	public void resetChildren(ArrayList<IElement> childs) {
		this.childElements = childs;
	}

	@Override
	public void addChild(IElement element) {
		this.childElements.add(element);
	}
}
