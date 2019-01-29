package javaFundamentalsCorePlatform.syntax.forloop;

public class Main {

	public static void main(String[] args) {
//		Main.test1();
		Main.test2();

	}

	public static void test1() {
		// Test1 t1 = Test1.getInstance();
		// System.out.println("ref : " + t1.getOBJECT_REFERENCE());
		//
		// Test1 t2 = Test1.getInstance();
		// System.out.println("ref : " + t2.getOBJECT_REFERENCE());
		//
		// Test1 t3 = Test1.getInstance();
		// Test1 t4 = Test1.getInstance();
		// System.out.println("ref : " + t4.getOBJECT_REFERENCE());
		//
		// System.out.println("Instance number : " +
		// Test1.getInstancesNumber());
		// Test1.removeInstance(t3);
		// System.out.println("Instance number : " +
		// Test1.getInstancesNumber());

		Test1 t5 = Test1.getInstance();

		// System.out.println("ref : " + t5.getOBJECT_REFERENCE());
		// System.out.println("Instance number : " +
		// Test1.getInstancesNumber());

		t5.forLoop();
	}

	public static void test2(){
		For loop = new For();
		loop.forLoop();
	}
	
}
