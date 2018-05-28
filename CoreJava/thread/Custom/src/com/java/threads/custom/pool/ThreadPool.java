package com.java.threads.custom.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	//List
	//Worker threads
	private int capacity;
	private BlockingQueue<Runnable> taskQueue;
	private WorkerThread[] workerThread;
	
	public ThreadPool(int capacity) {
		this.capacity = capacity;
		workerThread = new WorkerThread[this.capacity];
		
		taskQueue = new LinkedBlockingQueue<Runnable>();
		for(int i =0; i < this.capacity; i++) {
			workerThread[i] = new WorkerThread(String.valueOf(i), taskQueue);
			workerThread[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized(this.taskQueue) {
			this.taskQueue.add(task);
			this.taskQueue.notify();
		}
		
	}
	
}
