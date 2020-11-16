package javaFundamentalsCorePlatform.basicConcepts.objectOriented;

import javaFundamentalsCorePlatform.basicConcepts.objectOriented.markerInterface.MarkerInterface;

public interface IVehicle extends MarkerInterface {

	/******************************************************************************
	 * Traditional use of interface. Just declaring signatures. <br>
	 * These method are implicitly abstract & public
	 ******************************************************************************/

	int getZero();

	public int myMethod();

	abstract int getWeightPounds();

	public abstract int getOne();

	/*
	 * public, abstract, default, static and strictfp
	 */

	/******************************************************************************
	 * Interface can declare default methods<br>
	 * These method are implicitly public
	 ******************************************************************************/

	/**
	 * <h2>Returns the max speed based on conditions</h2> <br>
	 * <article>
	 * <h3>If life would be often that easy</h3>
	 * <p>
	 * a paragraph
	 * </p>
	 * <p>
	 * The new signature demonstrates extensible design of an interface.
	 * </p>
	 * </article> <br>
	 * <aside>
	 * <p>
	 * A few other examples could be found <a href="http://www.google.com">here</a>.
	 * </p>
	 * </aside>
	 * 
	 * @param timeSec
	 * @param horsePower
	 * @param roadCondition
	 * @param tireCondition
	 * @return
	 */
	default double getSpeedMph(double timeSec, int horsePower, RoadCondition roadCondition,
			TireCondition tireCondition) {

		getPrivateZero();

		// Because the Engine method is only called by the getSpeedMph method =>
		// method-local inner class
		class Engine {
			private int horsePower;

			private Engine(int horsePower) {
				this.horsePower = horsePower;
			}

			private double getSpeedMph(double timeSec) {
				double v = 2.0 * this.horsePower * 746;
				v = v * timeSec * 32.174 / getWeightPounds();
				return Math.round(Math.sqrt(v) * 0.68);
			}
		}
		Engine engine = new Engine(horsePower);
		return engine.getSpeedMph(timeSec) * roadCondition.getValue() * tireCondition.getValue();
	}

	/******************************************************************************
	 * Interface can declare private methods Available since Java 9
	 ******************************************************************************/

	private int getPrivateZero() {
		return 0;
	}

	/******************************************************************************
	 * Interface can declare static methods
	 ******************************************************************************/

	private static int getPrivateStaticZero() {
		return 0;
	}

	static int getSomething() {
		return getPrivateStaticZero();
	}

	/******************************************************************************
	 * Interface can declare public constants
	 ******************************************************************************/

	String MY_CONSTANT0 = "qsd";
	final String MY_CONSTANT1 = "qsd";
	static final String MY_CONSTANT2 = "qsd";
	public static final String MY_CONSTANT3 = "qsd";

	/******************************************************************************
	 * Interface can declare enums
	 ******************************************************************************/
	enum RoadCondition {
		DRY(1.0), WET(0.2), SNOW(0.04);

		private double value;

		RoadCondition(double value) {
			this.value = value;
		}

		public double getValue() {
			return this.value;
		}
	}

	enum TireCondition {
		NEW(1.0), WORN(0.2);

		private double value;

		TireCondition(double value) {
			this.value = value;
		}

		public double getValue() {
			return this.value;
		}
	}

}
