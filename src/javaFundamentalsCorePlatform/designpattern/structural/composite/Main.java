package javaFundamentalsCorePlatform.designpattern.structural.composite;

public class Main {
	public static void main(String[] args) {
		
		// Initialize three composite graphics
		CompositeGraphic globaGraphic = new CompositeGraphic("graphic");
		
		CompositeGraphic graphic1 = new CompositeGraphic("graphic1");
		graphic1.add(new EllipseLEAF("ellipse1"));
		graphic1.add(new EllipseLEAF("ellipse2"));
		graphic1.add(new EllipseLEAF("ellipse3"));
		globaGraphic.add(graphic1);
		
		CompositeGraphic graphic2 = new CompositeGraphic("graphic2");
		graphic2.add(new EllipseLEAF("ellipse4"));
		globaGraphic.add(graphic2);
		// Prints the complete graphic (four times the string "Ellipse").
		globaGraphic.print();
	}
}
