package javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl;

public class Builder2 extends AbstractBuilder {

	private ToBeBuilt2 product;

	@Override
	protected void performLogic1() {
		this.product.setType1("type1 for builder 2 by impl1");
		this.product.setType2("type2 for builder 2 by impl1");
		System.out.println("perform 1");
	}

	@Override
	protected void performLogic2() {
		this.product.setType2("type2 for builder 2 by impl2");
		this.product.setType3("type3 for builder 2 by impl2");
	}

	@Override
	protected void performLogic3() {
		this.product.setType3("type3 for builder 2 by impl3");
		this.product.setType1("type1 for builder 2 by impl3");
		System.out.println("perform 3");
	}

	@Override
	protected void init() {
		this.product = new ToBeBuilt2();
	}

	@SuppressWarnings("unchecked")
	public ToBeBuilt2 getResult() {
		return this.product;
	}

	public class ToBeBuilt2 {

		private String type1;
		private String type2;
		private String type3;

		public void setType1(String type1) {
			this.type1 = type1;
		}

		public void setType2(String type2) {
			this.type2 = type2;
		}

		public void setType3(String type3) {
			this.type3 = type3;
		}

		public String getType1() {
			return type1;
		}

		public String getType2() {
			return type2;
		}

		public String getType3() {
			return type3;
		}

		@Override
		public String toString() {
			return "{ " + type1 + " ; " + type2 + " ; " + type3 + " }";
		}

	}

}
