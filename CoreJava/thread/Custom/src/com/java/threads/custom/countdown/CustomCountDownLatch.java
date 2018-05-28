package com.java.threads.custom.countdown;

import java.util.concurrent.TimeUnit;

public class CustomCountDownLatch {

	private int count;
	
	public CustomCountDownLatch(int count) {
		this.count = count;
	}
	
	public synchronized void await()throws InterruptedException{
		//If count is greater than 0, thread waits.
		if(this.count > 0) {
			this.wait();
		}
	}
	
	public void await(long timeout, TimeUnit time) {
				
	}
	
	public synchronized void countDown() {
		this.count--;
		//If count is equal to 0, notify all waiting threads.
		if(this.count == 0) {
			this.notifyAll();
		}
	}
	
	public int getCount() {
		return this.count;
	}
}
