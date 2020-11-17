package javaFundamentalsCorePlatform.designpattern.creational.builder;

import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.AbstractBuilder;
import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.AbstractBuilder.ToBeBuilt;

public class BuildDirectedByDev {

	private AbstractBuilder builderImpl;

	public void setProductBuilder(final AbstractBuilder pb) {
		this.builderImpl = pb;
	}

	public ToBeBuilt getProduct() {
		return this.builderImpl.getProduct();
	}

	public void constructMandatoryProduct() {
		this.builderImpl.createNewProduct();
		this.builderImpl.performBuild1();
		this.builderImpl.performBuild2();
		this.builderImpl.performBuild3();
	}

	public void constructOptionalPart() {
//		this.prodBuilder.createNewProduct();
		this.builderImpl.performBuild1();
		this.builderImpl.performBuild2();
		this.builderImpl.performBuild3();
	}
}
