package javaFundamentalsCorePlatform.stringsAndRegex;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO https://www.geeksforgeeks.org/strings-in-java/
 * https://www.baeldung.com/java-string
 * 
 * @author syncrase
 *
 */
public class Strings {

	/**
	 * Detailed format specifier information http://bit.ly/java8formatter ---------
	 * Flags:
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		stringJoinerExample();
//		stringFormattingExample();
//		try {
//			doWrite();
//		} catch (IOException e) {
//			System.out.println(e.getClass().getSimpleName() + " --> " + e.getMessage());
//		}
//		regexExample();
//		patternAndMatcherExample();
	}

	private static void stringJoinerExample() {
		StringJoiner sj = new StringJoiner(", ");
		sj.add("alpha");
		sj.add("beta").add("gamma");
		String sResult = sj.toString();
		System.out.println(sResult);

		StringJoiner sj2 = new StringJoiner(", ", "{", "}");
		sj2.add("alpha").add("beta").add("gamma");
		String sResult2 = sj2.toString();
		System.out.println(sResult2);

		StringJoiner sj3 = new StringJoiner("], [", "[", "]");
		sj3.add("alpha").add("beta").add("gamma");
		String sResult3 = sj3.toString();
		System.out.println(sResult3);

		System.out.println("Empty value configuration");
		StringJoiner sj4 = new StringJoiner(", ", "{", "}");
		String sResult4 = sj4.toString();
		System.out.println("empty string: " + sResult4);
		sj4.setEmptyValue("EMPTY");
		sResult4 = sj4.toString();
		System.out.println("empty string with configured empty value: " + sResult4);
		sj4.add("");
		sResult4 = sj4.toString();
		System.out.println("empty string added: " + sResult4);
	}

	private static void stringBuilderExample() {
		// TODO utilisation du StringBuilder
	}

	private static void stringBufferExample() {
		// TODO utilisation du StringBuffer
	}

	private static void concatenationExample() {
		// TODO concaténer une String
	}

	/**
	 * see for;qt specifier
	 * http://java2s.com/Tutorials/Java/Data_Format/Java_Format_Specifier.htm
	 * 
	 * %[argument index][flags][width][precision]conversion
	 */
	private static void stringFormattingExample() {
		int charles = 33, pierre = 30, yasmina = 28, marie = 26;
		String sFormatted = String.format("These persons are %d, %d, %d and %d years old", pierre, charles, marie,
				yasmina);
		System.out.println(sFormatted);
		double avgDiff = (charles - pierre) + (pierre - yasmina) + (yasmina - marie) / 3.0d;
		// % means "format specifier start" .1 means "the precision" f|d|... means
		// "conversion"
		//
		System.out.println(String.format("Average difference = %.1f", avgDiff));

		int val = 32;
		System.out.println("All the following values represent " + val);
		System.out.println(String.format("Decimal integer %d", val));
		System.out.println(String.format("Octal integer %o", val));
		System.out.println(String.format("Integer hexadecimal %x", val));
//		System.out.println(String.format("%#d", 32));
		// Flags # = include radix; 0 = zero padding; - = left justify
		System.out.println(String.format("Flagged Octal integer %#o", val));
		System.out.println(String.format("Flagged Integer hexadecimal # flagged %#x", val));
		System.out.println(String.format("Flagged Integer hexadecimal 08 flagged %08x", val));
		System.out.println(String.format("Flagged Integer hexadecimal 6 flagged %6x", val));
		System.out.println(String.format("Flagged Decimal integer 8 flagged %8d", val));
		System.out.println(String.format("Flagged Decimal integer 08 flagged %08d", val));

		System.out.println(String.format("Flagged Decimal integer -12 flagged %-12d %d", val, val));

		// Comma flag
		System.out.println(String.format("%d", 123456789));
		System.out.println(String.format("%,d", 123456789));
		System.out.println(String.format("%,.2f", 123456789.0));

		// Space flag
		System.out.println(String.format("% d", 123456789));
		System.out.println(String.format("% d", -123456789));

		// Plus flag
		System.out.println(String.format("%+d", 123456789));
		System.out.println(String.format("%+d", -123456789));

		// Parenthese flag
		System.out.println(String.format("%(d", 123456789));
		System.out.println(String.format("%(d", -123456789));

		// Arguments index
		System.out.println("argument index");
		System.out.println(String.format("%d %d %d", 100, 200, 300));
		System.out.println(String.format("%3$d %1$d %2$d", 100, 200, 300));
		System.out.println(String.format("%2$d %<04d %1$d", 100, 200, 300));

//		System.out.println(String.format("Flagged Integer hexadecimal %-x", val));
	}

	private static void doWrite() throws IOException {
		int charles = 33, pierre = 30, yasmina = 28, marie = 26;
		double avgDiff = (charles - pierre) + (pierre - yasmina) + (yasmina - marie) / 3.0d;

		BufferedWriter writer = Files.newBufferedWriter(Paths.get("resources/formattedContentToStream.txt"));
		try (Formatter f = new Formatter(writer)) {
			f.format("These persons are %d, %d, %d and %d years old", pierre, charles, marie, yasmina);
			f.format("Average difference = %.1f", avgDiff);
		}
	}

	/**
	 * 3 main methods: _____________________________________________________
	 * replaceFirst or all: pattern identified which part to change__________,
	 * split: pattern identified separator ____________________________________
	 * match: pattern identified the matched string
	 */
	private static void regexExample() {
		String testString = "apple, apple and orange please";

		String s2 = testString.replaceAll("ple", "ricot");
		System.out.println(s2);
		// \\b word break
		String s3 = testString.replaceAll("ple\\b", "ricot");
		System.out.println(s3);

		String[] parts = testString.split("\\b");
		System.out.println(Arrays.asList(parts));
		for (String s : parts) {
			if (s.matches("\\w+")) {
				System.out.print(s);

			}
		}

	}

	/**
	 * more on pattern http://bit.ly/java8pattern ___________________________
	 * tutorial http://bit.ly/javaregextutorial _____________________________ test
	 * regex online https://regex101.com
	 */
	private static void patternAndMatcherExample() {
		String testString = "apple, apple and orange please";

		Pattern entireWord = Pattern.compile("\\w+");
		Matcher entireWordFound = entireWord.matcher(testString);

		while (entireWordFound.find()) {
			System.out.println(entireWordFound.group());
		}
	}

}
