package javaFundamentalsCorePlatform.streams.files.merger.skeleton;

import java.util.regex.Pattern;

import javaFundamentalsCorePlatform.streams.files.merger.filetype.CSV;
import javaFundamentalsCorePlatform.streams.files.merger.filetype.IFileType;
import javaFundamentalsCorePlatform.streams.files.merger.filetype.XLS;

public class MergeableFileFactory {

	/**
	 * Handle csv and xls files
	 * 
	 * @param filePath
	 * @return
	 */
	public static IFileType getMergeableFile(String filePath) {

		MergeableFileFactory factory = new MergeableFileFactory();
		switch (factory.getExtension(filePath)) {
		case "csv":
			CSV csv = new CSV();
			csv.setFilepath(filePath);
			csv.setSeparator(";");
			return csv;
		case "xls":
			XLS xls = new XLS();
			xls.setFilepath(filePath);
			xls.loadTitles();
			return xls;
		default:
			break;
		}
		return null;
	}

	/**
	 * Return the file extension in lowercase
	 * 
	 * @param filePath
	 * @return
	 */
	private String getExtension(String filePath) {
		String[] tab = filePath.split(Pattern.quote("."));
		return tab[tab.length - 1].toLowerCase();
	}

}
