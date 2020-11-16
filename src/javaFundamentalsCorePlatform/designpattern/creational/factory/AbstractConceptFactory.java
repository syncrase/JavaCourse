package javaFundamentalsCorePlatform.designpattern.creational.factory;

public abstract class AbstractConceptFactory {

	/*
	 * Dans un pattern factory : Les constructeurs utilisés sont soient des
	 * constructeurs privés soient des classes internes privées
	 */
	public static AbstractConceptFactory getAbstactConcept() {
		// Decide which type to instanciate
		// Ici il faut décider laquelle j'instancie => implémenter la condition
		return new ConcreteConcept1();
		// return new ConcreteConcept2();
	}

	public abstract boolean is();

	public abstract String toString();

	public double sum(double d1, double d2) {
		return d1 + d2;
	}

	// We'll make it protected so that subclasses can see it
	protected String sayHello() {
		return "Hello, I'm an abstract class";
	}

	private static class ConcreteConcept1 extends AbstractConceptFactory {

		ConcreteConcept1() {

		}

		@Override
		public boolean is() {
			return false;
		}

		@Override
		public String toString() {
			return "ConcreteConcept1";
		}

		@Override
		public String sayHello() {
			return "Hello, I'm an ConcreteConcept1 class";
		}

	}

	private static class ConcreteConcept2 extends AbstractConceptFactory {

		ConcreteConcept2() {

		}

		@Override
		public boolean is() {
			return true;
		}

		@Override
		public String toString() {
			return "ConcreteConcept2";
		}

		@Override
		public String sayHello() {
			return "Hello, I'm an ConcreteConcept2 class";
		}

	}

}
