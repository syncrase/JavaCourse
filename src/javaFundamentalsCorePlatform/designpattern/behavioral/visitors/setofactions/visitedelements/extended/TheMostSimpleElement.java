package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.extended;


import javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions.visitedelements.AbstractElement;

public class TheMostSimpleElement extends AbstractElement {

	public TheMostSimpleElement(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
