package javaFundamentalsCorePlatform.designpattern.structural.decorator.decorated;

import fr.exp.patterns.structural.decorator.impl.Coffee;
import fr.exp.patterns.structural.decorator.impl.CoffeeDecorator;

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
