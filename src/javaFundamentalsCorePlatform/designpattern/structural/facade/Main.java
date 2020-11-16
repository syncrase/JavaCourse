package javaFundamentalsCorePlatform.designpattern.structural.facade;

import javaFundamentalsCorePlatform.designpattern.structural.facade.container.Computer;

public class Main {

	public static void main(String[] args) {
		Computer facade = new Computer();
        facade.start();

	}

}
