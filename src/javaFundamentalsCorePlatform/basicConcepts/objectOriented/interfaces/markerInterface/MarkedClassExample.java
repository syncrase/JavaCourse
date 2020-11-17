package javaFundamentalsCorePlatform.basicConcepts.objectOriented.interfaces.markerInterface;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkedClassExample {

	Serializer s;

	public static void main(String[] args) {

		MarkedClassExample.Serializer serializer = new MarkedClassExample.Serializer("serialized/", "account.dat");

		// Test the serializability
		MultiMarkedClass multiMarked = new MultiMarkedClass(123456, "strin");
		multiMarked.publicTransientInt = 2;

		serializer.serialize(multiMarked);
		multiMarked = serializer.deserialize();

		System.out.println(multiMarked.j + " : " + multiMarked.s + " : " + multiMarked.publicTransientInt);

		// Test the clonability
		try {
			MultiMarkedClass multiMarked2 = (MultiMarkedClass) multiMarked.clone();
			System.out.println("Two different object ? " + (multiMarked2 != multiMarked));
			System.out.println("Values are equals ? " + multiMarked2.equals(multiMarked));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * There's no core implementation to serialize, we must do it ourself with
	 * ObjectOutputStream and ObjectInputStream
	 * 
	 * @author syncrase
	 *
	 */
	private static class Serializer {

		private Path file;

		public Serializer(String folder, String filename) {
			file = FileSystems.getDefault().getPath(folder, filename);
		}

		public void serialize(MultiMarkedClass acct) {

			try {
				Files.createDirectories(file.getParent());
			} catch (IOException e1) {
				System.out.println(e1.getLocalizedMessage());
			}

			try (ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(file))) {
				objectStream.writeObject(acct);

			} catch (NotSerializableException e) {
				System.out.println("Cette classe n'est pas serializable");
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}

		public MultiMarkedClass deserialize() {
			MultiMarkedClass acct = null;
			try (ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(file))) {
				acct = (MultiMarkedClass) objectStream.readObject();
				return acct;
			} catch (NotSerializableException e) {
				System.out.println("Cette classe n'est pas serializable");
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
			return null;
		}

	}

}
