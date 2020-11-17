package javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl;

/**
 * The director have the ability to perform the same set of shared methods on
 * the unknown object contained in the builder
 * 
 * @author syncrase
 *
 */
public class Director {

	AbstractBuilder builder;

	public void setImplementationOfTheLogic(AbstractBuilder bld1) {
		this.builder = bld1;
	}

	/**
	 * Run some builder's method in a certain order
	 */
	public void applyLogicStrategy() {
		builder.init();
		builder.performLogic1();
		builder.performLogic2();
		builder.performLogic3();
	}

	/**
	 * Run some builder's method in an other order
	 */
	public void applyAnotherBuildStrategy() {
		builder.init();
		builder.performLogic1();
		builder.performLogic3();
	}

}
