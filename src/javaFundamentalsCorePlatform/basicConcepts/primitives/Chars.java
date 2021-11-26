package javaFundamentalsCorePlatform.basicConcepts.primitives;

public final class Chars {

	static void playWithChars() {
		displayTheAllChars();
		displayKnownCharacters();

	}

	private static void displayTheAllChars() {
		char lastValue = 0;
		for (char c = 0;; c++) {
			System.out.println(((int) c) + " : " + c);
			if ((int) c == 0 && (int) lastValue == 0 || (int) c == (int) lastValue + 1) {
				lastValue = c;
			} else {
				System.out.println("Je viens de passer la valeur max");

				System.out.println("\t- byte min = " + c + " (" + getBinaryRepresentation(c) + ")");
				System.out.println("\t- byte max = " + lastValue + " (" + getBinaryRepresentation(lastValue) + ")");
				System.out.println("Nombre de valeurs encodées : max - min + 1 (le 0!) = " + (lastValue - c + 1));
				break;
			}
		}
	}

	private static void displayKnownCharacters() {
		// Display the characters table
		for (long i = 33; i < 127; i++) {
			System.out.println(" |" + i + "\t|" + (char) i + "\t|");
		}
		System.out.println(" \t (...) ");
		for (long i = 161; i < 256; i++) {
			System.out.println(" |" + i + "\t|" + (char) i + "\t|");
		}
	}

	private static String getBinaryRepresentation(char c) {
		String stringRepresentation = Integer.toBinaryString(c & 0xFFFF);
		String heightCharsLength = String.format("%16s", stringRepresentation);
		return heightCharsLength.replace(' ', '0');
	}
}
