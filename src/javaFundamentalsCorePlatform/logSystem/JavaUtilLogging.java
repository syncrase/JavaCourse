package javaFundamentalsCorePlatform.logSystem;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaUtilLogging {
	
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Logger logger1 = Logger.getLogger("javaFundamentalsCorePlatform.logSystem");

	public static void main(String[] args) {
//		basicLogImpl();
//		staticLoggerImpl();
//		changeLevelImpl();
//		doWork("string 1", "string 2");
//		logComponentsImpl();
//		fileSubstitionValuesImpl();
		simpleFormatter();
	}

	/**
	 * DOESN'T WORK. I HAVE TWO OF MESSAGE
	 */
	private static void changeLevelImpl() {
//		logLevelsImpl();
		System.out.println("Change log level to FINEST");
		// ******************************************************************************
		// ******************************************************************************
		// Remove current handlers
		logger1.setLevel(Level.FINEST);
//		Arrays.asList(logger.getHandlers()).forEach(handlerSet -> logger.removeHandler(handlerSet));
		// cf.
		// https://stackoverflow.com/questions/6315699/why-are-the-level-fine-logging-messages-not-showing
		// Add new handler with desired level
		ConsoleHandler handler = new ConsoleHandler();
		// PUBLISH this level
		handler.setLevel(Level.FINEST);
		logger1.addHandler(handler);
		// ******************************************************************************
		// ******************************************************************************
		allLogLevelsImpl();

//		

		// ******************************************************************************
		// ******************************************************************************

	}

	private static void basicLogImpl() {
		LogManager lm = LogManager.getLogManager();
		Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.INFO, "info message");
		logger.log(Level.INFO, "another message");
	}

	/**
	 * OFF________________MAX______Logger capture nothing
	 * SEVERE____________1000______Serious failure
	 * WARNING____________900______Potential problem
	 * WARNING____________800______General info
	 * CONFIG_____________700______Configuration info
	 * FINE_______________500______General developper info
	 * FINER______________400______Detail developper info
	 * FINEST_____________300______Specialized developper info
	 * ALL________________Min______Logger capture everything
	 */
	private static void allLogLevelsImpl() {

		logger.entering("javaFundamentalsCorePlatform.logSystem.JavaUtilLogging", "logLevelsImpl");

		logger.log(Level.SEVERE, "SEVERE message");
		logger.severe("SEVERE message");

		logger.log(Level.WARNING, "WARNING message");
		logger.warning("WARNING message");

		logger.log(Level.INFO, "INFO message");
		logger.info("INFO message");

		logger.log(Level.CONFIG, "CONFIG message");
		logger.config("CONFIG message");

		logger.log(Level.FINE, "FINE message");
		logger.fine("FINE message");

		logger.log(Level.FINER, "FINER message");
		logger.finer("FINER message");

		logger.log(Level.FINEST, "FINEST message");
		logger.finest("FINEST message");

		logger.logp(Level.SEVERE, "javaFundamentalsCorePlatform.logSystem.JavaUtilLogging", "logLevelsImpl",
				"SEVERE message");

		logger.exiting("javaFundamentalsCorePlatform.logSystem.JavaUtilLogging", "logLevelsImpl");

		// Parameterized log message
		logger.log(Level.INFO, "INFO {0} message", "slf4j");
		logger.log(Level.INFO, "INFO Aujourd'hui nous sommes le {0} - {1} - {2}",
				new Object[] { "samedi", "22", "décembre" });
	}

	private static void doWork(String s1, String s2) {
		logger.entering("javaFundamentalsCorePlatform.logSystem.JavaUtilLogging", "doWork", new Object[] { s1, s2 });
		String stringResult = "<" + s1 + " " + s2 + ">";
		logger.exiting("javaFundamentalsCorePlatform.logSystem.JavaUtilLogging", "doWork", stringResult);
	}

	private static void logComponentsImpl() {
		Handler h = new ConsoleHandler();
		Formatter f = new SimpleFormatter();
		h.setFormatter(f);
		logger.addHandler(h);
		logger.setLevel(Level.FINEST);
		logger.log(Level.FINEST, "Test finest log");

	}

	/**
	 * slash ________________________________________________________ Platform slash
	 * %t ___________________________________________________________ temp directory
	 * %h ____________________________________________________ User's home directory
	 * %g __________________________________________________ Rotatinf log generation
	 * 
	 */
	private static void fileSubstitionValuesImpl() {

		//BUILT-IN Handler example
		try {
			// rotating set of 4 files about 1000 bytes
			FileHandler fh = new FileHandler(System.getProperty("user.dir") + "/myapp_%g.log", 1000, 4);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * DOESN'T LOAD THE LOG.PROPERTIES INDICATES IN RUN CONFIGURATION
	 */
	private static void simpleFormatter() {
		
		
		logger1.log(Level.INFO, "Hi there");
//		String.format("%1$tb %1$tb, %1$tY %1$tl:%1$tL:%1$tTp %2$s %n %4$s: %5$s%6$s%n", data, source, logger, level, message, thrown);
	}
}
