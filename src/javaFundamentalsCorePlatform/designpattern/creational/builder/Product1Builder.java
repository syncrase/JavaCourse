package javaFundamentalsCorePlatform.designpattern.creational.builder;

public class Product1Builder extends ProductBuilderABSTRACT {

	@Override
	public void buildType1() {
		this.product.setType1("type1 for product 1");
	}

	@Override
	public void buildType2() {
		this.product.setType2("type2 for product 1");
	}

	@Override
	public void buildType3() {
		this.product.setType3("type3 for product 1");
	}

}
