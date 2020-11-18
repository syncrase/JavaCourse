package javaFundamentalsCorePlatform.basicConcepts.runtimeTypeAndReflection;

public class Class2 extends Class1 {

	String info;

//	public Class2(String... info) {
//		this.info = "";
//		Arrays.asList(info).forEach(str -> this.info += str);
//	}

	public Class2(String info) {
		this.info = info;
	}
//
//	public Class2() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public void printInfo() {
		System.out.println(this.info);
	}

}
