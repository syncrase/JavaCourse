package javaFundamentalsCorePlatform.basicConcepts.objectOriented.interfaces.interfaceDeclaration;

public class Implementation implements IExampleInterface {

	/*
	 * Test code
	 */
	public static void main(String arg[]) {
		// Use of method defined in the interface
		Implementation vehicle = new Implementation();
		System.out.println(vehicle.getString());

		// Use the anonymous method declaration to instantiate directly the interface
		IExampleInterface ia = new IExampleInterface() {

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
