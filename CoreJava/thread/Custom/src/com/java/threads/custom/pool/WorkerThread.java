package com.java.threads.custom.pool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread{

	private BlockingQueue<Runnable> taskQueue;
	
	public WorkerThread(String threadName, BlockingQueue<Runnable> taskQueue) {
		super(threadName);
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while(true){
			Runnable task = null;
			synchronized(this.taskQueue) {
				while(this.taskQueue.isEmpty()) {
					try {
						this.taskQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				task = this.taskQueue.poll();
			}
			task.run();
		}
	}

}
