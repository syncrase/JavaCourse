package javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.TagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.UrlsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels.TaggedUrl;

public class PearltreesLeaf implements INode {

	private String url;
	private String label;

	@Override
	public String getHtmlFormat(int depth) {
		String returnedString = "";
		// String tab = "";
		// for (int i = 0; i < depth; i++) {
		// tab += "\t";
		// }
		// returnedString += tab;
		// returnedString += "<DT><A HREF=\"" + this.getUrl() + "\"";
		// returnedString += " ADD_DATE=\"1482700435\">" + this.getLabel() + "</A>\n";
		// // returnedString += tab + this.getUrl() + "\n";

		return returnedString;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public ArrayList<TaggedUrl> getFoldedTags(ArrayList<TagsDTO> path) {
		UrlsDTO url = null;
		try {
			url = new UrlsDTO(new URL(this.url), this.label);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		TaggedUrl taggedUrl = new TaggedUrl(url, path);
		ArrayList<TaggedUrl> returnedList = new ArrayList<TaggedUrl>();
		returnedList.add(taggedUrl);
		return returnedList;
	}

}
