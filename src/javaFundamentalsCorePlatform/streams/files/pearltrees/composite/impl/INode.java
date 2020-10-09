package javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl;

import java.util.ArrayList;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.TagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels.TaggedUrl;

/**
 * This interface gathers methods that must be implemented by tree elements
 * 
 * @author Pierre
 *
 */
public interface INode {

	public String getHtmlFormat(int depth);

	public ArrayList<TaggedUrl> getFoldedTags(ArrayList<TagsDTO> path);
}
