package javaFundamentalsCorePlatform.basicConcepts.primitives;

public class Shorts {

	public static void playWithShorts() {
//		System.out.println("short > 16-bit signed two's complement integer");
		System.out.println("(short) 32767 -> " + (short) 32767);
		System.out.println("(short) 32768 -> " + (short) 32768);// -32768

		short lastValue = -1;
		for (short s = 0; true; s++) {
			if (s > -1) {
				lastValue = s;
			} else {
				System.out.println("Je viens de passer la valeur max");

				System.out.println("\t- short min = " + s + " (" + getBinaryRepresentation(s) + ")");
				System.out.println("\t- short max = " + lastValue + " (" + getBinaryRepresentation(lastValue) + ")");
				System.out.println("Nombre de valeurs encodées : max - min + 1 (le 0!) = " + (lastValue - s + 1));
				break;
			}
		}

	}

	private static String getBinaryRepresentation(short b) {
		String stringRepresentation = Integer.toBinaryString(b & 0xFFFF);
		String heightCharsLength = String.format("%16s", stringRepresentation);
		return heightCharsLength.replace(' ', '0');
	}

}
