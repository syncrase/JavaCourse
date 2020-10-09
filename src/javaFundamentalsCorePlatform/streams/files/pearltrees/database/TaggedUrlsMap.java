package javaFundamentalsCorePlatform.streams.files.pearltrees.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels.TaggedUrl;

/**
 * Cet objet permet de stocker toutes les lignes de r�sultat d'une r�qu�te. Cet
 * objet est utile pour pouvoir traiter le r�sultat des requ�tes
 * 
 * @author Pierre Taquet
 *
 */
public class TaggedUrlsMap {

	Map<Integer, TaggedUrl> pool;

	public TaggedUrlsMap() {
		this.pool = new HashMap<Integer, TaggedUrl>();
	}

	public void add(TaggedUrl taggedUrl) {
		pool.put(new Integer(taggedUrl.getUrl().getId()), taggedUrl);
	}

	public ArrayList<TaggedUrl> getArrayList() {
		ArrayList<TaggedUrl> returnedList = new ArrayList<TaggedUrl>();
		for (Integer i : this.pool.keySet()) {
			returnedList.add(pool.get(i));
		}
		return returnedList;
	}

	/*
	 * ICI, je peux impl�menter pleins de m�thodes pour manipuler les donn�es et
	 * de les revoir en bdd Ici ou dans une classe abstraite !
	 */

	/**
	 * V�rifie s'il y a des urls doublons dans la liste.
	 */
	public void checkDoublon() {

	}
}
