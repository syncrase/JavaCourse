package javaFundamentalsCorePlatform.basicConcepts.primitives;

/**
 * <br>
 * <h1>Rappel du calcul binaire</h1>
 * <h2>Les valeurs des puissances de 2</h2>
 * <table border='1' style='isplay:table-header-group;'>
 * <thead>
 * <tr>
 * <th>...</th>
 * <th>2³¹</th>
 * <th>2³⁰</th>
 * <th>2²⁹</th>
 * <th>2²⁸</th>
 * <th>2²⁷</th>
 * <th>2²⁶</th>
 * <th>2²⁵</th>
 * <th>2²⁴</th>
 * <th>2²³</th>
 * <th>2²²</th>
 * <th>2²¹</th>
 * <th>2²⁰</th>
 * <th>2¹⁹</th>
 * <th>2¹⁸</th>
 * <th>2¹⁷</th>
 * <th>2¹⁶</th>
 * <th>2¹⁵</th>
 * <th>2¹⁴</th>
 * <th>2¹³</th>
 * <th>2¹²</th>
 * <th>2¹¹</th>
 * <th>2¹⁰</th>
 * <th>2⁹</th>
 * <th>2⁸</th>
 * <th>2⁷</th>
 * <th>2⁶</th>
 * <th>2⁵</th>
 * <th>2⁴</th>
 * <th>2³</th>
 * <th>2²</th>
 * <th>2¹</th>
 * <th>2⁰</th>
 * </tr>
 * </thead> <tbody>
 * <th>...</th>
 * <td>2147483648</td>
 * <td>1073741824</td>
 * <td>536870912</td>
 * <td>268435456</td>
 * <td>134217728</td>
 * <td>67108864</td>
 * <td>33554432</td>
 * <td>16777216</td>
 * <td>8388608</td>
 * <td>4194304</td>
 * <td>2097152</td>
 * <td>1048576</td>
 * <td>524288</td>
 * <td>262144</td>
 * <td>131072</td>
 * <td>65536</td>
 * <td>32768</td>
 * <td>16384</td>
 * <td>8192</td>
 * <td>4096</td>
 * <td>2048</td>
 * <td>1024</td>
 * <td>512</td>
 * <td>256</td>
 * <td>128</td>
 * <td>64</td>
 * <td>32</td>
 * <td>16</td>
 * <td>8</td>
 * <td>4</td>
 * <td>2</td>
 * <td>1</td>
 * </tr>
 * </tbody>
 * </table>
 * 8 bit permettent de coder 2⁹-1 = 511 valeurs. Résulte l'interval [0 ;
 * 511].<br>
 * Pour rappel, 1 octet = 1 byte = 8 bit<br>
 * <h2>Rappel du complément à 2</h2> <br>
 * Prenons comme base un octet (8 bit) signé => <br>
 * <ul>
 * <li>le signe est porté par le bit de poid le plus lourd.</li>
 * <li>les valeurs sont donc codées sur 7 bit. Valeur max = 64 + 32 + ... + 1 =
 * 127</li>
 * <li>Il en résulte l'interval [-128 ; 127] dans lequel est codé 256
 * valeurs</li>
 * <li>Donc 01111111 (127) + 1 = 10000000 (-128)</li>
 * <li>Donc 11111111 (256) = 00000000</li>
 * </ul>
 * <br>
 * <br>
 * <h1>Il existe 8 types primitif en Java</h1>
 * 
 * <table border='1'>
 * <thead>
 * <tr>
 * <th>Mot-clé</th>
 * <th>Syntaxe</th>
 * <th>Represent</th>
 * <th>Memory</th>
 * <th>Signed</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td>boolean</td>
 * <td>true or false</td>
 * <td>Boolean</td>
 * <td>1 bit</td>
 * <td>no</td>
 * </tr>
 * <tr>
 * <td>byte</td>
 * <td>0</td>
 * <td>Byte</td>
 * <td>1 octet (8 bit)</td>
 * <td>yes</td>
 * </tr>
 * <tr>
 * <td>short</td>
 * <td>0</td>
 * <td>Short integer</td>
 * <td>2 octets (16 bit)</td>
 * <td>yes</td>
 * </tr>
 * <tr>
 * <td>char</td>
 * <td>'\u0000'</td>
 * <td>Character</td>
 * <td>2 octets (16 bit)</td>
 * <td>no</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>0</td>
 * <td>Integer</td>
 * <td>4 octets (32 bit)</td>
 * <td>yes</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>0L</td>
 * <td>Long integer</td>
 * <td>8 octets (64 bit)</td>
 * <td>yes</td>
 * </tr>
 * <tr>
 * <td>float</td>
 * <td>0.0f</td>
 * <td>Float number</td>
 * <td>4 octets IEEE 754 floating point (32 bit)</td>
 * <td>yes</td>
 * </tr>
 * <tr>
 * <td>double</td>
 * <td>0.0d</td>
 * <td>Double precision float number</td>
 * <td>8 octets IEEE 754 floating point (64 bit)</td>
 * <td>yes</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * @author syncrase
 *
 */
public class Types {

	public static void main(String[] args) {

//		Chars.playWithChars();

//		Bytes.playWithBytes();
//		Shorts.playWithShorts();
//		Ints.playWithInts();
//
		Longs.playWithLongs();
//		Floats.playWithFloats();
//		Floats.playWithFloats();
//		Doubles.playWithDoubles();

	}
}
