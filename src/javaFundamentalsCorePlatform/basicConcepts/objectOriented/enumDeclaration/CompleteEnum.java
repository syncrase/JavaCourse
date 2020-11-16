package javaFundamentalsCorePlatform.basicConcepts.objectOriented.enumDeclaration;

import java.util.HashMap;
import java.util.Map;

public enum CompleteEnum {
	// list of constructors
	DRY(1.0, "sec", MethodsEnum.SET_OF_METHODS), //
	WET(0.2, "mouillé", MethodsEnum.ANOTHER_SET_OF_METHODS), //
	SNOW(0.04, "enneigé", MethodsEnum.SET_OF_METHODS);

	private final double coef;
	private final String desc;
	public MethodsEnum methode;

	/**
	 * An enum contructor is always private. Can't be modified to public
	 * 
	 * @param coef
	 * @param desc
	 */
	CompleteEnum(double coef, String desc, MethodsEnum methode) {
		this.coef = coef;
		this.desc = desc;
		this.methode = methode;
	}

	public double getCoef() {
		return this.coef;
	}

	public String getDesc() {
		return desc;
	}

	/*
	 * The way to get the label of an enum item
	 */

	private static final Map<String, CompleteEnum> BY_DESC = new HashMap<>();
	private static final Map<Double, CompleteEnum> BY_COEF = new HashMap<>();

	static {
		// In the case of the enum, this static block is called after all the instance
		// initialization. This block musn't be called before all ?
		for (CompleteEnum e : CompleteEnum.values()) {
			BY_DESC.put(e.desc, e);
			BY_COEF.put(e.coef, e);
		}
	}

	public static CompleteEnum valueOfDesc(String label) {

		final CompleteEnum value = BY_DESC.get(label);
		return value != null ? value : new Object() {
			public CompleteEnum exception() {
				throw new IllegalArgumentException("Symbole incconu : ");
			}
		}.exception();
	}

	public static CompleteEnum valueOfCoef(double coef) {

		final CompleteEnum value = BY_COEF.get(coef);
		if (value != null) {
			return value;
		}
		throw new IllegalArgumentException("Coef incconu : " + coef);
	}

}

enum SimpleEnum {
	P1("a"), P2("b");

	private final String val;

	private SimpleEnum(String value) {
		this.val = value;
	}

	public String getVal() {
		return val;
	}
}

enum MethodsEnum {
	SET_OF_METHODS {

		@Override
		public void method() {
			System.out.println("first enum constant behavior!");
		}

		@Override
		public void method2() {
			System.out.println("first enum constant behavior!");
		}
	},
	ANOTHER_SET_OF_METHODS {
		@Override
		public void method() {
			System.out.println("second enum constant behavior!");
		}

		@Override
		public void method2() {
			System.out.println("first enum constant behavior!");
		}
	};

	public abstract void method(); // could also be in an interface that MyEnum implements

	public abstract void method2(); // could also be in an interface that MyEnum implements
}
