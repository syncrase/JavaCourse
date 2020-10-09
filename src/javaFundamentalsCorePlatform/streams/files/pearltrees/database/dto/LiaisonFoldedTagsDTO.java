package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;

/**
 * Les dto sont adaptée à retourner exactement les valeurs à inscrire en bdd.
 * 
 * @author Pierre
 *
 */
public class LiaisonFoldedTagsDTO implements DataTransfertObject {

	// En soit ça ne servira jamais à rien d'avoir ces objets. Mais ça permet
	// d'avoir une arborescence précise d'où ces objets sont utilisés
	int id_liaison_folded_tags;
	PathsDTO path;
	TagsDTO parent;
	TagsDTO tag;

	public LiaisonFoldedTagsDTO(int path_id, int id_tag, int id_tag_parent) {
		super();
		this.path = new PathsDTO(path_id);
		this.parent = new TagsDTO(id_tag_parent);
		this.tag = new TagsDTO(id_tag);
		this.id_liaison_folded_tags = 0;
	}

	@Override
	public int getId() {
		return id_liaison_folded_tags;
	}

	@Override
	public void setId(int id) {
		this.id_liaison_folded_tags = id;
	}

	public int getPath() {
		return path.getId();
	}

	public void setPath(int path) {
		this.path.setId(path);
	}

	public int getParent() {
		return parent.getId();
	}

	public void setParent(int parent) {
		this.parent.setId(parent);
	}

	public int getTag() {
		return tag.getId();
	}

	public void setTag(int tag) {
		this.tag.setId(tag);
	}

}
