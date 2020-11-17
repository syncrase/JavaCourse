package javaFundamentalsCorePlatform.designpattern.creational.builder.builders;

public abstract class AbstractBuilder {
	protected ToBeBuilt product;

	public abstract void performBuild1();

	public abstract void performBuild2();

	public abstract void performBuild3();

	public void createNewProduct() {
		this.product = new ToBeBuilt();
	}

	public ToBeBuilt getProduct() {
		return this.product;
	}
	
	public class ToBeBuilt {

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

	}
}
