package javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl;

import java.util.ArrayList;
import java.util.List;

import fr.exp.files.pearltrees.composite.impl.utils.TreeBuilder;
import fr.exp.files.pearltrees.database.dto.TagsDTO;
import fr.exp.files.pearltrees.metamodels.TaggedUrl;

/**
 * Extends the TreeBuilder class in order to add the build behavior
 * 
 * @author Pierre
 *
 */
public class PearltreesComposite extends TreeBuilder implements INode {

	private String folderName;

	/*
	 * Collection of child Component This is either a url or a folder
	 */
	private List<INode> nodeList = new ArrayList<INode>();

	/**
	 * @depth used for the indentation
	 * @return the html format of the pearltrees tree structure
	 */
	@Override
	public String getHtmlFormat(int depth) {
		String returnedString = "";
		String tab = "";
		for (int i = 0; i < depth; i++) {
			tab += "\t";
		}
		returnedString += tab + "<DT><H3 FOLDED ADD_DATE=\"1364146937\">" + this.folderName + "</H3>\n";
		returnedString += tab + "<DD><DL><p>\n";
		for (INode component : nodeList) {
			returnedString += component.getHtmlFormat(depth + 1);
		}

		returnedString += tab + "</DL><p>\n";
		return returnedString;
	}

	/**
	 * @path
	 * @return
	 */
	@Override
	public ArrayList<TaggedUrl> getFoldedTags(ArrayList<TagsDTO> path) {
		ArrayList<TaggedUrl> taggedUrlList = new ArrayList<TaggedUrl>();
		ArrayList<TagsDTO> tempPath;
		for (INode node : this.nodeList) {
			tempPath = new ArrayList<TagsDTO>();
			tempPath.addAll(path);
			tempPath.add(new TagsDTO(folderName));
			taggedUrlList.addAll(node.getFoldedTags(tempPath));
		}
		return taggedUrlList;
	}

	/**
	 * Adds the component to the component list.
	 * 
	 * @param component
	 */
	public void addINode(INode component) {
		nodeList.add(component);
	}

	// public void removeINode(INode component) {
	// nodeList.remove(component);
	// }

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
