package javaFundamentalsCorePlatform.designpattern.structural.decorator.decorated;

import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.Coffee;
import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.CoffeeDecorator;

public class Whip extends CoffeeDecorator {
	public Whip(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	public double getCost() {
		return super.getCost() + 0.7;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Whip";
	}
}
