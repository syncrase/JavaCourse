package javaFundamentalsCorePlatform.basicConcepts.primitives;

import java.math.BigInteger;

public class Ints {

	public static void playWithInts() {
//		System.out.println("int > 32-bit signed two's complement integer");
		System.out.println("(int) 2^31 - 2 -> " + (int) (Math.pow(2, 31) - 2));// 2147483646
		System.out.println("(int) 2^31 - 1 -> " + (int) (Math.pow(2, 31) - 1));// 2147483647
		System.out.println("(int) 2^31 -> " + (int) Math.pow(2, 31));// 2147483647 /!\

		int lastValue = -1;
		for (int i = 0; true; i++) {
			if (i > -1) {
				lastValue = i;
			} else {
				System.out.println("Je viens de passer la valeur max");

				System.out.println("\t- int min = " + i + " (" + getBinaryRepresentation(i) + ")");
				System.out.println("\t- int max = " + lastValue + " (" + getBinaryRepresentation(lastValue) + ")");
				// !\\ Le println utilise int pour afficher les valeurs
				// => au dessus de la valeur max se trouve la valeur min
				// Etant donné que maxVal + 1 = minVal
				// => maxVal - minVal
				// = maxVal - (minVal - 1 + 1)
				// = maxVal + 1 - minVal - 1
				// = minVal - minVal - 1
				// = - 1
				System.out.println("Nombre de valeurs encodées : max - min + 1 = " + (lastValue - i + 1));// 0
				System.out.println("Nombre de valeurs encodées : max - min = " + (lastValue - i));// -1

				// Pour exprimer le nombre de valeurs possibles pour int.
				// => on ne peut pas passer par int.
				// Le nombre de valeurs possible et 2 fois + 1 supérieur au nombre exprimable
				// par int
				// Donc BigInteger
				BigInteger lastBig = BigInteger.valueOf(lastValue);
				BigInteger current = BigInteger.valueOf(i);

				System.out.println("Nombre de valeurs encodées : max - min + 1 (le 0!) = "
						+ lastBig.subtract(current).add(BigInteger.ONE));// 0 car 1111...1111 = 0!
				break;
			}
		}

	}

	private static String getBinaryRepresentation(int b) {
		String stringRepresentation = Integer.toBinaryString(b & 0xFFFFFFFF);
		String heightCharsLength = String.format("%32s", stringRepresentation);
		return heightCharsLength.replace(' ', '0');
	}
}
