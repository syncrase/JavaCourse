package javaFundamentalsCorePlatform.appExecutionAndEnvironment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		propertiesExample();
//		storingPropertiesAsText();
//		loadingPropertiesAsText();
//		storingPropertiesAsXml();
//		loadingPropertiesAsXml();
//		defaultropertiesExample();
//		defaultropertiesFullExample();
//		systemPropertiesExample();
		environmentVariablesExample();
	}

	private static void propertiesExample() {
		Properties props = new Properties();
		props.setProperty("displayName", "John snow");
		System.out.println(props.getProperty("displayName"));
		System.out.println(props.getProperty("unexistingKey"));
		System.out.println(props.getProperty("prop1", "12"));

	}

	private static void storingPropertiesAsText() {
		Properties props = new Properties();
		props.setProperty("displayName", "John snow");
		props.setProperty("accountNumber", "0215489562");
//		System.out.println(props.getProperty("displayName"));

		try (Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))) {
			props.store(writer, "This is a comment");
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

	}

	private static void loadingPropertiesAsText() {
		Properties props = new Properties();

//		System.out.println(props.getProperty("displayName"));

		try (Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))) {
			props.load(reader);
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		System.out.println(props.getProperty("val1"));
		System.out.println(props.getProperty("val2"));
		System.out.println(props.getProperty("val3"));
		System.out.println(props.getProperty("val4"));

	}

	private static void storingPropertiesAsXml() {
		Properties props = new Properties();
		props.setProperty("displayName", "John snow");
		props.setProperty("accountNumber", "0215489562");
//		System.out.println(props.getProperty("displayName"));

		try (OutputStream outputStream = Files.newOutputStream(Paths.get("props.xml"))) {
			props.storeToXML(outputStream, "This is a comment");
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}

	}

	private static void loadingPropertiesAsXml() {
		Properties props = new Properties();

//		System.out.println(props.getProperty("displayName"));

		try (InputStream inputStream = Files.newInputStream(Paths.get("props.xml"))) {
			props.loadFromXML(inputStream);
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		System.out.println(props.getProperty("displayName"));
		System.out.println(props.getProperty("accountNumber"));

	}

	private static void defaultropertiesExample() {
		Properties defaults = new Properties();
		defaults.setProperty("position", "1");
		Properties props = new Properties(defaults);
		String nextProp = props.getProperty("position");
		System.out.println(nextProp);
		int iPos = Integer.parseInt(nextProp);

		props.setProperty("position", Integer.toString(++iPos));

		nextProp = props.getProperty("position");
		System.out.println(nextProp);

	}

	/**
	 * Common way to store the app state
	 */
	private static void defaultropertiesFullExample() {

		try {
			Properties defaultProps = new Properties();
			try (InputStream inputStream = PropertiesUse.class.getResourceAsStream("MyDefaultProperties.xml")) {
				defaultProps.loadFromXML(inputStream);

			}
			Properties userProps = new Properties(defaultProps);
			loadUserProps(userProps);

			String welcomeMessage = userProps.getProperty("welcomeMessage");
			String farewellMessage = userProps.getProperty("farewellMessage");

			System.out.println(welcomeMessage);
			System.out.println(farewellMessage);

			if (userProps.getProperty("isFirstRun").equals("y")) {
				userProps.setProperty("welcomeMessage", "welcome back");
				userProps.setProperty("farewellMessage", "Things will be familiar");
				userProps.setProperty("isFirstRun", "n");
				saveUserProps(userProps);
			}

		} catch (IOException e) {
			System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
		}

	}

	private static Properties loadUserProps(Properties userProps) throws IOException {
		Path userPath = Paths.get("userValues.xml");

		if (Files.exists(userPath)) {
			try (InputStream inputStream = Files.newInputStream(userPath)) {
				userProps.loadFromXML(inputStream);
			}
		}

		return userProps;

	}

	private static void saveUserProps(Properties userProps) throws IOException {
		try (OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))) {
			userProps.storeToXML(outputStream, null);
		}

	}

	/**
	 * Commonly used system properties
	 * https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
	 * 
	 */
	private static void systemPropertiesExample() {
		System.out.println("file.separator: " + System.getProperty("file.separator"));
		System.out.println("java.class.path: " + System.getProperty("java.class.path"));
		System.out.println("java.home: " + System.getProperty("java.home"));
		System.out.println("java.vendor: " + System.getProperty("java.vendor"));
		System.out.println("java.vendor.url: " + System.getProperty("java.vendor.url"));
		System.out.println("java.version: " + System.getProperty("java.version"));
		System.out.println("line.separator: " + System.getProperty("line.separator"));
		System.out.println("os.arch: " + System.getProperty("os.arch"));
		System.out.println("os.name: " + System.getProperty("os.name"));
		System.out.println("os.version: " + System.getProperty("os.version"));
		System.out.println("path.separator: " + System.getProperty("path.separator"));
		System.out.println("user.dir: " + System.getProperty("user.dir"));
		System.out.println("user.home: " + System.getProperty("user.home"));
		System.out.println("user.name: " + System.getProperty("user.name"));
	}

	private static void environmentVariablesExample() {
		System.getenv().forEach((k, v) -> System.out.println(String.format("%-25s %s", k, v)));
		// Will return null if the variable wasn't set before the java command. This
		// another way to pass information to the java program
		System.out.println(System.getenv("COURSE_AUTHOR"));

	}

}
