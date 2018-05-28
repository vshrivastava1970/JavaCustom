package com.syne.java.exceptions;

import java.io.IOException;

public class TestExceptions {

	//try with resources & AutoCloseable java 7 (example & class hierarchy)
	public void autoCloseableResource() throws IOException {
		DemoTryWithResource demoTryWithResource = new DemoTryWithResource();
		demoTryWithResource.writeUsingBufferWriter();
		demoTryWithResource.readUsingBufferReader();
	}
	
	public static void main(String[] args) throws IOException {
	
		TestExceptions testException = new TestExceptions();
		testException.autoCloseableResource();
	}
}
