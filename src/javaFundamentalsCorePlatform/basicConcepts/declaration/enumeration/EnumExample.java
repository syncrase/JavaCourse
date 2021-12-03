package javaFundamentalsCorePlatform.basicConcepts.declaration.enumeration;

public class EnumExample {

    public static void main(String[] args) {

        System.out.println(SimpleEnum.P1);
        System.out.println(SimpleEnum.P2);
        System.out.println(SimpleEnum.values());
        System.out.println("P1");
        System.out.println(SimpleEnum.valueOf("P1").name());
        System.out.println(SimpleEnum.valueOf("P1").ordinal());

        String myVar = "P1";
        switch (SimpleEnum.valueOf(myVar)) {
            case P1:
                break;
            case P2:
                break;
            default:
                break;
        }

        // Print all values
        for (CompleteEnum v : CompleteEnum.values()) {
            System.out.println(v + "(" + v.getCoef() + ", " + v.getDesc() + ")");
//			System.out.println(RoadCondition.SNOW.equals(v));
        }

        // Test the label getter
        System.out.println(CompleteEnum.valueOfDesc("enneigé"));
        System.out.println(CompleteEnum.valueOfCoef(1.0));
        System.out.println(CompleteEnum.DRY);
        System.out.println(CompleteEnum.valueOf("DRY").getDesc());
//		System.out.println(">" + RoadCondition.SNOW.instanceValue);
    }

}

