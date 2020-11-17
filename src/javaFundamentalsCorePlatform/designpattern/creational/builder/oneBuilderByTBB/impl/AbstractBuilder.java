package javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl;

/**
 * The builder contains a set of shared methods which can be used in the
 * director only (because of the protected).
 * 
 * @author syncrase
 *
 */
public abstract class AbstractBuilder {

	protected abstract void init();

	protected abstract void performLogic1();

	protected abstract void performLogic2();

	protected abstract void performLogic3();

	public abstract <T> T getResult();
}