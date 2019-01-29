package javaFundamentalsCorePlatform.designpattern.structural.decorator.decorated;

import fr.exp.patterns.structural.decorator.impl.Coffee;
import fr.exp.patterns.structural.decorator.impl.CoffeeDecorator;

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
