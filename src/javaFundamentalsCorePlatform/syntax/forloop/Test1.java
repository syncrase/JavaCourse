/**
 * 
 */
package javaFundamentalsCorePlatform.syntax.forloop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author I310911
 *
 */
public class Test1 {

    //
    // CLASS METHOD
    //
    // No object : accessible via la classe ou via un objet
    private static int instanceCounter = 0;

    private static List<Test1> objectList = new ArrayList<Test1>();

    public static Test1 getInstance() {
        instanceCounter++;
        objectList.add(new Test1(instanceCounter));
        return objectList.get(objectList.size() - 1);
    }

    public static void removeInstance(Test1 obj) {
        objectList.remove(obj);
    }

    public static int getInstancesNumber() {
        return objectList.size();
    }

    //
    // TAXON METHOD
    //
    // Object : Uniquement accessible depuis un objet instancié

    // https://www.javacodegeeks.com/2015/09/built-in-serialization-techniques.html
    // http://www.theserverside.com/news/thread.tss?thread_id=81338
    private Test1(int oBJECT_REFERENCE) {
        super();
        OBJECT_REFERENCE = oBJECT_REFERENCE;
    }

    public int getOBJECT_REFERENCE() {
        return OBJECT_REFERENCE;
    }

    private final int OBJECT_REFERENCE;

    /**
     * https://www.javacodegeeks.com/2015/09/concurrency-best-practices.html
     */
    public void runThread(final int i) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Some implementation here
                System.out.println("i (in thread) = " + i);
            }
        }).start();

        // With Java 8 lambda function
        // new Thread(() -> {
        // /* Some implementation here */ }).start();

    }

    public void forLoop() {
        int i = 0;
        // for (System.out.println("Entering in for loop"); true ? true : !true;
        // new Thread(() -> {
        // /* Code implementation */}).start()) {
        // System.out.println("i (out thread) = " + i);
        // // exit condition
        // if (i == 10) {
        // break;
        // }
        // }

        // The first and last parameters of the for loop are just one line of
        // code
        // for (/* Initial assignation */; /* Boolean for another iteration */;
        /*
         * last execution of the iteration
         */
        // ) {
        // System.out.println("i (out thread) = " + i);
        // exit condition
        // if (i == 10) {
        // break;
        // }
        // }

        // While loop similar : while this expression is true!
        // The condition can be alterate either in the for loop header or in the
        // content
        // for (; true == !!true ? !false || true : !!true || false;) {
        // exit condition
        // if (i == 10) {
        // break;
        // }else{
        // continue;
        // }
        // }

        i = 0;
        // 1 method 1 : Any initialization
        // 2 check : continue to looping?
        // 3 execute content : for loop content (continue => goto method 2 ;
        // break => get out without execute method 2)
        // 4 method 2 : Executed method before the check
        // 5 check : true => continue looping
        for (this.initialization(); isLessOrEqualOf(i); executedAtTheEndOfEachLoop(i++)) {

            System.out.println("Get in iteration " + i);
        }

    }

    private Boolean isLessOrEqualOf(int i) {
        System.out.println("Check part");
        if (i > 5) {
            return false;
        }
        return true;
    }

    private void initialization() {
        System.out.println("Initial command line");
    }

    private void executedAtTheEndOfEachLoop(int i) {
        System.out.println("End of iteration " + i + " command line");
    }
}
