package javaFundamentalsCorePlatform.basicConcepts.flowcontrol.whileloop;

/**
 * Mainly used for iterate over iterators<br>
 * No specific complexity on while statement
 */
public class Main {
    public static void main(String[] args) {

        int i = 0;

        atLeastOne(i);

        atLeastZero(i);

    }

    private static void atLeastZero(int i) {
        while (i < 5) {
            System.out.println(i);
            i++;
        }
    }

    private static void atLeastOne(int i) {
        do {
            i++;
            System.out.println(i);
        } while (i < 5);
    }
}
