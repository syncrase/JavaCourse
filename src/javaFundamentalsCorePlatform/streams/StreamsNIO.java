package javaFundamentalsCorePlatform.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamsNIO {

	public static void main(String[] args) {

		String[] data = { "line 1", "line 2", "line 3", "line 4", "line 5" };

		try (FileSystem zipFs = openZip(Paths.get("resources\\zipFile.zip"))) {
			copyToZip(zipFs);
			writeToFileInZip1(zipFs, data);

			writeToFileInZip2(zipFs, data);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
		}

	}

	public void readData() throws IOException {
		// Deprecated way
		try (BufferedReader br = Files.newBufferedReader(Paths.get("resources\\file1.txt"))) {
			String inValue;
			while ((inValue = br.readLine()) != null) {
				System.out.println(inValue);
			}
		}

		// New way
		// Other way to get file => Paths.get("resources", "file1.txt");
		List<String> lines = Files.readAllLines(Paths.get("resources\\file1.txt"));
		for (String line : lines) {
			System.out.println(line);
		}
	}

	/**
	 * Open a zip file or create this if it doesn't exist
	 * 
	 * @param zipPath
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	private static FileSystem openZip(Path zipPath) throws URISyntaxException, IOException {
		Map<String, String> providerProp = new HashMap<>();
		providerProp.put("create", "true");
		URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
		FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProp);

		return zipFs;

	}

	private static void copyToZip(FileSystem ZipFs) throws IOException {
		Path sourceFile = Paths.get("resources\\file1.txt");
		// Path sourceFile = FileSystems.getDefault().getPath("resources\\file1.txt");
		Path destFile = ZipFs.getPath("file_copy.txt");
		Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);

	}

	/**
	 * Traditionnal way to add content to the file or create a new file if it doesn't exist yet
	 * 
	 * @param zipFs
	 * @param data
	 * @throws IOException
	 */
	private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
		try (BufferedWriter bw = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {
			// , Charset.defaultCharset(), StandardOpenOption.CREATE
			for (String s : data) {
				bw.write(s);
				bw.newLine();
			}
		} catch (IOException e) {
			try (BufferedWriter bw = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"), Charset.defaultCharset(),
					StandardOpenOption.APPEND)) {
				for (String s : data) {
					bw.write(s);
					bw.newLine();
				}
			}
		}
	}

	
	/**
	 * New way
	 * @param zipFs
	 * @param data
	 * @throws IOException
	 */
	private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
		try{
			Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(),
					StandardOpenOption.APPEND);
		}catch(IOException e) {
					Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(),
							StandardOpenOption.CREATE);
				}
	}

}
