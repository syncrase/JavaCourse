package javaFundamentalsCorePlatform.basicConcepts.objectOriented.markerInterface;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Serializer {

	private String folder;
	private String filename;
	private Path file;

	public Serializer(String folder, String filename) {
		super();
		this.folder = folder;
		this.filename = filename;
		updateFile();
	}

	public void updateFile() {
		file = FileSystems.getDefault().getPath(folder, filename);
	}

	public void serialize(MultiMarkedClass acct) {

		try {
			Files.createDirectories(file.getParent());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(file))) {
			objectStream.writeObject(acct);

		} catch (IOException e) {

		}
	}

	public MultiMarkedClass deserialize() {
		MultiMarkedClass acct = null;
		try (ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(file))) {
			acct = (MultiMarkedClass) objectStream.readObject();

		} catch (IOException | ClassNotFoundException e) {

		}
		return acct;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
