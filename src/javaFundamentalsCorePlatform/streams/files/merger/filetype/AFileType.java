package javaFundamentalsCorePlatform.streams.files.merger.filetype;

import java.util.List;

public abstract class AFileType implements IFileType {

	protected String filePath;
	protected String[] columnNames;
	protected String[] mapping;
	protected int[] indexMapping;
	protected List<String[]> fileContent;

	public void loadTitles() {
		this.columnNames = this.extractColumnNames(filePath);
	}

	public String getFilepath() {
		return filePath;
	}

	public void setFilepath(String filepath) {
		this.filePath = filepath;
	}

	/**
	 * 
	 * @param mapping
	 * @throws Exception
	 *             when mapping with the columns name had failed
	 */
	public void setMapping(String[] mapping) throws Exception {
		this.mapping = mapping;
		this.initializeIndexing();
	}

	public int[] getIndexMapping() {
		return indexMapping;
	}

	/**
	 * 
	 * @param mapping
	 * @param columnNames
	 * @return Tab containing indexes of wanted columns name
	 */
	public int[] findIndexMapping(String[] mapping, String[] columnNames) {
		int[] tab = new int[mapping.length];
		// Fill the tab
		for (int i = 0; i < tab.length; i++) {
			tab[i] = -1;
		}
		// Je parcours tous les noms du fichier de base
		for (int inI = 0; inI < columnNames.length; inI++) {
			// Pour chacun des noms
			for (int outI = 0; outI < mapping.length; outI++) {
				// Je regarde si la valeur corresponds à l'une escomptée
				if (columnNames[inI].equals(mapping[outI])) {
					// map.put(outI, inI);
					tab[outI] = inI;
				}
			}
		}
		// if (tab.length != mapping.length)
		// return null;
		return tab;
	}

	public void initializeIndexing() throws Exception {
		if (mapping == null || columnNames == null)
			throw new Exception("Mapping or columnNames shouldn't be null");
		this.indexMapping = this.findIndexMapping(mapping, columnNames);
	}

	public List<String[]> getFileContent() {
		return fileContent;
	}

	public void setFileContent(List<String[]> fileContent) {
		this.fileContent = fileContent;
	}

}
