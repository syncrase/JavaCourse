package javaFundamentalsCorePlatform.designpattern.structural.decorator.decorated;

import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.Coffee;
import javaFundamentalsCorePlatform.designpattern.structural.decorator.impl.CoffeeDecorator;

public class Milk extends CoffeeDecorator {
	public Milk(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	public double getCost() { // overriding methods defined in the abstract
								// superclass
		return super.getCost() + 0.5;
	}

	public String getIngredients() {
		return super.getIngredients() + ingredientSeparator + "Milk";
	}
}
