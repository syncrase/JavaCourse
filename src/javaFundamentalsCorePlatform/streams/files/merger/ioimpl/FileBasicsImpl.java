package javaFundamentalsCorePlatform.streams.files.merger.ioimpl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javaFundamentalsCorePlatform.streams.files.basics.FilesBasics;

public class FileBasicsImpl extends FilesBasics {

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public String getFullText(String filePath) {
		String fileContent = "";
		fileContent = this.getContentAsString(filePath, "\n");
		return fileContent;
	}

	@Override
	public List<String> getAllLines(String filePath) {
		List<String> readAllLines = super.getAllLines(filePath);

		// Vérifie que la ligne n'est pas coupée à cause du caractère '/' et sioui,
		// reconstitu
		// Spécifique au format d'export de Kezia II
		List<String> readAllLines2 = new ArrayList<String>();
		String tampon = "";
		for (String s : readAllLines) {
			tampon += s;
			if (tampon.charAt(tampon.length() - 2) != '/') {
				readAllLines2.add(tampon);
				tampon = "";
			}

		}
		return readAllLines2;
	}

	/**
	 * @param string
	 * 
	 */
	public void write(String filePath, String content) {
		Path path = FileSystems.getDefault().getPath(filePath);
		Charset charset = Charset.forName("UTF-8");
		// The BufferedWriter use requires to set the project compliance to 1.7
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write(content, 0, content.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
