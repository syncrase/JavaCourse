package javaFundamentalsCorePlatform.basicConcepts.objectOriented;

import javaFundamentalsCorePlatform.basicConcepts.objectOriented.IVehicle.RoadCondition;
import javaFundamentalsCorePlatform.basicConcepts.objectOriented.IVehicle.TireCondition;

public class Vehicle implements IVehicle {
	private int weightPounds;

	public Vehicle(int weightPounds) {
		this.weightPounds = weightPounds;
	}

	@Override
	public int getWeightPounds() {
		return weightPounds;
	}

	/*
	 * Test code
	 */
	public static void main(String arg[]) {
		double timeSec = 10.0;
		int engineHorsePower = 246;
		int vehicleWeightPounds = 4000;
		Vehicle vehicle = new Vehicle(vehicleWeightPounds);
		System.out.println("Vehicle speed (" + timeSec + " sec) = "
				+ vehicle.getSpeedMph(timeSec, engineHorsePower, RoadCondition.SNOW, TireCondition.NEW) + " mph");

		// Override the getSpeedMph implementation
		vehicle = new Vehicle(vehicleWeightPounds) {
			@Override
			public double getSpeedMph(double timeSec, int horsePower, RoadCondition roadCondition,
					TireCondition tireCondition) {
				return -1.0d;
			}
		};

		System.out.println("Vehicle speed (" + timeSec + " sec) = "
				+ vehicle.getSpeedMph(timeSec, engineHorsePower, RoadCondition.SNOW, TireCondition.NEW) + " mph");

//		for (RoadCondition v : RoadCondition.values()) {
//			System.out.println(v + " => " + v.getValue());
//			System.out.println(RoadCondition.SNOW.equals(v));
//		}
	}
}
