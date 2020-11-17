package javaFundamentalsCorePlatform.designpattern.creational.builder.nBuildersByTBB;

public class Builder2 extends AbstractBuilder {

	@Override
	public void performBuild1() {
		this.product.setType1("type1 for product 2");
	}

	@Override
	public void performBuild2() {
		this.product.setType2("type2 for product 2");
	}

	@Override
	public void performBuild3() {
		this.product.setType3("type3 for product 2");
	}

}
