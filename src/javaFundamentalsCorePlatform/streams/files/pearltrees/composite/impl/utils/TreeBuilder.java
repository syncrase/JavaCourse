package javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl.utils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl.INode;
import javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl.PearltreesComposite;
import javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl.PearltreesLeaf;

/**
 * This method allow to handle the parse result in order to generate the
 * representative tree structure
 * 
 * @author Pierre
 *
 */
public abstract class TreeBuilder {

	/**
	 * Method specific to the html export of pearltrees. Must be generalized.
	 * Protected to be available for subclasses , PearltreesComposite parentFolder
	 * This is an iterative method called where this class is extended and use .
	 * Transform the html structure to a java tree structure
	 * 
	 * @allElements JSoup elements containing html
	 * @parent parent of the node currently building
	 * @return void
	 */
	protected void build(Elements allElements, PearltreesComposite parent) {
		INode component = null;
		boolean lookForFolderContent = false;
		Element htmlTag;
		String url, urlLabel;
		for (int i = 0; i < allElements.size(); i++) {
			htmlTag = allElements.get(i);
			if (!lookForFolderContent) {
				if (htmlTag.tagName().equals("h3")) {
					// Folder building
					// first occurence the name is null
					if (parent.getFolderName() == null) {
						component = parent;
						((PearltreesComposite) component).setFolderName(htmlTag.ownText());
					} else {
						// Add the folder to the current folder
						component = new PearltreesComposite();
						((PearltreesComposite) component).setFolderName(htmlTag.ownText());
						parent.addINode(component);
					}
					// See later for the folder filling
					lookForFolderContent = true;
				}
				if (htmlTag.tagName().equals("a")) {
					url = htmlTag.attr("href");
					urlLabel = htmlTag.ownText();
					component = new PearltreesLeaf();
					((PearltreesLeaf) component).setUrl(url);
					((PearltreesLeaf) component).setLabel(urlLabel);
					((PearltreesComposite) this).addINode(component);
				}
			} else {
				// If I am here it's because I've found an h3 tag and I'm
				// waiting for the whole content in the dl tag
				if (htmlTag.tagName().equals("dl")) {
					// L'objet entity à déjà été ajouté à la liste des
					// folders
					// L'appel récursif de buildObject oblige
					((PearltreesComposite) component).build(htmlTag.getAllElements(),
							((PearltreesComposite) component));
					lookForFolderContent = false;
					// Go after all the previous computed
					i += htmlTag.getAllElements().size();
				}
			}
		}
	}

}
