package javaFundamentalsCorePlatform.logSystem;

public class SystemOut {

	public static void main(String[] args) {
		Pojo p1 = new Pojo();
		System.out.println(p1);

		Pojo p2 = new Pojo();
		Pojo p3 = new Pojo();
		System.out.printf("%s, %s, %s", p1, p2, p3);

		System.out.print(System.getProperty("line.separator"));
	}

}

class Pojo {

	@Override
	public String toString() {
		return "0";
	}

}
