package javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl;

/**
 * 
 * 
 * @author syncrase
 *
 */
public class Builder1 extends AbstractBuilder {

	private ToBeBuilt1 product;

	@Override
	protected void performLogic1() {
		this.product.setType1("type1 for builder 1 by impl1");
		System.out.println("perform 1");
	}

	@Override
	protected void performLogic2() {
		this.product.setB((byte) 123);
		this.product.setI(10);
	}

	@Override
	protected void performLogic3() {
		this.product.setB((byte) 123);
		this.product.setType1("type1 for builder 1 by impl3");
		System.out.println("perform 3");
	}

	@Override
	protected void init() {
		this.product = new ToBeBuilt1();
	}

	@SuppressWarnings("unchecked")
	public ToBeBuilt1 getResult() {
		return this.product;
	}

	public class ToBeBuilt1 {

		private String type1;
		private int i;
		private byte b;

		public void setType1(String type1) {
			this.type1 = type1;
		}

		public String getType1() {
			return type1;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public byte getB() {
			return b;
		}

		public void setB(byte b) {
			this.b = b;
		}

		@Override
		public String toString() {
			return "{ " + type1 + " ; " + i + " ; " + b + " }";
		}
	}

}
