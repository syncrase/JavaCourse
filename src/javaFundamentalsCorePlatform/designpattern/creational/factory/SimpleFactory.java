package javaFundamentalsCorePlatform.designpattern.creational.factory;

public class SimpleFactory {

	public static AbstractConceptFactory getNewSimpleFactory() {
		// The real goal of this patern is to let the factory decide which type
		// instanciate
		// Maintenance : Since this logger is used everywhere you’ll need to
		// modify hundreds of functions/classes whereas using a factory you
		// could easiliy switch from one implementation to another by modifying
		// only the factory

		// Any change in AbstractConceptFactory is invisible for the client (business) code since the
		// client code use an interface

		// return new SimpleFactory();

		AbstractConceptFactory concept = AbstractConceptFactory.getAbstactConcept();

		return AbstractConceptFactory.getAbstactConcept();

	}

	private SimpleFactory() {

	}

}
