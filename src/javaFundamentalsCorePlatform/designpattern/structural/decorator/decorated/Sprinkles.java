package javaFundamentalsCorePlatform.designpattern.structural.decorator.decorated;

import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.Coffee;
import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.CoffeeDecorator;

public class Sprinkles extends CoffeeDecorator {
	public Sprinkles(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	public double getCost() {
		return super.getCost() + 0.2;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Sprinkles";
	}
}
