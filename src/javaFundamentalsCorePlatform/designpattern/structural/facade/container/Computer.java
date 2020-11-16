package javaFundamentalsCorePlatform.designpattern.structural.facade.container;

import javaFundamentalsCorePlatform.designpattern.structural.facade.content.CPU;
import javaFundamentalsCorePlatform.designpattern.structural.facade.content.HardDrive;
import javaFundamentalsCorePlatform.designpattern.structural.facade.content.Memory;

//Facade
public class Computer {

	private CPU processor;
	private Memory ram;
	private HardDrive hd;

	public Computer() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	public void start() {
		processor.freeze();
		long BOOT_ADDRESS = 1;
		long BOOT_SECTOR = 1;
		int SECTOR_SIZE = 1;
		byte[] data = hd.read(BOOT_SECTOR, SECTOR_SIZE);

		ram.load(BOOT_ADDRESS, data);
		processor.jump(BOOT_ADDRESS);
		processor.execute();
	}

}
