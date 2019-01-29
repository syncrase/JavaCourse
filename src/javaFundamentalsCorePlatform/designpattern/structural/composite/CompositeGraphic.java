package javaFundamentalsCorePlatform.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements GraphicComponent {

	// Collection of child graphics.
	private List<GraphicComponent> mChildGraphics = new ArrayList<GraphicComponent>();
	private String name;

	CompositeGraphic(String s) {
		this.name = s;
	}

	// Prints the graphic.
	public void print() {
		System.out.println("CompositeGraphic : " + name);
		for (GraphicComponent graphic : mChildGraphics) {
			graphic.print();
		}
	}

	// Adds the graphic to the composition.
	public void add(GraphicComponent graphic) {
		mChildGraphics.add(graphic);
	}

	// Removes the graphic from the composition.
	public void remove(GraphicComponent graphic) {
		mChildGraphics.remove(graphic);
	}
}
