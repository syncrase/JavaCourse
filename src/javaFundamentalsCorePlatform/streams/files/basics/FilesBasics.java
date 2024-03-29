package javaFundamentalsCorePlatform.streams.files.basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public abstract class FilesBasics {

	protected String getLinesAsString(List<String> readAllLines, String eol, int endLine) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (String line : readAllLines) {
			sb.append(line + eol);
			if (count == endLine)
				return sb.toString();
		}
		return sb.toString();
	}

	/**
	 * @param filePath Path of the file
	 * @param params   eol other than the default "\n"
	 * @return Returns the full text contained in the file
	 */
	public String getContentAsString(String filePath, String... params) {
		String eol = params.length > 0 ? params[0] : "\n";
		try {
			List<String> readAllLines = Files.readAllLines(Paths.get(filePath));
			return this.getLinesAsString(readAllLines, eol, readAllLines.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param filePath The relative filepath from which the line is extracted
	 * @return The first line of the file as a String
	 */
	public String getFirstLineAsString(String filePath) {
		try {
			List<String> readAllLines = Files.readAllLines(Paths.get(filePath));
			return this.getLinesAsString(readAllLines, "", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getAllLines(String filePath) {
		try {
			List<String> readAllLines = Files.readAllLines(Paths.get(filePath));
			return readAllLines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void walkThrough(Path pathSource, Path pathArchive) throws IOException {
		Stream<Path> walk = Files.walk(pathSource);
		walk.sorted(Comparator.reverseOrder()).filter(f -> !f.equals(pathSource)).forEach(path -> {
			try {
				pathArchive.resolve(pathSource.relativize(path));
				Files.copy(path, pathArchive.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
//                log.error("Archivage de fichier {} echoué", path);
			}
		});

		walk.close();

	}
}
