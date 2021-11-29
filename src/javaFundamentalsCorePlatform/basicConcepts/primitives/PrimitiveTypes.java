package javaFundamentalsCorePlatform.basicConcepts.primitives;

public class PrimitiveTypes {

	public static void main(String[] args) {

		// Display the characters table
		for (long i = 33; i < 127; i++) {
			System.out.println(" |" + i + "\t|" + (char) i + "\t|");
		}
		System.out.println(" \t (...) ");
		for (long i = 161; i < 256; i++) {
			System.out.println(" |" + i + "\t|" + (char) i + "\t|");
		}

//		byte	0		8-bit signed two's complement integer
//		short	0		16-bit signed two's complement integer
//		int	0			32-bit signed two's complement integer
//		long	0L		64-bit two's complement integer
//		float	0.0f	single-precision 32-bit IEEE 754 floating point
//		double	0.0d
//		char	'\u0000'
//		System.out.println("byte > 8-bit signed two's complement integer");
		System.out.println("(byte) 127 -> " + (byte) 127);
		System.out.println("(byte) 128 -> " + (byte) 128);// -128

//		System.out.println("short > 16-bit signed two's complement integer");
		System.out.println("(short) 32767 -> " + (short) 32767);
		System.out.println("(short) 32768 -> " + (short) 32768);// -32768

//		System.out.println("int > 32-bit signed two's complement integer");
		System.out.println("(int) 2^31 - 2 -> " + (int) (Math.pow(2, 31) - 2));// 2147483646
		System.out.println("(int) 2^31 - 1 -> " + (int) (Math.pow(2, 31) - 1));// 2147483647
		System.out.println("(int) 2^31 -> " + (int) Math.pow(2, 31));// 2147483647 /!\

//		System.out.println("long > 64-bit two's complement integer");
		// TODO
		System.out.println("(long) 2^63 - 2 -> " + (long) (Math.pow(2, 62) - 2d)); // le math.pow ne fonctionne pas avec
																					// la soustraction
		System.out.println("(long) 2^63 - 1 -> " + (long) (Math.pow(2, 62) - 1d));
		System.out.println("(long) 2^63 -> " + (long) Math.pow(2, 62));//
		
		System.out.println("(long) 9223372036854775806L -> " + (long) 9223372036854775806L);//
		System.out.println("(long) 9223372036854775807L -> " + (long) 9223372036854775807L);//

//		System.out.println("float > single-precision 32-bit IEEE 754 floating point");
//		System.out.println("(float) 2^31 - 1 -> " + (float) (Math.pow(2, 31) - 1));
//		System.out.println("(float) 2^31 -> " + (float) Math.pow(2, 31));// -32768

//		System.out.println("double > ");
//		System.out.println("(double) 2^31 - 1 -> " + (double) (Math.pow(2, 31) - 1));
//		System.out.println("(double) 2^31 -> " + (double) Math.pow(2, 31));// -32768

//		System.out.println("char > ");
//		System.out.println("(char) 2^31 - 1 -> " + (char) (Math.pow(2, 31) - 1));
//		System.out.println("(char) 2^31 -> " + (char) Math.pow(2, 31));// -32768
	}
}
