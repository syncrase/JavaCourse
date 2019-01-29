package javaFundamentalsCorePlatform.syntax.forloop;

public class For {

	private Boolean key = false;
	private Integer iterationCount = 0;

	public void forLoop() {
		iterationCount = 0;
		for (initialization(); check(); betweenContentAndCheck()) {
			iterationCount++;
			content();
		}

	}

	private Boolean check() {
		System.out.println("check{" + iterationCount + "}");
		// Return false if you want to quit the loop
		return key;
	}

	private void initialization() {
		System.out.println("initialization{" + iterationCount + "}");
		key = true;
	}

	/*
	 * Contain the exit condition
	 */
	private void betweenContentAndCheck() {
		System.out.println("betweenContentAndCheck{" + iterationCount + "}");
		if (iterationCount > 1) {
			key = false;
		}
	}

	private void content() {
		//
		System.out.println("\tcontent{" + iterationCount + "}");
	}

}
