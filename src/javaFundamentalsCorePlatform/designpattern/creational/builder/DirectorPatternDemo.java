package javaFundamentalsCorePlatform.designpattern.creational.builder;

import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.AbstractBuilder.ToBeBuilt;
import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.AbstractBuilder;
import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.Builder1;
import javaFundamentalsCorePlatform.designpattern.creational.builder.builders.Builder2;

public class DirectorPatternDemo {

	public static void main(String[] args) {

		// Builder pattern using Director class
		final BuildDirectedByDev pd = new BuildDirectedByDev();

		pd.setProductBuilder(new Builder1());
		pd.constructMandatoryProduct();
		final ToBeBuilt p1 = pd.getProduct();
		System.out.println("Product 1 :");
		System.out.println(p1.getType1());
		System.out.println(p1.getType2());
		System.out.println(p1.getType3());

		pd.setProductBuilder(new Builder2());
		pd.constructMandatoryProduct();
		final ToBeBuilt p2 = pd.getProduct();
		System.out.println("Product 2 :");
		System.out.println(p2.getType1());
		System.out.println(p2.getType2());
		System.out.println(p2.getType3());

		//
		// Builder pattern using directly builders
		AbstractBuilder builderImpl = new Builder2();
		builderImpl.createNewProduct();
		builderImpl.performBuild1();
		builderImpl.performBuild2();
		builderImpl.performBuild3();

		// We can override performBuildX method via anonymous method
	}

}
