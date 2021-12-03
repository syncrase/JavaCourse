package javaFundamentalsCorePlatform.basicConcepts.flowcontrol.ifcondition;

import java.util.Random;

/**
 * If best practices : <br>
 * using lots of if statements could be an antipattern, making the code worse to read, debug and maintain<br>
 * Do not nest if statementss<br>
 * Use Guards clauses<br>
 * If statements can often be replaced by switch statement or Map
 */
public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt();
        if (num > 0) {
            System.out.println("The number is positive");
        }
    }

}
