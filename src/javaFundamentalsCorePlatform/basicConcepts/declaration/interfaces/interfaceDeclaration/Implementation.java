package javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.interfaceDeclaration;

public class Implementation implements IExampleInterface {

	/*
	 * Test code
	 */
	public static void main(String arg[]) {
		// Use of method defined in the interface
		Implementation vehicle = new Implementation();
		System.out.println(vehicle.getString());

		// Use the anonymous class declaration to instantiate directly the interface
		IExampleInterface ia = new IExampleInterface() {

			public void testCalls() {
				String a0 = this.MY_STRING;
				String a1 = this.MY_FINAL_STRING;
				String a2 = this.MY_STATIC_FINAL_STRING;
				String a3 = this.MY_PUBLIC_STATIC_FINAL_STRING;
				int i = IExampleInterface.getSomething();
				int i1 = IExampleInterface.getOtherthing();
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
			public int getAbstractInt() {
				return 0;
			}

			@Override
			public int getPublicAbstracInt() {
				return 0;
			}

		};
		System.out.println(ia.getPublicAbstracInt());

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
