package javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels;

import java.util.ArrayList;

import fr.exp.files.pearltrees.database.dto.*;
import fr.exp.files.pearltrees.database.skeleton.DataTransfertObject;

/**
 * Equivalent Java correspondant au model 'Url'
 * 
 * @author Pierre
 *
 */
public class TaggedUrl {

	private UrlsDTO url;
	// private ArrayList<FoldedTag> tags;
	private ArrayList<TagsDTO> tags;
	private PathsDTO path;

	// public TaggedUrl(UrlsDTO url, ArrayList<FoldedTag> tags) {
	// super();
	// this.url = url;
	// this.tags = tags;
	// }
	public TaggedUrl(UrlsDTO url, ArrayList<TagsDTO> tags) {
		super();
		this.url = url;
		this.tags = tags;
	}

	// public TaggedUrl(UrlsDTO url, FoldedTag tag, int path) {
	// super();
	// this.url = url;
	// this.tags = new ArrayList<FoldedTag>();
	// this.tags.add(tag);
	// this.path = new PathsDTO(path);
	// }
	public TaggedUrl(UrlsDTO url, TagsDTO tag, int path) {
		super();
		this.url = url;
		this.tags = new ArrayList<TagsDTO>();
		this.tags.add(tag);
		this.path = new PathsDTO(path);
	}

	public UrlsDTO getUrl() {
		return url;
	}

	public void setUrl(UrlsDTO url) {
		this.url = url;
	}

	/**
	 * 
	 * @return liste de FoldedTag
	 */
	public ArrayList<TagsDTO> getTags() {
		return tags;
	}

	public void setTags(ArrayList<TagsDTO> tags) {
		this.tags = tags;
	}

	public void setPath(PathsDTO path) {
		this.path = path;
	}

	public void setPathId(int path) {
		this.path.setId(path);
	}

	public PathsDTO getPath() {
		return path;
	}

	public void setPath(DataTransfertObject path) {
		this.path = (PathsDTO) path;
	}

	/**
	 * Ajoute un tag dans la liste de tag.
	 * 
	 * @param tag
	 * @param id_parent_tag
	 */
	public void addTag(TagsDTO tag, int id_parent_tag) {
		tags.add(tag);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("url{");
		sb.append(url.getLabel());
		sb.append(";");
		sb.append(url.getUrl());
		sb.append("}");
		sb.append("tags{");
		for (TagsDTO ft : tags) {
			sb.append(ft.getTag());
			sb.append((tags.indexOf(ft) < (tags.size() - 1)) ? ", " : "");
		}
		sb.append("}");
		return sb.toString();
	}

}
