package javaFundamentalsCorePlatform.basicConcepts.objectOriented;

public class Implementation implements IExampleInterface {

	/*
	 * Test code
	 */
	public static void main(String arg[]) {
		Implementation vehicle = new Implementation();
		System.out.println(vehicle.getString());
	}

	@Override
	public int getAbstractInt() {
		return 0;
	}

	@Override
	public int getInt() {
		return 0;
	}

	@Override
	public int getPublicInt() {
		return 0;
	}

	@Override
	public int getPublicAbstracInt() {
		return 0;
	}

}
