package javaFundamentalsCorePlatform.basicConcepts.flowcontrol.switchdispatcher;

/**
 * Best practice : https://refactoring.guru/fr/smells/switch-statements <br>
 * Switch statements can be removed with polymorphism
 */
public class Main {

    public static void main(String[] args) {
        stringBased();
        enumBased();

    }

    private static void enumBased() {
        switch (MyEnum.valueOf("myVar")) {
            case P1:
                doSomething(MyEnum.P1.getVal());
                break;
            case P2:
                doSomething(MyEnum.P2.name());
                break;
            default:
                break;
        }
    }

    private static void stringBased() {
        String s = "";
        switch (s) {
            case "0":
                doSomething(s);
                break;
            case "1":
                doSomething(s + s);
                break;
            default:
                break;
        }
    }

    private static void doSomething(String s) {
        System.out.println(s);
    }

}

enum MyEnum {
    P1("a"), P2("b");

    private final String val;

    private MyEnum(String value) {
        this.val = value;
    }

    public String getVal() {
        return val;
    }
}