package javaFundamentalsCorePlatform.streams.files.merger.filetype;

import java.util.ArrayList;
import java.util.List;

import javaFundamentalsCorePlatform.streams.files.merger.ioimpl.FileBasicsImpl;
import javaFundamentalsCorePlatform.streams.files.merger.ioimpl.TextBasicsImpl;
import javaFundamentalsCorePlatform.streams.files.merger.skeleton.IMergeableFile;

public class CSV extends AFileType implements IMergeableFile {

	protected String separator;
	protected String[] charsToDelete;

	public String[] extractColumnNames(String filePath) {
		FileBasicsImpl fb = new FileBasicsImpl();
		TextBasicsImpl tb = new TextBasicsImpl();
		String firstLine = fb.getFirstLineAsString(filePath);
		return tb.getCleanedValues(firstLine, separator, charsToDelete);
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String[] getCharsToDelete() {
		return charsToDelete;
	}

	public void setCharsToDelete(String[] charsToDelete) {
		this.charsToDelete = charsToDelete;
	}

	// @Override
	// public List<String> getAllLines() {
	// FileBasicsImpl fb = new FileBasicsImpl();
	// return fb.getAllLines(this.getFilepath());
	// }

	@Override
	public void loadFile() {
		// FileBasicsImpl fb = new FileBasicsImpl();
		// List<String> lines = fb.getAllLines(this.getFilepath());
		// TextBasicsImpl tb = new TextBasicsImpl();
		// fileContent = new ArrayList<String[]>();
		// for (int i = 0; i < lines.size(); i++) {
		// fileContent.add(tb.getCleanedValues(lines.get(i), separator, charsToDelete));
		// }
	}

	@Override
	public void loadTitles() {
		FileBasicsImpl fb = new FileBasicsImpl();
		List<String> lines = fb.getAllLines(this.getFilepath());
		TextBasicsImpl tb = new TextBasicsImpl();
		fileContent = new ArrayList<String[]>();
		String[] row;
		// Only get titles
		for (int i = 0; i < 1; i++) {
			row = tb.getCleanedValues(lines.get(i), separator, charsToDelete);
			fileContent.add(row);
		}
	}

	@Override
	public List<String[]> getFileContent() {
		return fileContent;
	}

}
