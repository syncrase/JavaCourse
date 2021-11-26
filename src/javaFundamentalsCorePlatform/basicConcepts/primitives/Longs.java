package javaFundamentalsCorePlatform.basicConcepts.primitives;

import java.math.BigInteger;

public class Longs {

	public static void playWithLongs() {
//		System.out.println("long > 64-bit two's complement integer");
		// TODO
//		System.out.println("(long) 2^63 - 2 -> " + (long) (Math.pow(2, 62) - 2d)); // le math.pow ne fonctionne pas avec
//																					// la soustraction
//		System.out.println("(long) 2^63 - 1 -> " + (long) (Math.pow(2, 62) - 1d));
//		System.out.println("(long) 2^62 -> " + (long) Math.pow(2, 62));//
//		System.out.println("(long) 2^63 -> " + (long) Math.pow(2, 63));//
//		System.out.println("(long) 2^64 -> " + (long) Math.pow(2, 64));//
//		System.out.println("((long) 2^64) + 1 -> " + (((long) Math.pow(2, 64)) + 1));//
//
//		System.out.println("(long) 9223372036854775806L -> " + (long) 9223372036854775806L);//
//		System.out.println("(long) 9223372036854775807L -> " + (long) 9223372036854775807L);//
//		System.out.println("(long) 9223372036854775807L+1 -> " + ((long) 9223372036854775807L + 1));//

		// Display 2 pow
//		for (int i = 31; i > 0; i--) {
//			System.out.println("<td>" + (long) (Math.pow(2, i)) + "</td>");
//		}
		long lastValue = -1;
		// 64 bit = 1.8446744e+19 -1
		// pas possible de commance la boucle à 1e+19 car un int est considéré
		for (long l = 0; true; l++) {
			System.out.println(l);
			if (l == 0 && lastValue == 0 || l == lastValue + 1) {
				lastValue = l;
			} else {
				System.out.println("Je viens de passer la valeur max");

				System.out.println("\t- long min = " + l + " (" + getBinaryRepresentation(l) + ")");
				System.out.println("\t- long max = " + lastValue + " (" + getBinaryRepresentation(lastValue) + ")");
				// !\\ Le println utilise int pour afficher les valeurs
				// => au dessus de la valeur max se trouve la valeur min
				// Etant donné que maxVal + 1 = minVal
				// => maxVal - minVal
				// = maxVal - (minVal - 1 + 1)
				// = maxVal + 1 - minVal - 1
				// = minVal - minVal - 1
				// = - 1
				System.out.println("Nombre de valeurs encodées : max - min + 1 = " + (lastValue - l + 1));// 0
				System.out.println("Nombre de valeurs encodées : max - min = " + (lastValue - l));// -1

				// Pour exprimer le nombre de valeurs possibles pour int.
				// => on ne peut pas passer par int.
				// Le nombre de valeurs possible et 2 fois + 1 supérieur au nombre exprimable
				// par int
				// Donc BigInteger
				BigInteger lastBig = BigInteger.valueOf(lastValue);
				BigInteger current = BigInteger.valueOf(l);

				System.out.println("Nombre de valeurs encodées : max - min + 1 (le 0!) = "
						+ lastBig.subtract(current).add(BigInteger.ONE));// 0 car 1111...1111 = 0!
				break;
			}
		}

	}

	private static String getBinaryRepresentation(long b) {
		// Pas possible d'uiliser toBinaryString
		// & 0xFFFFFFFFFFFFFFFF pas possible => utilise int
		String stringRepresentation = Long.toBinaryString(b);
//		String stringRepresentation = Integer.toBinaryString(b & 0xFFFFFFFFFFFFFFFF);
		String heightCharsLength = String.format("%64s", stringRepresentation);
		return heightCharsLength.replace(' ', '0');
	}
}
