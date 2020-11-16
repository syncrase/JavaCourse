package javaFundamentalsCorePlatform.appExecutionAndEnvironment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUse {

	private static final String PROP_FILE_2 = "properties/syntax.properties";
	private static final String ENV_NEW_PROPS = "properties/myProperties.txt";

	private static final String PROP_TEXT_FILE = "properties/xyz.properties";
	private static final String PROP_XML_FILE = "properties/props.xml";

	public static void main(String[] args) {
		storingProperties();
		loadingProperties();
	}

	/**
	 * Store properties into text file
	 */
	private static void storingProperties() {
		Properties props = new Properties();
		props.setProperty("displayName", "John snow");
		props.setProperty("accountNumber", "0215489562");

		try (Writer writer = Files.newBufferedWriter(Paths.get(PROP_TEXT_FILE))) {
			props.store(writer, "This is a comment");
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		try (OutputStream outputStream = Files.newOutputStream(Paths.get(PROP_XML_FILE))) {
			props.storeToXML(outputStream, "This is a comment");
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}

	/**
	 * Read properties from property file
	 */
	private static void loadingProperties() {
		Properties props = new Properties();

		if (Files.exists(Paths.get(PROP_FILE_2))) {
			try (Reader reader = Files.newBufferedReader(Paths.get(PROP_FILE_2))) {
				props.load(reader);
			} catch (IOException e) {
				System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
			}
			System.out.println(props.getProperty("val1"));
			System.out.println(props.getProperty("val2"));
			System.out.println(props.getProperty("val3"));
			System.out.println(props.getProperty("val4"));
		}

		System.out.println(System.getProperty("line.separator"));

		if (Files.exists(Paths.get(PROP_XML_FILE))) {
			try (InputStream inputStream = Files.newInputStream(Paths.get(PROP_XML_FILE))) {
				props.loadFromXML(inputStream);
			} catch (IOException e) {
				System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
			}
			System.out.println(props.getProperty("displayName"));
			System.out.println(props.getProperty("accountNumber"));
			int accountNumber = Integer.parseInt(props.getProperty("accountNumber"));
			props.setProperty("accountNumber", Integer.toString(accountNumber + 1));
			System.out.println(props.getProperty("accountNumber"));
		}

		System.out.println(System.getProperty("line.separator"));

		/*
		 * System properties :
		 * https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		 */
		try (FileInputStream propFile = new FileInputStream(ENV_NEW_PROPS)) {
			Properties p = new Properties(System.getProperties());
			p.load(propFile);
			System.setProperties(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.getenv().forEach((k, v) -> System.out.println(String.format("%-25s %s", k, v)));
		System.out.println(System.getProperty("COURSE_AUTHOR"));
	}

}
