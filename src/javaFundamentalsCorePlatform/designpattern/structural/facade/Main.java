package javaFundamentalsCorePlatform.designpattern.structural.facade;

import fr.exp.patterns.structural.facade.container.Computer;

public class Main {

	public static void main(String[] args) {
		Computer facade = new Computer();
        facade.start();

	}

}
