package javaFundamentalsCorePlatform.basicConcepts.primitives;

public class Bytes {

	public static void playWithBytes() {
		System.out.println("(byte) 127 -> " + (byte) 127);
		System.out.println("(byte) 128 -> " + (byte) 128);// -128
		System.out.println("(byte) -128 -> " + (byte) -128);// -128
		System.out.println("(byte) 256 -> " + (byte) 256);// 0

		byte lastValue = -1;
		for (byte b = 0; true; b++) {
			if (b > -1) {
				lastValue = b;
			} else {
				System.out.println("Je viens de passer la valeur max");

				System.out.println("\t- byte min = " + b + " (" + getBinaryRepresentation(b) + ")");
				System.out.println("\t- byte max = " + lastValue + " (" + getBinaryRepresentation(lastValue) + ")");
				System.out.println("Nombre de valeurs encodées : max - min + 1 (le 0!) = " + (lastValue - b + 1));
				break;
			}
		}
	}

	private static String getBinaryRepresentation(byte b) {
		String stringRepresentation = Integer.toBinaryString(b & 0xFF);
		String heightCharsLength = String.format("%8s", stringRepresentation);
		return heightCharsLength.replace(' ', '0');
	}

}
