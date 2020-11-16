package javaFundamentalsCorePlatform.designpattern.structural.composite;

public class EllipseLEAF implements GraphicComponent {

	private String name;

	public EllipseLEAF(String name) {
		this.name = name;
	}

	@Override
	public void print() {
		System.out.println("Ellipse " + name);
	}

}
