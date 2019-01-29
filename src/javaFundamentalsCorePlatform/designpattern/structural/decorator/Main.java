package javaFundamentalsCorePlatform.designpattern.structural.decorator;

import fr.exp.patterns.structural.decorator.decorated.Milk;
import fr.exp.patterns.structural.decorator.decorated.Sprinkles;
import fr.exp.patterns.structural.decorator.decorated.Whip;
import fr.exp.patterns.structural.decorator.impl.Coffee;
import fr.exp.patterns.structural.decorator.impl.SimpleCoffee;

public class Main {

	public static void main(String[] args) {

		Coffee c = new SimpleCoffee();
		System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
		c = new Milk(c);
		System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
		c = new Sprinkles(c);
		System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
		c = new Whip(c);
		System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
		// Note that you can also stack more than one decorator of the same type
		c = new Sprinkles(c);
		System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());

	}

}
