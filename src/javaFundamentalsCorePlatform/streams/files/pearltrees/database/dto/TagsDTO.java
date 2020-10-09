package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;

public class TagsDTO implements DataTransfertObject {

	int id_tag;
	String tag;

	public TagsDTO(int id_tag, String tag) {
		super();
		this.id_tag = id_tag;
		this.tag = tag;
	}

	public TagsDTO(String tag) {
		super();
		this.id_tag = 0;
		this.tag = tag;
	}

	public TagsDTO() {
	}

	public TagsDTO(int id_tag_parent) {
		this.id_tag = id_tag_parent;
		this.tag = "";
	}

	@Override
	public int getId() {
		return id_tag;
	}

	@Override
	public void setId(int id_tag) {
		this.id_tag = id_tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String toString() {
		return this.getId() + ":" + this.getTag();
	}
}
