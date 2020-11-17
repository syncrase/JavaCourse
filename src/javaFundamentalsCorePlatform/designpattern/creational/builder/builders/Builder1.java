package javaFundamentalsCorePlatform.designpattern.creational.builder.builders;


/**
 * 
 * 
 * @author syncrase
 *
 */
public class Builder1 extends AbstractBuilder {

	@Override
	public void performBuild1() {
		this.product.setType1("type1 for builder 1 by impl1");
		this.product.setType2("type2 for builder 1 by impl1");
	}

	@Override
	public void performBuild2() {
		this.product.setType2("type2 for builder 1 by impl2");
		this.product.setType3("type3 for builder 1 by impl2");
	}

	@Override
	public void performBuild3() {
		this.product.setType3("type3 for builder 1 by impl3");
		this.product.setType1("type1 for builder 1 by impl3");
	}

}
