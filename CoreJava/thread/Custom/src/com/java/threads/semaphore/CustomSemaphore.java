package com.java.threads.semaphore;

public class CustomSemaphore {
	//private int limit;
	private int permit;
	
	public CustomSemaphore(int permit) {
		this.permit = permit;
		//this.limit = permit;
	}
	
	public synchronized void acquire() throws InterruptedException {
		
		while(this.permit <= 0) {
			this.wait();
		}
		
		this.permit--;
		
	}
	
	public synchronized void release() {
		
		this.permit++;
		if(this.permit > 0)
			this.notifyAll();
	}
	
	/*public synchronized void release() {
		if(this.permit < this.limit) {
			this.permit++;
		}else {
			this.permit = this.limit;
		}
		this.notifyAll();
	}*/
}
