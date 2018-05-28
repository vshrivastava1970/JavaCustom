package com.syne.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private int threadCount;
	private WorkerThread[] workers;
	private LinkedBlockingQueue<Runnable> taskQueue;
	
	public ThreadPool(int noOfThreds) {
		this.threadCount = noOfThreds;
		this.workers = new WorkerThread[this.threadCount];
		
		this.taskQueue = new LinkedBlockingQueue<Runnable>();
		
		for(int i=0; i < this.threadCount; i++){
			this.workers[i] = new WorkerThread("Thread-"+i, this.taskQueue);
			this.workers[i].start();
		}
	}

	public void execute(Runnable task){
		synchronized (this.taskQueue){
			this.taskQueue.add(task);
			this.taskQueue.notify();
		}
	}
}
