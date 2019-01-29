package javaFundamentalsCorePlatform.streams.files.merger.ioimpl;

public class TextBasicsImpl {

	public String[] cleanStrings(String[] columnNames, String[] toDelete) {
		for (int i = 0; i < columnNames.length; i++) {
			columnNames[i] = columnNames[i].trim();
			columnNames[i] = columnNames[i].replaceAll("\"", " ");

			columnNames[i] = columnNames[i].trim();
		}
		return columnNames;
	}

	public String[] getCleanedValues(String lineWithValues, String separator, String[] charsToDelete) {
		String[] returnedTab = lineWithValues.split(separator);
		returnedTab = this.cleanStrings(returnedTab, charsToDelete);
		return returnedTab;
	}

}
