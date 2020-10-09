package javaFundamentalsCorePlatform.streams.files.merger.filetype;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javaFundamentalsCorePlatform.streams.files.merger.skeleton.IMergeableFile;

public class XLS extends AFileType implements IMergeableFile {

	private String separator = ";";

	public String getSeparator() {
		return separator;
	}

	public String[] extractColumnNames(String filePath) {
		this.filePath = System.getProperty("user.dir") + "/" + filePath;
		String[] returnedArray = {};
		// https://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row = sheet.getRow(0);
			if (row != null) {
				int cols = row.getPhysicalNumberOfCells();
				returnedArray = new String[cols];
				HSSFCell cell;
				for (int c = 0; c < cols; c++) {
					cell = row.getCell((short) c);
					if (cell != null) {
						returnedArray[c] = cell.toString();
					}
				}
			}
			wb.close();
			return returnedArray;
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	// @Override
	// public List<String> getAllLines() {
	// ArrayList<String> returnedList = new ArrayList<String>();
	// StringBuilder sb;
	// try {
	// POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(this.filePath));
	// HSSFWorkbook wb = new HSSFWorkbook(fs);
	// HSSFSheet sheet = wb.getSheetAt(0);
	// HSSFRow row;
	// HSSFCell cell;
	//
	// int rows; // No of rows
	// rows = sheet.getPhysicalNumberOfRows();
	//
	// int cols = sheet.getRow(0).getPhysicalNumberOfCells();
	// // int tmp = 0;
	//
	// // This trick ensures that we get the data properly even if it doesn't start
	// // from first few rows
	// // for(int i = 0; i < 10 || i < rows; i++) {
	// // row = sheet.getRow(i);
	// // if(row != null) {
	// // tmp = sheet.getRow(i).getPhysicalNumberOfCells();
	// // if(tmp > cols) cols = tmp;
	// // }
	// // }
	// // Commence à 1 car la première ligne (index 0) est la ligne de titre
	// for (int r = 0; r < rows; r++) {
	// sb = new StringBuilder();
	// row = sheet.getRow(r);
	// if (row != null) {
	// for (int c = 0; c < cols; c++) {
	// cell = row.getCell((short) c);
	// // Ignore toute ligne qui ne contient pas le même nombre de colonnes (Par
	// // exemple: les totaux)
	// if (cell != null && cols == row.getPhysicalNumberOfCells()) {
	// sb.append("\"" + cell.toString() + "\"" + ((c < cols - 1) ?
	// this.getSeparator() : ""));
	// }
	// }
	// // System.out.println(sb.toString());
	// returnedList.add(sb.toString());
	// }
	// }
	// wb.close();
	// return returnedList;
	// } catch (Exception ioe) {
	// ioe.printStackTrace();
	// }
	// return null;
	// }

	/**
	 * Load the content of the XLS file. Set it in the fileVariable field
	 */
	@Override
	public void loadFile() {
		ArrayList<String[]> fileContent = new ArrayList<String[]>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(this.filePath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFCell cell;

			int rows; // No of rows
			rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			String[] returnedRow;
			HSSFRow row;
			returnedRow = new String[cols];
			for (int r = 0; r < rows; r++) {
				row = sheet.getRow(r);
				returnedRow = new String[cols];
				if (row != null) {
					for (int c = 0; c < cols; c++) {
						cell = row.getCell((short) c);
						// Ignore toute ligne qui ne contient pas le même nombre de colonnes (Par
						// exemple: les totaux)
						if (cell != null && cols == row.getPhysicalNumberOfCells()) {
							returnedRow[c] = cell.toString();
						}
					}
					fileContent.add(returnedRow);
				}
			}
			wb.close();
			this.fileContent = fileContent;
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}

	}

}
