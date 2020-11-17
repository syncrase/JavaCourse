package javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB;

import javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl.Builder2;
import javaFundamentalsCorePlatform.designpattern.creational.builder.oneBuilderByTBB.impl.Director;

public class ClientSide {

	public static void main(String[] args) {

		// Using the director
		Director director = new Director();

		// The director is just here to apply a set of methods declared in the Abstract
		// builder. Allow to apply a set of method in the object contained in the
		// builder
		Builder2 bld2 = new Builder2();
		director.setImplementationOfTheLogic(bld2);
		director.applyLogicStrategy();

		// Because we want to get a particular object (not an interface in common with
		// all of these), because objects are completely different
		// we need to call directly the builder
		Builder2.ToBeBuilt2 tbb2 = bld2.getResult();
		System.out.println(tbb2.toString());
		// Using builder directly is forbidden by protected keyword of builder shared
		// methods

	}

}
